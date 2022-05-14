package sampleproject.com.my.skeletonApp.rest.model

import com.squareup.moshi.Json

data class BadgeDataResponse (
    @Json( name = "items")
    val items : List<Item>,

    @Json( name = "has_more")
    val has_more : Boolean,

    @Json( name = "quota_max")
    val quota_max : Int,

    @Json( name = "quota_remaining")
    val quota_remaining : Int

)
data class Item (

    @Json( name ="badge_counts")
    val badge_counts : Badge_count?=null,

    @Json( name ="account_id")
    val account_id : Int,

    @Json( name ="is_employee")
    val is_employee : Boolean,

    @Json( name ="last_modified_date")
    val last_modified_date : Int,

    @Json( name ="last_access_date")
    val last_access_date : Int,

    @Json( name ="reputation_change_year")
    val reputation_change_year : Int,

    @Json( name ="reputation_change_quarter")
    val reputation_change_quarter : Int,

    @Json( name ="reputation_change_month")
    val reputation_change_month : Int,

    @Json( name ="reputation_change_week")
    val reputation_change_week : Int,

    @Json( name ="reputation_change_day")
    val reputation_change_day : Int,

    @Json( name ="reputation")
    val reputation : Int,

    @Json( name ="creation_date")
    val creation_date : Int,

    @Json( name ="user_type")
    val user_type : String,

    @Json( name ="user_id")
    val user_id : Int,

    @Json( name ="accept_rate")
    val accept_rate : Int,

    @Json( name ="location")
    val location : String,

    @Json( name ="website_url")
    val website_url : String,

    @Json( name ="link")
    val link : String,

    @Json( name ="profile_image")
    val profile_image : String,

    @Json( name ="display_name")
    val display_name : String
)
data class Badge_count (
    @Json( name ="bronze")
    val bronze : Int,

    @Json( name ="silver")
    val silver : Int,

    @Json( name ="gold")
    val gold : Int
)