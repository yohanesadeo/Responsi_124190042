package com.upnyk.covid.service;

import com.upnyk.covid.service.cases.CasesResponse;
import com.upnyk.covid.service.hospital.HospitalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {

    @GET("rekapitulasi_v2/jabar/harian")
    Call<CasesResponse> getCases();

    @GET("sebaran_v2/jabar/faskes")
    Call<HospitalResponse> getHospital();

}
