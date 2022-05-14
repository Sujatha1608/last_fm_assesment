package sampleproject.com.my.skeletonApp.feature.display

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import sampleproject.com.my.skeletonApp.rest.BadgeDataUseCase
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DisplayInfoViewModel @Inject constructor(
    private val dataSettUseCase: DatasetUseCase): ViewModel() {



    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()
    val startActivityEvent: StartActivityEvent = StartActivityEvent()
    var isFormValid = ObservableBoolean(false)
    var user_id = ObservableInt(0)

    var dataResultInfo = MutableLiveData<List<DataResultResponse>>()
    val list = mutableListOf<DataResultResponse>()
    lateinit var model: DataResultResponse

    var userName = ObservableString("")

    init {
        userName.observe().map { it?.isNotEmpty() }.subscribe { isFormValid.set(it!!)}
    }
    fun resultDetails():MutableLiveData<List<DataResultResponse>>{
         return dataResultInfo
    }
     fun onSearchClicked() {
             loadingDialogEvent.postValue(true)
             dataSettUseCase.execute(userName.get())
                 .subscribeBy(
                     onSuccess = {
                         userName.set("")
                         Timber.d { "api $it" }
                         loadingDialogEvent.postValue(false)
                         for (i in it.items!!) {
                             user_id.set(i.user_id!!)
                         }
                         list.clear()
                         for (i in it.items!!) {
                              user_id.set(i.user_id!!)
                             model = DataResultResponse(user_id = i.user_id,display_name = i.display_name,reputation = i.reputation.toString(),creation_date = getDate(i.creation_date.toLong()),avatar = i.profile_image)
                             list.add(model)
                             list.sortBy { it.display_name }


                         }
                         resultDetails().value=list
                     },
                     onError = {
                         errorEvent.postValue(it.message)
                         loadingDialogEvent.postValue(false)

                     })
                     }

    private fun getDate(epoc: Long): String? {
        try {
            val sdf = SimpleDateFormat("dd MMM yyyy")
            val netDate = Date(epoc*1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }


}
