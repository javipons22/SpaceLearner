package com.example.spacelearner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.Action3;
import com.example.spacelearner.MainActivity;
import com.example.spacelearner.R;
import com.example.spacelearner.TimeLeftCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.ActionViewHolder> {

    private List<Action3> actions;

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView nameTextView;
        public TextView dateTextView;

        public ActionViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.action_row);
            this.nameTextView = view.findViewById(R.id.action_row_text_view);
            this.dateTextView = view.findViewById(R.id.action_row_date_view);
        }
    }

    public DoneAdapter() {
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
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date = new Date();
        Action3 current = actions.get(position);
        holder.containerView.setTag(current);
        holder.nameTextView.setText(current.content);
        holder.dateTextView.setText("date");
}

    @Override
    public int getItemCount() {
        return actions.size();
    }

}
