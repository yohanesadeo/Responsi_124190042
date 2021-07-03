package com.upnyk.covid.view.cases;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.covid.service.APIService;
import com.upnyk.covid.service.cases.CasesResponse;
import com.upnyk.covid.service.cases.ContentItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasesViewModel extends ViewModel {

    private static final String TAG = "CasesViewModel";
    private MutableLiveData<List<ContentItem>> contentItems;

    public CasesViewModel() {
        contentItems = new MutableLiveData<>();
    }

    public MutableLiveData<List<ContentItem>> getContentItems() {
        return contentItems;
    }

    public void loadCases(){
        APIService apiService = new APIService();
        apiService.getAPI().getCases().enqueue(new Callback<CasesResponse>() {
            @Override
            public void onResponse(Call<CasesResponse> call, Response<CasesResponse> response) {
                contentItems.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<CasesResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: CASES API FAIL.....");
            }
        });
    }
}
