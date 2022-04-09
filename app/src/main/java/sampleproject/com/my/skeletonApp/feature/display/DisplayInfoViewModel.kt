package sampleproject.com.my.skeletonApp.feature.display

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.database.DatabaseRepository
import sampleproject.com.my.skeletonApp.database.User
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.function.BiFunction
import javax.inject.Inject


class DisplayInfoViewModel @Inject constructor(private val databaseRepository: DatabaseRepository, private val appPreference: AppPreference): ViewModel() {

    var username = ObservableString("")

    init {
        username.observe().subscribe { setUserName(username.get().toString())}
    }

    private fun setUserName(username: String) {
        val user = User(username)
        Completable.fromAction{
            databaseRepository.insertUser(user)
        }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: CompletableObserver {
                override fun onComplete() {
                    Timber.d{"Success insert $username"}
                }

                override fun onSubscribe(d: Disposable) {
                    if(d.isDisposed) Timber.e{"DB Observable disposed"}
                }

                override fun onError(e: Throwable) {
                    Timber.e{e.message.toString()}
                }

            })
    }
}