package sampleproject.com.my.skeletonApp.feature.login

import androidx.lifecycle.MutableLiveData
import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.GeneralRepository
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.core.event.StartActivityModel
import javax.inject.Inject

class GetDataViewModel @Inject constructor(
    private val schdulerProvider: SchedulerProvider,
    private val generalRepository: GeneralRepository, private val appPreference: AppPreference) : ViewModel() {

    val startActivityEvent: StartActivityEvent = StartActivityEvent()
    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()


    private fun callSampleLoginApi(): Single<SampleDataResponse>{
        return generalRepository.getData().compose(schdulerProvider.getSchedulersForSingle())
    }


    fun onSampleLoginClicked(){
      loadingDialogEvent.postValue(true)
          callSampleLoginApi().subscribeBy(onSuccess = {
              loadingDialogEvent.postValue(false)
              if (it.id!=null){
                  Timber.d{"Success for Data"}
                  startActivityEvent.value = StartActivityModel(
                      Router.Destination.MAIN,
                      hashMapOf(Pair(Router.Parameter.USERNAME, it.title),), hasResults = false)
              }

          }, onError = {e->
              errorEvent.postValue(e.message.toString())
          })
    }
}