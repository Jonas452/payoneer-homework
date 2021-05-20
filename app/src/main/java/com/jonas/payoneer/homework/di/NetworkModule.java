package com.jonas.payoneer.homework.di;

import com.jonas.payoneer.homework.network.service.PaymentMethodService;
import com.jonas.payoneer.homework.repository.remote.PaymentMethodRemoteRepository;
import com.jonas.payoneer.homework.repository.remote.PaymentMethodRemoteRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(String BASE_URL) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(
                        MoshiConverterFactory.create()
                )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public PaymentMethodService providesPaymentMethodService(Retrofit retrofit) {
        return retrofit.create(
                PaymentMethodService.class
        );
    }

    @Provides
    @Singleton
    public PaymentMethodRemoteRepository providesPaymentMethodRemoteRepository(
            PaymentMethodRemoteRepositoryImpl impl
    ) {
        return impl;
    }

}
