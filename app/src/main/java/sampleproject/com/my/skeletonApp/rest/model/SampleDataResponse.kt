package sampleproject.com.my.skeletonApp.rest.model

import com.squareup.moshi.Json

data class SampleDataResponse (
    @Json( name = "userId")
    val userId: Int?=null,

    @Json( name = "id")
    val id: Int?=null,

    @Json( name = "completed")
    val completed: Boolean,

    @Json( name = "title")
    val title: String?=null
    )