package com.jonas.payoneer.homework.repository.remote;

import com.jonas.payoneer.homework.model.PaymentMethod;

import java.util.List;

import retrofit2.Response;

public interface PaymentMethodRemoteRepository {

    public Response<List<PaymentMethod>> getListPaymentMethods();

}
