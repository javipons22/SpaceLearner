package com.example.spacelearner.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.R;
import com.example.spacelearner.adapters.TodoAdapter;

/**
 * A fragment for the "to do" tab.
 */
public class TodoFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static TodoFragment newInstance() {
        TodoFragment fragment = new TodoFragment();
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_todo, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_todo);
        adapter = new TodoAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return root;

    }
}