package it.ikbo1120.fitness_club_v1_1.presentation.view.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import it.ikbo1120.fitness_club_v1_1.MainActivity;
import it.ikbo1120.fitness_club_v1_1.databinding.ServicesItemBinding;
import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Services> data;
    final int DIALOG_EXIT = 1;
    public ItemListAdapter(List<Services> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicesItemBinding binding = ServicesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.itemCard.setOnClickListener(v -> {
            System.out.println(position);
        });
        holder.binding.itemCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                data.remove(position);
                return false;
            }
        });
    }

    public void onCreateDialog(int id) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Services> getData() {
        return data;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ServicesItemBinding binding;
        public ItemViewHolder(ServicesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
