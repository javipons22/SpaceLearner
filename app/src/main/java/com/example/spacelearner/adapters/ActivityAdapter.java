package com.example.spacelearner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.Action;
import com.example.spacelearner.MainActivity;
import com.example.spacelearner.R;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActionViewHolder> {

    private List<Action> actions;

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView nameTextView;

        public ActionViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.action_row);
            this.nameTextView = view.findViewById(R.id.action_row_text_view);
        }
    }

    public ActivityAdapter() {
        this.actions = MainActivity.database.actionDao().getAll();
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row, parent, false);

        return new ActionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Action current = actions.get(position);
        holder.containerView.setTag(current);
        holder.nameTextView.setText(current.content);
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }

}
