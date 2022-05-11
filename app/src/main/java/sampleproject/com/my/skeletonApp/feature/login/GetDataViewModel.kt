package sampleproject.com.my.skeletonApp.feature.login


import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import androidx.lifecycle.ViewModel
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.core.event.StartActivityModel
import javax.inject.Inject

class GetDataViewModel @Inject constructor() : ViewModel() {

    val startActivityEvent: StartActivityEvent = StartActivityEvent()

    fun onSampleLoginClicked() {
        startActivityEvent.value = StartActivityModel(Router.Destination.MAIN)
    }
}