package sampleproject.com.my.skeletonApp

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Process


class AppExceptionHandler(private val systemHandler: Thread.UncaughtExceptionHandler,
                          private val crashlyticsHandler: Thread.UncaughtExceptionHandler,
                          application: Application) : Thread.UncaughtExceptionHandler {

    private var lastStartedActivity: Activity? = null

    private var startCount = 0

    init {
        application.registerActivityLifecycleCallbacks(
                object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityPaused(activity: Activity) {
                        // empty
                    }

                    override fun onActivityResumed(activity: Activity) {
                        // empty
                    }

                    override fun onActivityStarted(activity: Activity) {
                        startCount++
                        lastStartedActivity = activity
                    }

                    override fun onActivityDestroyed(activity: Activity) {
                        // empty
                    }

                    override fun onActivitySaveInstanceState(activity: Activity,
                                                             outState: Bundle) {
                        // empty
                    }

                    override fun onActivityStopped(activity: Activity) {
                        startCount--
                        if (startCount <= 0) {
                            lastStartedActivity = null
                        }
                    }

                    override fun onActivityCreated(activity: Activity,
                                                   savedInstanceState: Bundle?) {
                        // empty
                    }
                })
    }


    override fun uncaughtException(t: Thread?, e: Throwable) {
//        e.printStackTrace()

        lastStartedActivity?.let { activity ->
                with(activity) {
                    finish()
                    startActivity(intent)
            }



        } ?: killThisProcess {
            crashlyticsHandler.uncaughtException(t, e)
            systemHandler.uncaughtException(t, e)
        }
    }
    private fun isSameException(originalException: Throwable,
                                lastException: Throwable?): Boolean {
        if (lastException == null) return false

        return originalException.javaClass == lastException.javaClass &&
                originalException.stackTrace[0] == originalException.stackTrace[0] &&
                originalException.message == lastException.message
    }

    private fun killThisProcess(action: () -> Unit = {}) {
        action()

        Process.killProcess(Process.myPid())
        System.exit(10)
    }

    companion object {
        private const val RESTARTED = "appExceptionHandler_restarted"
        private const val LAST_EXCEPTION = "appExceptionHandler_lastException"
    }
}