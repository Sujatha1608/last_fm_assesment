package sampleproject.com.my.skeletonApp.feature.display


import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResultResponse(

    var avatar : String?=null,
    var display_name: String? = "",
    var reputation : Int? = 0,
    var top_tags: String? = "",
    var badges : String? = "",
    var location : String? = "",
    var user_id : Int? = 0,
    var creation_date : Int? = 0

): Parcelable
