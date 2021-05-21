package com.jonas.payoneer.homework.network.mapper;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.network.entity.PaymentMethodResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaymentMethodResponseMapper {

    @Inject
    public PaymentMethodResponseMapper() {
    }

    private PaymentMethod toModel(PaymentMethodResponse paymentMethodResponse) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setLabel(
                paymentMethodResponse.label
        );
        paymentMethod.setLogoURL(
                paymentMethodResponse.links.logo
        );

        return paymentMethod;
    }

    public List<PaymentMethod> toModelList(List<PaymentMethodResponse> paymentMethodResponseList) {
        List<PaymentMethod> paymentMethodList = new ArrayList<>();

        for (PaymentMethodResponse paymentMethodResponse : paymentMethodResponseList) {
            paymentMethodList.add(
                    toModel(
                            paymentMethodResponse
                    )
            );
        }

        return paymentMethodList;
    }

}
