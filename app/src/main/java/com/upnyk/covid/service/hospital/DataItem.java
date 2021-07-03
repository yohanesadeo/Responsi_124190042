package com.upnyk.covid.service.hospital;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("rujukan")
	private Object rujukan;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tipe_faskes")
	private int tipeFaskes;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("telepon")
	private String telepon;

	@SerializedName("kode_kemkes")
	private Object kodeKemkes;

	@SerializedName("url")
	private Object url;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("nomor_rujukan")
	private int nomorRujukan;

	public Object getRujukan(){
		return rujukan;
	}

	public String getNama(){
		return nama;
	}

	public int getTipeFaskes(){
		return tipeFaskes;
	}

	public double getLatitude(){
		return latitude;
	}

	public String getTelepon(){
		return telepon;
	}

	public Object getKodeKemkes(){
		return kodeKemkes;
	}

	public Object getUrl(){
		return url;
	}

	public String getAlamat(){
		return alamat;
	}

	public double getLongitude(){
		return longitude;
	}

	public int getNomorRujukan(){
		return nomorRujukan;
	}
}