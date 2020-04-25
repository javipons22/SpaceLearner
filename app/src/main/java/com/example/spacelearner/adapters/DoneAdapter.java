package com.example.spacelearner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.Action;
import com.example.spacelearner.R;

import java.util.ArrayList;
import java.util.List;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.TodoViewHolder> {

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;

        TodoViewHolder(View view) {
            super(view);

            containerView = view.findViewById(R.id.action_row);
            textView = view.findViewById(R.id.action_row_text_view);
        }
    }

    private List<Action> pokemon = new ArrayList<>();

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row, parent, false);

        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Action current = pokemon.get(position);
        holder.textView.setText(current.content);
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

}
