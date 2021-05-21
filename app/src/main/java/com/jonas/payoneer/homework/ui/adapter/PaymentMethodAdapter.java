package com.jonas.payoneer.homework.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonas.payoneer.homework.databinding.ItemPaymentMethodBinding;
import com.jonas.payoneer.homework.model.PaymentMethod;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodItemViewHolder> {

    private List<PaymentMethod> paymentMethodList;

    @NonNull
    @NotNull
    @Override
    public PaymentMethodItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPaymentMethodBinding binding = ItemPaymentMethodBinding.inflate(
                inflater,
                parent,
                false
        );

        return new PaymentMethodItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentMethodItemViewHolder holder, int position) {
        holder.bind(paymentMethodList.get(position));
    }

    @Override
    public int getItemCount() {
        return paymentMethodList != null ? paymentMethodList.size() : 0;
    }

    public void updateList(List<PaymentMethod> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
        notifyDataSetChanged();
    }

    static class PaymentMethodItemViewHolder extends RecyclerView.ViewHolder {

        ItemPaymentMethodBinding dataBinding;

        public PaymentMethodItemViewHolder(@NonNull @NotNull ItemPaymentMethodBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(PaymentMethod paymentMethod) {
            dataBinding.setItem(paymentMethod);
        }

    }

}
