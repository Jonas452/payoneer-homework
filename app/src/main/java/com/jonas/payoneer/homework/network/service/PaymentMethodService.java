package com.jonas.payoneer.homework.network.service;

import com.jonas.payoneer.homework.network.entity.ListResultResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PaymentMethodService {

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Observable<ListResultResponse> getListPaymentMethods();

}
