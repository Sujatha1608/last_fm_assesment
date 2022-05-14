package sampleproject.com.my.skeletonApp.feature.login


import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.rest.BadgeDataUseCase
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import javax.inject.Inject

class GetDataViewModel @Inject constructor(private val dataBadgeDataUseCase: BadgeDataUseCase) : ViewModel() {


    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()
     var user_id = ObservableInt(0)
     var account_id = ObservableInt(0)

    var avatar = ObservableString("")
    var display_name = ObservableString("")
    var reputation = ObservableString("")
    var badges = ObservableString("")
    var location = ObservableString("")
    var creation_date = ObservableString("")


    init {
       user_id.observe().map { it!=0 }.subscribe{if(it) onSampleLoginClicked()}

    }

    private fun onSampleLoginClicked() {

            loadingDialogEvent.postValue(true)
            dataBadgeDataUseCase.execute(user_id.get().toString())
                .subscribeBy(
                    onSuccess = {
                        loadingDialogEvent.postValue(false)
                        for (i in it.items) {
                            display_name.set(i.display_name)
                            getGata(i.account_id)

                        }
                    },
                    onError = { e ->
                        errorEvent.postValue(e.message.toString())
                        loadingDialogEvent.postValue(false)

                    }
                )
        }

    private fun getGata(accountId: Int) {
        loadingDialogEvent.postValue(true)
        dataBadgeDataUseCase.execute(accountId.toString())
            .subscribeBy(
                onSuccess = {
                    loadingDialogEvent.postValue(false)
                    for (i in it.items) {

                        reputation.set(i.reputation.toString())
                        badges.set(i.badge_counts.toString())
                        location.set(i.location)
                    }
                },
                onError = { e ->
                    errorEvent.postValue(e.message.toString())
                    loadingDialogEvent.postValue(false)

                }
            )
    }

}