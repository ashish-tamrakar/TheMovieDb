package com.themoviedb.neugelb.di.module

import com.themoviedb.neugelb.TimberLogger
import com.themoviedb.neugelb.di.scope.ApplicationScope
import com.themoviedb.neugelb.domain.Logger
import dagger.Binds
import dagger.Module

@Module(includes = [ApplicationModule.LoggerModule::class])
class ApplicationModule() {
    @Module
    interface LoggerModule{
        @Binds
        @ApplicationScope
        fun bindLogger(loagger : TimberLogger) : Logger
    }
}