package sampleproject.com.my.skeletonApp.utilities

import sampleproject.com.my.skeletonApp.utilities.observables.ObservableBackground
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("srcCompat")
fun setSrcCompat(view: ImageView, observable: ObservableBackground) {
    if (observable.mDrawableResource != null)
        observable.mDrawableResource?.let { view.setImageResource(it) }
    else if (observable.mColorResource != null)
        observable.mColorResource?.let {
            val color = ContextCompat.getColor(view.context, it)
            view.setBackgroundColor(color)
        }
    else if (observable.mColorValue != null)
        observable.mColorValue?.let { view.setBackgroundColor(it) }
    else if (observable.mDrawable != null) {
        observable.mDrawable?.let {
            view.setImageDrawable(it)
        }
    } else if (observable.mBitmap != null) {
        observable.mBitmap?.let {
            view.setImageBitmap(it)
        }
    } else {
        view.setImageResource(0)
    }
}

@BindingAdapter("srcDrawable")
fun setSrcDrawable(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        view.visibility = View.VISIBLE
        val resId = view.resources.getIdentifier(url, "drawable", view.context.packageName)
        val drawable = ContextCompat.getDrawable(view.context, resId)
        view.setImageDrawable(drawable)
    } else {
        view.visibility = View.GONE
    }
}

