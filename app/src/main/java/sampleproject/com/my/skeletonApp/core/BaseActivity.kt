package sampleproject.com.my.skeletonApp.core

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import sampleproject.com.my.skeletonApp.R
import androidx.appcompat.view.ContextThemeWrapper


open class BaseActivity: AppCompatActivity() {

    private var loadingDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

//        if (toolbar == null) {
//            Timber.e { "Toolbar is null" }
//        }
//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupListeners()
    }

    private fun setupListeners() {
//        applicationContext.registerReceiver(connectionReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
//        connectionReceiver.setListener(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun startActivity(from: Context, to: Class<*>, parameters: HashMap<Router.Parameter, Any?> = hashMapOf(), clearHistory: Boolean = false, singleTask: Boolean = false) {
        val intent = Intent(from, to)
        if (singleTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        }
        if (clearHistory) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        if (parameters.isNotEmpty()) {
            intent.putExtras(parameters.bundle)
        }
        startActivity(intent)
    }

    fun startActivity(from: Context, to: Class<*>, parameters: HashMap<Router.Parameter, Any?> = hashMapOf(), clearHistory: Boolean = false, singleTask: Boolean = false, transition: Bundle) {
        val intent = Intent(from, to)
        if (singleTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        }
        if (clearHistory) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        if (parameters.isNotEmpty()) {
            intent.putExtras(parameters.bundle)
        }
        if (transition != Bundle.EMPTY) {
            startActivity(intent, transition)
        } else {
            startActivity(intent)
        }
    }

    fun startActivityForResult(from: Context, to: Class<*>, parameters: HashMap<Router.Parameter, Any?> = hashMapOf(), requestCode: Int, singleTask: Boolean = false) {
        val intent = Intent(from, to)
        if (singleTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        }
        if (parameters.isNotEmpty()) {
            intent.putExtras(parameters.bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    fun startActivityForResult(from: Context, to: Class<*>, parameters: HashMap<Router.Parameter, Any?> = hashMapOf(), requestCode: Int, singleTask: Boolean = false, transition: Bundle) {
        val intent = Intent(from, to)
        if (singleTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        }
        if (parameters.isNotEmpty()) {
            intent.putExtras(parameters.bundle)
        }
        if (transition != Bundle.EMPTY) {
            startActivityForResult(intent, requestCode, transition)
        } else {
            startActivityForResult(intent, requestCode)
        }
    }

    fun isLoadingDialogShown() =
        if (!isDestroyed && loadingDialog != null) loadingDialog!!.isShowing else false

    fun dismissLoadingDialog() {
        if (!isDestroyed && loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }

    fun showLoadingDialog() {
        if (!isDestroyed) {
            loadingDialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme_NoActionBar))
                .setCancelable(false)
                .setView(R.layout.loading_dialog)
                .show()
                .apply {
                    this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                }
        }
    }
}