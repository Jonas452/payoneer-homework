package com.jonas.payoneer.homework.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jonas.payoneer.homework.R;
import com.jonas.payoneer.homework.databinding.ItemPaymentMethodBinding;
import com.jonas.payoneer.homework.model.PaymentMethod;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodItemViewHolder> {

    private final Context context;
    private List<PaymentMethod> paymentMethodList;

    public PaymentMethodAdapter(Context context) {
        this.context = context;
    }

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

        return new PaymentMethodItemViewHolder(context, binding);
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

        private final Context context;
        private final ItemPaymentMethodBinding dataBinding;

        public PaymentMethodItemViewHolder(Context context, @NonNull @NotNull ItemPaymentMethodBinding dataBinding) {
            super(dataBinding.getRoot());
            this.context = context;
            this.dataBinding = dataBinding;
        }

        public void bind(PaymentMethod paymentMethod) {
            dataBinding.setItem(paymentMethod);

            Glide.with(context)
                    .load(paymentMethod.getLogoURL())
                    .placeholder(R.drawable.ic_placeholder_image)
                    .into(dataBinding.logo);
        }

    }

}
