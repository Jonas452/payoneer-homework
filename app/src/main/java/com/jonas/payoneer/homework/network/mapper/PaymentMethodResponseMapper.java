package com.jonas.payoneer.homework.network.mapper;

import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.network.entity.PaymentMethodEntity;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodResponseMapper {

    private PaymentMethod toModel(PaymentMethodEntity paymentMethodEntity) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setLabel(
                paymentMethodEntity.label
        );
        paymentMethod.setLogo(
                paymentMethodEntity.logo
        );

        return paymentMethod;
    }

    public List<PaymentMethod> toModelList(List<PaymentMethodEntity> paymentMethodEntityList) {
        List<PaymentMethod> paymentMethodList = new ArrayList<>();

        for (PaymentMethodEntity paymentMethodEntity : paymentMethodEntityList) {
            paymentMethodList.add(
                    toModel(
                            paymentMethodEntity
                    )
            );
        }

        return paymentMethodList;
    }

}
