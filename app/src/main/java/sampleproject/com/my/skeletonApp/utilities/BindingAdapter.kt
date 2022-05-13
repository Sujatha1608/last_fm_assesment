package sampleproject.com.my.skeletonApp.utilities

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("android:background")
fun setBackground(view: View, drawable: Drawable?) {
    drawable?.let {
        view.background = drawable
    }
}

@BindingAdapter("android:background")
fun setBackground(view: View, observable: ObservableBackground) {
    if (observable.mDrawableResource != null)
        observable.mDrawableResource?.let { view.setBackgroundResource(it) }
    else if (observable.mColorResource != null)
        observable.mColorResource?.let {
            val color = ContextCompat.getColor(view.context, it)
            if (observable.isCardView && view is CardView) {
                view.setCardBackgroundColor(color)
            } else {
                view.setBackgroundColor(color)
            }
        }
    else if (observable.mColorValue != null)
        observable.mColorValue?.let {
            if (observable.isCardView && view is CardView) {
                view.setCardBackgroundColor(it)
            } else {
                view.setBackgroundColor(it)
            }
        }
    else if (observable.mDrawable != null) {
        observable.mDrawable?.let {
            view.background = it
        }
    } else if (observable.mBitmap != null) {
        observable.mBitmap?.let {
            view.background = BitmapDrawable(view.context.resources, it)
        }
    } else {
        view.setBackgroundResource(0)
    }
}

/*
@BindingAdapter("android:background")
fun setBackgroundColor(view: View, resource: Int) {
    if (resource != 0) {
        val color = ContextCompat.getColor(view.context, resource)
        view.setBackgroundColor(color)
    }
}
*/

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

@BindingAdapter("android:src")
fun setImageUrl(imageView: ImageView, resource: Int) {
    if (resource != 0) {
        imageView.setImageResource(resource)
    }
}

@BindingAdapter("android:imageBitmap")
fun setBitmap(view: ImageView, bitmap: Bitmap) {
    view.setImageBitmap(bitmap)
}
@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: String?) {
    view.visibility = if (!TextUtils.isEmpty(value))
        View.VISIBLE
    else
        View.GONE
}

@BindingAdapter("android:visibility")
fun setVisibilityBoolean(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@Suppress("DEPRECATION")
@BindingAdapter("android:imageUri")
fun setImageUri(view: ImageView, uri: String?) {
    if (!uri.isNullOrBlank()) {
        val bitmap = MediaStore.Images.Media.getBitmap(view.context.contentResolver, Uri.parse(uri))
        view.setImageBitmap(bitmap)
    }
}

@BindingAdapter("android:layout_marginTop")
fun setTopMargin(view: View, topMargin: Float) {
    val layoutParams = view.layoutParams as MarginLayoutParams
    layoutParams.setMargins(
        layoutParams.leftMargin,
        Math.round(topMargin),
        layoutParams.rightMargin,
        layoutParams.bottomMargin
    )
    view.layoutParams = layoutParams
}

@BindingAdapter("selected")
fun setSelected(button: Button, isSelected: Boolean) {
    if (button.isSelected != isSelected) {
        button.isSelected = isSelected
    }
}

@BindingAdapter("app:contentInsetStart")
fun setToolbarInsetStart(view: View, insetStart: Float) {
    (view as Toolbar).setContentInsetsAbsolute(insetStart.toInt(), 0)
}

@BindingAdapter("app:contentInsetStart")
fun setInsetStart(view: View, insetStart: Float) {
    (view as Toolbar).setContentInsetsAbsolute(insetStart.toInt(), 0)
}

@BindingAdapter("app:errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}


@BindingAdapter("android:textColor")
fun setTextColor(view: TextView, observable: ObservableBackground) {
    if (observable.mColorResource != null) {
        if (observable.mColorResource != view.currentTextColor) {
            observable.mColorResource?.let {
                val color = ContextCompat.getColor(view.context, it)
                view.setTextColor(color)
            }
        }
    } else if (observable.mColorValue != null) {
        if (observable.mColorValue != view.currentTextColor) {
            observable.mColorValue?.let {
                val color = ContextCompat.getColor(view.context, it)
                view.setTextColor(color)
            }
        }
    }
}




