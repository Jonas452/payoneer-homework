package com.jonas.payoneer.homework.usecase.paymentmethod;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.repository.remote.PaymentMethodRemoteRepository;

import java.util.List;

import retrofit2.Response;

public class GetPaymentMethodListUseCase {

    private final PaymentMethodRemoteRepository paymentMethodRemoteRepository;

    public GetPaymentMethodListUseCase(
            PaymentMethodRemoteRepository paymentMethodRemoteRepository
    ) {
        this.paymentMethodRemoteRepository = paymentMethodRemoteRepository;
    }

    public Response<List<PaymentMethod>> execute() {
        return paymentMethodRemoteRepository.getListPaymentMethods();
    }

}
