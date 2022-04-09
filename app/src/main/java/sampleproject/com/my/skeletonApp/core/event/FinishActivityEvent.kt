package sampleproject.com.my.skeletonApp.core.event

import sampleproject.com.my.skeletonApp.core.Router
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer


open class FinishActivityEvent : SingleLiveEvent<FinishActivityEventModel>() {

    fun observe(owner: LifecycleOwner, observer: FinishActivityObserver){
        super.observe(owner, Observer { t ->
            if (t == null) {
                return@Observer
            }
            if(t.hasResults) {
                observer.onFinishActivityForResult(t)
            } else {
                observer.onFinishActivity(t)
            }
        })
    }

    interface FinishActivityObserver {
        fun onFinishActivity(data: FinishActivityEventModel)
        fun onFinishActivityForResult(data: FinishActivityEventModel)
    }

}


data class FinishActivityEventModel (val parameters: HashMap<Router.Parameter, Any?> = hashMapOf(), val hasResults : Boolean = false)