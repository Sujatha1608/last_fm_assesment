package sampleproject.com.my.skeletonApp.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User (
    @PrimaryKey var username: String,
)