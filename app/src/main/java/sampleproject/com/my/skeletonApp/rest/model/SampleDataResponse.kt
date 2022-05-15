package sampleproject.com.my.skeletonApp.rest.model

import com.squareup.moshi.Json

data class SampleDataResponse (
    @Json( name = "results")
    val results: Results?=null
    )
data class Results (

    @Json( name ="opensearch:Query")
    val opensearch_Query : Opensearch_Query,

    @Json( name ="opensearch:totalResults")
    val opensearch_totalResults : Int,

    @Json( name ="opensearch:startIndex")
    val opensearch_startIndex : Int,

    @Json( name ="opensearch:itemsPerPage")
    val opensearch_itemsPerPage : Int,

    @Json( name ="albummatches")
    val albummatches : Albummatches,

    @Json( name ="@attr")
    val attr : attr
)

data class Albummatches (

    @Json( name ="album")
    val album : List<Album>
)
data class Album (

    @Json( name ="name")
    val name : String,

    @Json( name ="artist")
    val artist : String,

    @Json( name ="url")
    val url : String,

    @Json( name ="image")
    val image : List<Image>,

    @Json( name ="streamable")
    val streamable : Int,

    @Json( name ="mbid")
    val mbid : String
)

data class Image (

    @Json( name = "#text")
    val text : String,

    @Json( name = "size")
    val size : String
)

data class Opensearch_Query (

    @Json( name = "#text")
    val text : String,

    @Json( name = "role")
    val role : String,

    @Json( name = "searchTerms")
    val searchTerms : String,

    @Json( name = "startPage")
    val startPage : Int
)

data class attr (
    @Json( name = "for")
    val for_reference : String
)