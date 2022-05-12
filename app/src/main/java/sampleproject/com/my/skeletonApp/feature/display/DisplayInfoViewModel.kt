package sampleproject.com.my.skeletonApp.feature.display

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import sampleproject.com.my.skeletonApp.AppPreference
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import javax.inject.Inject


class DisplayInfoViewModel @Inject constructor( private val dataSettUseCase: DatasetUseCase, private val appPreference: AppPreference): ViewModel() {



    lateinit var callBack: ViewModelCallBack
    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()
    var isFormValid = ObservableBoolean(false)

    var dataResultInfo: MutableLiveData<MutableList<DataResultResponse>> = MutableLiveData(mutableListOf())
    val list = mutableListOf<DataResultResponse>()

    var userName = ObservableString("")

    init {
        userName.observe().map { it?.isNotEmpty() }.subscribe { isFormValid.set(it!!)}
    }
    interface ViewModelCallBack {
        fun updateRecyclerView(update: Boolean)

    }
     fun onSearchClicked() {
         if (isFormValid.get()) {
             loadingDialogEvent.postValue(true)
             dataSettUseCase.execute(userName.get())
                 .subscribeBy(
                     onSuccess = {
                         Timber.d { "api $it" }
                         loadingDialogEvent.postValue(false)
                         for (i in it.items!!) {
                             val model = DataResultResponse(display_name = i.display_name,Reputation = i.reputation,Creation_Date = i.creation_date)
                             list.add(model)
                             if (dataResultInfo.value!!.isNotEmpty()) {
                                 dataResultInfo.value!!.clear()
                             }
                             dataResultInfo.value!!.addAll(list)
                             callBack.updateRecyclerView(true)
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