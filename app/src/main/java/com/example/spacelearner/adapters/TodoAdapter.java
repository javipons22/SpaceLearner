package com.example.spacelearner.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.Action3;
import com.example.spacelearner.EditActivity;
import com.example.spacelearner.MainActivity;
import com.example.spacelearner.R;
import com.example.spacelearner.TimeLeftCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ActionViewHolder> {

    private List<Action3> actions;

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView chapterTextView;

        public ActionViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.action_row);
            this.nameTextView = view.findViewById(R.id.action_row_text_view);
            this.dateTextView = view.findViewById(R.id.action_row_date_view);
            this.chapterTextView = view.findViewById(R.id.action_row_chapter_view);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Action3 current = (Action3) containerView.getTag();
                    Intent intent = new Intent(v.getContext(), EditActivity.class);
                    intent.putExtra("name", current.title);
                    intent.putExtra("id",current.id);
                    intent.putExtra("chapter",current.chapter);
                    intent.putExtra("FROM_TAB","TAB1");

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public TodoAdapter() {
        Date dateNow = new Date();
        Long dateNowNumber = dateNow.getTime();
        this.actions = MainActivity.database.actionDao().getAllTodos(dateNowNumber);
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row, parent, false);

        return new ActionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Action3 current = actions.get(position);

        holder.containerView.setTag(current);
        holder.nameTextView.setText(current.title);
        holder.chapterTextView.setText("Chapter " + current.chapter);
        holder.dateTextView.setText("Revise NOW");
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }

}
