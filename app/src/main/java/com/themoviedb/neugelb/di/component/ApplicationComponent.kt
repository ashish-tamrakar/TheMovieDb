package com.themoviedb.neugelb.di.component

import android.app.Application
import com.themoviedb.neugelb.di.module.ApplicationModule
import com.themoviedb.neugelb.di.module.DbModule
import com.themoviedb.neugelb.di.module.RetrofitModule
import com.themoviedb.neugelb.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component



@Component(modules = [ApplicationModule::class, DbModule::class, RetrofitModule::class])
@ApplicationScope
interface ApplicationComponent{
    fun plusFragmentComponent() : FragmentComponent


    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

}