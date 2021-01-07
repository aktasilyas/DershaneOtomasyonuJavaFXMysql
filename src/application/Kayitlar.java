package application;


public class Kayitlar {
	
private int id;
private String adi;
private String soyadi;
private String sinifi;
private String bolumu;
private String cinsiyet;
private String evadresi;
private int postakodu;
private String semt;
private String sehir;
private int numara;


public Kayitlar() {
	
}
public Kayitlar(int id, String adi, String soyadi, String sinifi, String bolumu, String cinsiyet,
		String evadresi, int postakodu, String semt, String sehir, int numara) {
	super();
	this.id = id;
	this.adi = adi;
	this.soyadi = soyadi;
	this.sinifi = sinifi;
	this.bolumu = bolumu;
	this.cinsiyet = cinsiyet;
	this.evadresi = evadresi;
	this.postakodu = postakodu;
	this.semt = semt;
	this.sehir = sehir;
	this.numara = numara;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAdi() {
	return adi;
}
public void setAdi(String adi) {
	this.adi = adi;
}
public String getSoyadi() {
	return soyadi;
}
public void setSoyadi(String soyadi) {
	this.soyadi = soyadi;
}
public String getSinifi() {
	return sinifi;
}
public void setSinifi(String sinifi) {
	this.sinifi = sinifi;
}
public String getBolumu() {
	return bolumu;
}
public void setBolumu(String bolumu) {
	this.bolumu = bolumu;
}

public String getCinsiyet() {
	return cinsiyet;
}
public void setCinsiyet(String cinsiyet) {
	this.cinsiyet = cinsiyet;
}
public String getEvadresi() {
	return evadresi;
}
public void setEvadresi(String evadresi) {
	this.evadresi = evadresi;
}
public int getPostakodu() {
	return postakodu;
}
public void setPostakodu(int postakodu) {
	this.postakodu = postakodu;
}
public String getSemt() {
	return semt;
}
public void setSemt(String semt) {
	this.semt = semt;
}
public String getSehir() {
	return sehir;
}
public void setSehir(String sehir) {
	this.sehir = sehir;
}
public int getNumara() {
	return numara;
}
public void setNumara(int numara) {
	this.numara = numara;
}



}
