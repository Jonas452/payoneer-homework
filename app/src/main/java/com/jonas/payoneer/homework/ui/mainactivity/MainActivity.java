package com.jonas.payoneer.homework.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jonas.payoneer.homework.databinding.ActivityMainBinding;
import com.jonas.payoneer.homework.model.PaymentMethod;
import com.jonas.payoneer.homework.ui.adapter.PaymentMethodAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;

    private ActivityMainBinding binding;
    private PaymentMethodAdapter paymentMethodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        setupAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscribeFromPaymentMethodList();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupAdapter() {
        paymentMethodAdapter = new PaymentMethodAdapter(this);
        binding.paymentMethodList.setAdapter(paymentMethodAdapter);
    }

    private void subscribeFromPaymentMethodList() {
        viewModel.getPaymentMethodListUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PaymentMethod>>() {
                               @Override
                               public void onSubscribe(@NotNull Disposable d) {
                                   //TODO Show loading
                               }

                               @Override
                               public void onNext(@NotNull List<PaymentMethod> paymentMethods) {
                                   //TODO Stop loading
                                   paymentMethodAdapter.updateList(
                                           paymentMethods
                                   );
                               }

                               @Override
                               public void onError(@NotNull Throwable e) {
                                   //TODO Show error
                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );
    }

}