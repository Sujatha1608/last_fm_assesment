package sampleproject.com.my.skeletonApp.feature.display

import com.squareup.moshi.Json

data class DataResultResponse(

    @Json(name = "avatar ")
    var Avatar : String? = null,

    @Json(name = "display_name")
    var display_name: String? = null,

    @Json(name = "reputation ")
    var Reputation : Int? = null,

    @Json(name = "top_tags")
    var top_tags: String? = null,

    @Json(name = "badges ")
    var Badges : String? = null,

    @Json(name = "location ")
    var Location : String? = null,

    @Json(name = "creation_date ")
    var Creation_Date : Int? = null


)
