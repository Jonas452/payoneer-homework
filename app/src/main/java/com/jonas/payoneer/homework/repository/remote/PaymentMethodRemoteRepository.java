package com.jonas.payoneer.homework.repository.remote;

import com.jonas.payoneer.homework.model.PaymentMethod;

import java.util.List;

import io.reactivex.Observable;

public interface PaymentMethodRemoteRepository {

    Observable<List<PaymentMethod>> getListPaymentMethods();

}
