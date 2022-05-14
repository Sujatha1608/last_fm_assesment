package sampleproject.com.my.skeletonApp.feature.login


import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.feature.display.DataResultResponse
import sampleproject.com.my.skeletonApp.rest.BadgeDataUseCase
import sampleproject.com.my.skeletonApp.utilities.observe
import javax.inject.Inject

class GetDataViewModel @Inject constructor(private val dataBadgeDataUseCase: BadgeDataUseCase) : ViewModel() {


    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()
    var user_id = ObservableInt(0)
    var isFormValid = ObservableBoolean(false)

    lateinit var model: DataResultResponse

    init {
        user_id.observe().map { it!=0 }.subscribe { isFormValid.set(it)}
        onSampleLoginClicked()

    }

    private fun onSampleLoginClicked() {
        if (isFormValid.get()) {
            loadingDialogEvent.postValue(true)
            dataBadgeDataUseCase.execute(model.user_id.toString())
                .subscribeBy(
                    onSuccess = {
                        loadingDialogEvent.postValue(false)
                        for (i in it.items) {
                            model.location = i.location
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