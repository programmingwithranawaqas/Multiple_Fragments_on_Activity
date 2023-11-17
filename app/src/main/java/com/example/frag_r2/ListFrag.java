package com.example.frag_r2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFrag extends ListFragment {

    OnContactNameClicked parent;

    public interface OnContactNameClicked{
        public void onNameClick(int index);
    }
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parent.onNameClick(position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parent = (OnContactNameClicked) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Shagufta");
        names.add("Dogar");
        names.add("Shagufta ki bahn");
        names.add("Shagufta ka khandan");

        setListAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, names));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}