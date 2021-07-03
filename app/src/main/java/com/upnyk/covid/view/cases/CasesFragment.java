package com.upnyk.covid.view.cases;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.upnyk.covid.R;

import java.util.ArrayList;

public class CasesFragment extends Fragment {

    private CasesViewModel casesViewModel;
    private RecyclerView rvCases;
    private CasesListAdapter casesListAdapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cases, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        casesViewModel = new ViewModelProvider(this).get(CasesViewModel.class);
        rvCases = view.findViewById(R.id.rv_cases);
        casesListAdapter = new CasesListAdapter(getActivity(), new ArrayList<>());
        progressBar = view.findViewById(R.id.progress_bar_cases);

        rvCases.setHasFixedSize(true);
        rvCases.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, true));
        rvCases.setAdapter(casesListAdapter);

        casesViewModel.getContentItems().observe(requireActivity(), contentItems -> {
            casesListAdapter.setContentItems(contentItems);
            casesListAdapter.notifyDataSetChanged();
            rvCases.scrollToPosition(casesListAdapter.getItemCount()-1);

            progressBar.setVisibility(contentItems.size() > 1 ? View.INVISIBLE : View.VISIBLE);
        });

        casesViewModel.loadCases();
    }
}