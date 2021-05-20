package com.jonas.payoneer.homework.usecase.paymentmethod;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.repository.remote.PaymentMethodRemoteRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetPaymentMethodListUseCase {

    private final PaymentMethodRemoteRepository paymentMethodRemoteRepository;

    @Inject
    public GetPaymentMethodListUseCase(
            PaymentMethodRemoteRepository paymentMethodRemoteRepository
    ) {
        this.paymentMethodRemoteRepository = paymentMethodRemoteRepository;
    }

    public Observable<List<PaymentMethod>> execute() {
        return paymentMethodRemoteRepository.getListPaymentMethods();
    }

}
