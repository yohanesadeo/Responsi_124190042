package com.upnyk.covid.service.cases;

import com.google.gson.annotations.SerializedName;

public class ContentItem{

	@SerializedName("suspect_discarded")
	private int suspectDiscarded;

	@SerializedName("suspect_meninggal_harian")
	private int suspectMeninggalHarian;

	@SerializedName("closecontact_dikarantina")
	private int closecontactDikarantina;

	@SerializedName("CONFIRMATION")
	private int cONFIRMATION;

	@SerializedName("suspect_diisolasi")
	private int suspectDiisolasi;

	@SerializedName("confirmation_diisolasi")
	private int confirmationDiisolasi;

	@SerializedName("closecontact_meninggal_harian")
	private int closecontactMeninggalHarian;

	@SerializedName("confirmation_meninggal")
	private int confirmationMeninggal;

	@SerializedName("probable_meninggal")
	private int probableMeninggal;

	@SerializedName("confirmation_selesai")
	private int confirmationSelesai;

	@SerializedName("closecontact_discarded")
	private int closecontactDiscarded;

	@SerializedName("kode_prov")
	private String kodeProv;

	@SerializedName("nama_prov")
	private String namaProv;

	@SerializedName("CLOSECONTACT")
	private int cLOSECONTACT;

	@SerializedName("probable_discarded")
	private int probableDiscarded;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("probable_diisolasi")
	private int probableDiisolasi;

	@SerializedName("SUSPECT")
	private int sUSPECT;

	public int getSuspectDiscarded(){
		return suspectDiscarded;
	}

	public int getSuspectMeninggalHarian(){
		return suspectMeninggalHarian;
	}

	public int getClosecontactDikarantina(){
		return closecontactDikarantina;
	}

	public int getCONFIRMATION(){
		return cONFIRMATION;
	}

	public int getSuspectDiisolasi(){
		return suspectDiisolasi;
	}

	public int getConfirmationDiisolasi(){
		return confirmationDiisolasi;
	}

	public int getClosecontactMeninggalHarian(){
		return closecontactMeninggalHarian;
	}

	public int getConfirmationMeninggal(){
		return confirmationMeninggal;
	}

	public int getProbableMeninggal(){
		return probableMeninggal;
	}

	public int getConfirmationSelesai(){
		return confirmationSelesai;
	}

	public int getClosecontactDiscarded(){
		return closecontactDiscarded;
	}

	public String getKodeProv(){
		return kodeProv;
	}

	public String getNamaProv(){
		return namaProv;
	}

	public int getCLOSECONTACT(){
		return cLOSECONTACT;
	}

	public int getProbableDiscarded(){
		return probableDiscarded;
	}

	public String getTanggal(){
		return tanggal;
	}

	public int getProbableDiisolasi(){
		return probableDiisolasi;
	}

	public int getSUSPECT(){
		return sUSPECT;
	}
}