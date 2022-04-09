package sampleproject.com.my.skeletonApp.database

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseRepository @Inject constructor(private val userDao: UserDao){

    fun insertUser(user: User) = userDao.insert(user)
}