package sampleproject.com.my.skeletonApp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single



@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getUser(): Single<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
}