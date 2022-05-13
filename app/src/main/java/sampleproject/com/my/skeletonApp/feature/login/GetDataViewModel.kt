package sampleproject.com.my.skeletonApp.feature.login


import android.net.Uri
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import sampleproject.com.my.skeletonApp.core.event.StartActivityEvent
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import com.squareup.picasso.Picasso
import sampleproject.com.my.skeletonApp.core.Router
import sampleproject.com.my.skeletonApp.core.event.StartActivityModel
import sampleproject.com.my.skeletonApp.feature.display.DataResultResponse
import sampleproject.com.my.skeletonApp.utilities.ObservableBackground
import sampleproject.com.my.skeletonApp.utilities.ObservableString
import sampleproject.com.my.skeletonApp.utilities.observe
import java.io.File
import javax.inject.Inject

class GetDataViewModel @Inject constructor() : ViewModel() {


    val userModel = MutableLiveData<DataResultResponse>()
    var profile_url = ObservableString("")
    var user_id = ObservableInt(0)
    var isFormValid = ObservableBoolean(false)

     var model: DataResultResponse

    init {
        user_id.observe().map { it!=0 }.subscribe { isFormValid.set(it!!)}
        model= DataResultResponse(badges = "")

    }
    fun onSampleLoginClicked() {

    }
}