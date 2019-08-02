package com.themoviedb.neugelb

import android.app.Application
import com.themoviedb.neugelb.di.component.ApplicationComponent
import com.themoviedb.neugelb.di.component.DaggerApplicationComponent
import timber.log.Timber

class MovieSampleApp : Application() {

    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(PrefixDebugTree())
        }
    }

    companion object {
        lateinit var instance: MovieSampleApp
            private set
    }

    fun getApplicationComponent(): ApplicationComponent = appComponent
}
