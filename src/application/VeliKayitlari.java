package application;

public class VeliKayitlari {
	
	private int id;
	private String adi;
	private String soyadi;
	private String yakinligi;
	private String egitimdurumu;
	private int postakodu;
	private int telefon;
	private int tc;
	private int gelir;
	private String isadresi;
	private String evadresi;
	public VeliKayitlari() {
		super();
	}
	public VeliKayitlari(int id, String adi, String soyadi, String yakinligi, String egitimdurumu, 
			int postakodu, int telefon, int tc, int gelir, String isadresi, String evadresi) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.yakinligi = yakinligi;
		this.egitimdurumu = egitimdurumu;
		this.postakodu = postakodu;
		this.telefon = telefon;
		this.tc = tc;
		this.gelir = gelir;
		this.isadresi = isadresi;
		this.evadresi = evadresi;
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
	public String getYakinligi() {
		return yakinligi;
	}
	public void setYakinligi(String yakinligi) {
		this.yakinligi = yakinligi;
	}
	public String getEgitimdurumu() {
		return egitimdurumu;
	}
	public void setEgitimdurumu(String egitimdurumu) {
		this.egitimdurumu = egitimdurumu;
	}
	public int getPostakodu() {
		return postakodu;
	}
	public void setPostakodu(int postakodu) {
		this.postakodu = postakodu;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	public int getGelir() {
		return gelir;
	}
	public void setGelir(int gelir) {
		this.gelir = gelir;
	}
	public String getIsadresi() {
		return isadresi;
	}
	public void setIsadresi(String isadresi) {
		this.isadresi = isadresi;
	}
	public String getEvadresi() {
		return evadresi;
	}
	public void setEvadresi(String evadresi) {
		this.evadresi = evadresi;
	}
	
	

}
