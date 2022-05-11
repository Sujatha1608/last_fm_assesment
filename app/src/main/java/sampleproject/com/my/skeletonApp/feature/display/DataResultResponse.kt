package sampleproject.com.my.skeletonApp.feature.display

import com.squareup.moshi.Json

data class DataResultResponse(

    @Json(name = "title")
    var title: String? = null,

    @Json(name = "body")
    var body: String? = null,

)
