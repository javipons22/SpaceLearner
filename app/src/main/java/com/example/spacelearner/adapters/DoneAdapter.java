package com.example.spacelearner.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.spacelearner.Action;
import com.example.spacelearner.MainActivity;
import com.example.spacelearner.Pokemon;
import com.example.spacelearner.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    //private RequestQueue requestQueue;

    //public DoneAdapter() {
        //requestQueue = Volley.newRequestQueue(context);
        //loadPokemon();
    //}

    //public void loadPokemon() {
        //pokemon = MainActivity.database.actionDao().getAll();
    //}

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokedex_row, parent, false);

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

    public void reload() {
        pokemon = MainActivity.database.actionDao().getAll();
        //Log.d("javito", MainActivity.database.actionDao().getContents().toString());
        notifyDataSetChanged();
    }
}
