package com.example.spacelearner.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacelearner.adapters.ActivityAdapter;
import com.example.spacelearner.R;
import com.example.spacelearner.adapters.DoneAdapter;
import com.example.spacelearner.adapters.TodoAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Integer currentIndex;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        currentIndex = index;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
            currentIndex = index;
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root;
        if (currentIndex.equals(1)) {
            root = inflater.inflate(R.layout.fragment_todo, container, false);

            recyclerView = root.findViewById(R.id.recycler_view_todo);
            adapter = new TodoAdapter(getContext());
            layoutManager = new LinearLayoutManager(getContext());

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
            return root;
        } else if (currentIndex.equals(2)){
            root = inflater.inflate(R.layout.fragment_todo, container, false);

            recyclerView = root.findViewById(R.id.recycler_view_todo);
            adapter = new ActivityAdapter();
            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
            return root;
        } else {
            root = inflater.inflate(R.layout.fragment_todo, container, false);

            recyclerView = root.findViewById(R.id.recycler_view_todo);
            adapter = new DoneAdapter(getContext());
            layoutManager = new LinearLayoutManager(getContext());

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
            return root;
        }
    }
}