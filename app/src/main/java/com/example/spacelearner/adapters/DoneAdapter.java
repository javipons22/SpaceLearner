package com.example.spacelearner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.Book;
import com.example.spacelearner.MainActivity;
import com.example.spacelearner.R;

import java.util.List;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.ActionViewHolder> {

    private List<Book> actions;

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
        }
    }

    public DoneAdapter() {
        this.actions = MainActivity.database.actionDao().getAllDone();
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_row, parent, false);

        return new ActionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Book current = actions.get(position);

        holder.containerView.setTag(current);
        holder.nameTextView.setText(current.title);
        holder.chapterTextView.setText("Chapter " + current.chapter);
        holder.dateTextView.setText("Finished");
}

    @Override
    public int getItemCount() {
        return actions.size();
    }

}
