package com.movieapp.movieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movieapp.movieapp.databinding.PlansRowBinding;
import com.movieapp.movieapp.models.PlansModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.PlansAdapterViewHolder> {
    private List<PlansModel> list;
    private RecyclerClickItems clickItems;

    public PlansAdapter(List<PlansModel> list, RecyclerClickItems clickItems) {
        this.list = list;
        this.clickItems = clickItems;
    }

    @NonNull
    @Override
    public PlansAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plans_row, parent, false);
        PlansRowBinding view = PlansRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlansAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlansAdapterViewHolder holder, int position) {
        PlansModel plansModel = list.get(position);
        holder.bind(plansModel, clickItems);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PlansAdapterViewHolder extends RecyclerView.ViewHolder{
        private PlansRowBinding binding;

        public PlansAdapterViewHolder(PlansRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PlansModel plansModel, RecyclerClickItems clickItems){
            binding.setPlansModel(plansModel);
            binding.executePendingBindings();
            binding.plansRowSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickItems.onPlanChooseClick(plansModel);
                }
            });
        }

//        public PlansAdapterViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
    }
}
