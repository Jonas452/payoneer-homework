package com.jonas.payoneer.homework.network.service;

import com.jonas.payoneer.homework.network.entity.PaymentMethodResponse;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;

public interface PaymentMethodService {

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Response<List<PaymentMethodResponse>> getListPaymentMethods();

}
