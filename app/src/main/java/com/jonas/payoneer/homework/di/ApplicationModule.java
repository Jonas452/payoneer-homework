package com.jonas.payoneer.homework.di;

import com.jonas.payoneer.homework.BuildConfig;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ApplicationModule {

    @Provides
    String provideBaseUrl() {
        return BuildConfig.SERVER_URL;
    }

}
