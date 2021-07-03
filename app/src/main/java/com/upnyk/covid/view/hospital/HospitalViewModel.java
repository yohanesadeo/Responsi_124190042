package com.upnyk.covid.view.hospital;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid.service.APIService;
import com.upnyk.covid.service.hospital.DataItem;
import com.upnyk.covid.service.hospital.HospitalResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {

    private static final String TAG = "HospitalViewModel";
    private MutableLiveData<List<DataItem>> dataItems;

    public HospitalViewModel() {
        dataItems = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataItem>> getDataItems() {
        return dataItems;
    }

    public void loadHospital(){
        APIService apiService = new APIService();
        apiService.getAPI().getHospital().enqueue(new Callback<HospitalResponse>() {
            @Override
            public void onResponse(Call<HospitalResponse> call, Response<HospitalResponse> response) {
                dataItems.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<HospitalResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: HOSPITAL API FAIL.....");
            }
        });
    }
}
