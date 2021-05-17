package com.jonas.payoneer.homework.repository.remote;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.network.entity.PaymentMethodResponse;
import com.jonas.payoneer.homework.network.mapper.PaymentMethodResponseMapper;
import com.jonas.payoneer.homework.network.service.PaymentMethodService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

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
    public Response<List<PaymentMethod>> getListPaymentMethods() {
        Response<List<PaymentMethodResponse>> response = paymentMethodService.getListPaymentMethods();
        Response<List<PaymentMethod>> convertedResponse;

        if (response.isSuccessful() && response.body() != null) {
            List<PaymentMethod> paymentMethodList = paymentMethodResponseMapper.toModelList(response.body());
            convertedResponse = Response.success(
                    response.code(),
                    paymentMethodList
            );
        } else {
            convertedResponse = Response.error(
                    response.code(),
                    response.errorBody()
            );
        }

        return convertedResponse;
    }
}
