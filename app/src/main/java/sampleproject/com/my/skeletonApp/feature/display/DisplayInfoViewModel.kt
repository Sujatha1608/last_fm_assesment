package sampleproject.com.my.skeletonApp.feature.display

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import sampleproject.com.my.skeletonApp.AppPreference
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import javax.inject.Inject


class DisplayInfoViewModel @Inject constructor( private val dataSettUseCase: DatasetUseCase, private val appPreference: AppPreference): ViewModel() {



    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()
    val startActivityEvent: StartActivityEvent = StartActivityEvent()
    val updateRecyclerViewAdapter = MutableLiveData<Boolean>()
    var isFormValid = ObservableBoolean(false)
    var user_id = ObservableInt(0)

    var dataResultInfo: MutableLiveData<MutableList<DataResultResponse>> = MutableLiveData(mutableListOf())
    val list = mutableListOf<DataResultResponse>()
    lateinit var model: DataResultResponse

    var userName = ObservableString("")

    init {
        userName.observe().map { it?.isNotEmpty() }.subscribe { isFormValid.set(it!!)}
    }
     fun onSearchClicked() {
         if (isFormValid.get()) {
             loadingDialogEvent.postValue(true)
             dataSettUseCase.execute(userName.get())
                 .subscribeBy(
                     onSuccess = {
                         userName.set("")
                         Timber.d { "api $it" }
                         loadingDialogEvent.postValue(false)
                         for (i in it.items!!) {
                             user_id.set(i.user_id!!)
                             model = DataResultResponse(user_id = i.user_id,display_name = i.display_name,reputation = i.reputation,creation_date = i.creation_date,avatar = i.profile_image)
                             updateRecyclerViewAdapter.postValue(true)
                             dataResultInfo.value!!.clear()
                             list.add(model)
                             dataResultInfo.value!!.addAll(list)

                         }
                     },
                     onError = { e ->
                         errorEvent.postValue(e.message.toString())
                         loadingDialogEvent.postValue(false)

                     }
                 )
         }
     }

}