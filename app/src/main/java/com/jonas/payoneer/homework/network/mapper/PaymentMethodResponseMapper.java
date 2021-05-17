package com.jonas.payoneer.homework.network.mapper;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.network.entity.PaymentMethodResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodResponseMapper {

    private PaymentMethod toModel(PaymentMethodResponse paymentMethodResponse) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setLabel(
                paymentMethodResponse.label
        );
        paymentMethod.setLogo(
                paymentMethodResponse.logo
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
