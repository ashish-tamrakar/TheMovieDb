package com.themoviedb.neugelb.di.module

import com.themoviedb.neugelb.data.database.LocalDataImpl
import com.themoviedb.neugelb.data.network.RemoteDataImpl
import com.themoviedb.neugelb.data.repository.LocalData
import com.themoviedb.neugelb.data.repository.RemoteData
import com.themoviedb.neugelb.di.scope.FragmentScope
import dagger.Binds
import dagger.Module

@Module
interface DataModule{

    @Binds
    @FragmentScope
    fun bindLocalData (localData : LocalDataImpl) : LocalData

    @Binds
    @FragmentScope
    fun bindRemoteData (remoteData : RemoteDataImpl) : RemoteData

}