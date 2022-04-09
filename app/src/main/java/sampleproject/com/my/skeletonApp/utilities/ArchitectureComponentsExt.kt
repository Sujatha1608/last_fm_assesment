package sampleproject.com.my.skeletonApp.utilities

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) = observe(owner, Observer<T> { v -> observer.invoke(v) })

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }