package com.jonas.payoneer.homework.repository.remote;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.network.mapper.PaymentMethodResponseMapper;
import com.jonas.payoneer.homework.network.service.PaymentMethodService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PaymentMethodRemoteRepositoryImpl implements PaymentMethodRemoteRepository {

    private final PaymentMethodService paymentMethodService;
    private final PaymentMethodResponseMapper paymentMethodResponseMapper;

    @Inject
    public PaymentMethodRemoteRepositoryImpl(
            PaymentMethodService paymentMethodService,
            PaymentMethodResponseMapper paymentMethodResponseMapper
    ) {
        this.paymentMethodService = paymentMethodService;
        this.paymentMethodResponseMapper = paymentMethodResponseMapper;
    }

    @Override
    public Observable<List<PaymentMethod>> getListPaymentMethods() {
        return paymentMethodService.getListPaymentMethods()
                .map(listResultResponse -> paymentMethodResponseMapper.toModelList(
                        listResultResponse.networks.applicable
                ));
    }
}
