package com.upnyk.covid.view.hospital;

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
import com.upnyk.covid.view.cases.CasesListAdapter;

import java.util.ArrayList;

public class HospitalFragment extends Fragment {

    private HospitalViewModel hospitalViewModel;
    private RecyclerView rvHospital;
    private HospitalListAdapter hospitalListAdapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        rvHospital = view.findViewById(R.id.rv_hospital);
        hospitalListAdapter = new HospitalListAdapter(getActivity(), new ArrayList<>());
        progressBar = view.findViewById(R.id.progress_bar_hospital);

        rvHospital.setHasFixedSize(true);
        rvHospital.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvHospital.setAdapter(hospitalListAdapter);

        hospitalViewModel.getDataItems().observe(requireActivity(), dataItems -> {
            hospitalListAdapter.setDataItems(dataItems);
            hospitalListAdapter.notifyDataSetChanged();

            progressBar.setVisibility(dataItems.size() > 1 ? View.INVISIBLE : View.VISIBLE);
        });

        hospitalViewModel.loadHospital();
    }
}