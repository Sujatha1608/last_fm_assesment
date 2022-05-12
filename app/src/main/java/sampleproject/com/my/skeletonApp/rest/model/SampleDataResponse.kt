package sampleproject.com.my.skeletonApp.rest.model

import com.squareup.moshi.Json

data class SampleDataResponse (
    @Json( name = "items")
    val items: List<Items>?=null
    )

data class Badge_Counts(
    @Json( name = "bronze")
    val bronze: Int?=null,

    @Json( name = "silver")
    val silver: Int?=null,

    @Json( name = "gold")
    val gold: Int?=null,
)
data class Items(
    @Json( name = "badge_counts")
    val badge_counts: Badge_Counts?=null,

    @Json( name = "is_employee")
    val is_employee: Boolean,

    @Json( name = "last_modified_date")
    val last_modified_date: Int,

    @Json( name = "last_access_date")
    val last_access_date: Int?=null,

    @Json( name = "reputation_change_year")
    val reputation_change_year: Int?=null,

    @Json( name = "reputation_change_quarter")
    val reputation_change_quarter: Int,

    @Json( name = "reputation_change_month")
    val reputation_change_month: Int,

    @Json( name = "reputation_change_week")
    val reputation_change_week: Int?=null,

    @Json( name = "reputation_change_day")
    val reputation_change_day: Int,

    @Json( name = "reputation")
    val reputation: Int?=null,

    @Json( name = "creation_date")
    val creation_date: Int,

    @Json( name = "user_type")
    val user_type: String?=null,

    @Json( name = "user_id")
    val user_id: Int?=null,

    @Json( name = "link")
    val link: String?=null,

    @Json( name = "profile_image")
    val profile_image: String?=null,

    @Json( name = "display_name")
    val display_name: String?=null

)