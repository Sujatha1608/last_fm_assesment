package sampleproject.com.my.skeletonApp.feature.display


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResultResponse(

    var name : String?=null,
    var artist: String? = "",
    var url : String? = "",
    var mbid: String? = "",
    var info: String? = ""

): Parcelable
