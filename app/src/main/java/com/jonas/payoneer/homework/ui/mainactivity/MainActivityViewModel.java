package com.jonas.payoneer.homework.ui.mainactivity;

import androidx.lifecycle.ViewModel;

import com.jonas.payoneer.homework.usecase.paymentmethod.GetPaymentMethodListUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {

    public GetPaymentMethodListUseCase getPaymentMethodListUseCase;

    @Inject
    public MainActivityViewModel(
            GetPaymentMethodListUseCase getPaymentMethodListUseCase
    ) {
        this.getPaymentMethodListUseCase = getPaymentMethodListUseCase;
    }

}
