package sampleproject.com.my.skeletonApp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject


class AppPreference() {
    private lateinit var prefs: SharedPreferences

    @Inject
    constructor(context: Context): this(){
        this.prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }
}