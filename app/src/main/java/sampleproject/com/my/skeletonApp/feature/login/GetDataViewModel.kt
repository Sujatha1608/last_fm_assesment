package sampleproject.com.my.skeletonApp.feature.login


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sampleproject.com.my.skeletonApp.core.event.SingleLiveEvent
import sampleproject.com.my.skeletonApp.feature.display.DataResultResponse
import javax.inject.Inject

class GetDataViewModel @Inject constructor() : ViewModel() {


    val errorEvent = MutableLiveData<String>()
    val loadingDialogEvent = SingleLiveEvent<Boolean>()

    val model = MutableLiveData<DataResultResponse>()



}