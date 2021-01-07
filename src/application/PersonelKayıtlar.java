package application;

public class PersonelKayýtlar {
	
	private int id;
	private String adi;
	private String soyadi;
	private String gorevi;
	private String cinsiyeti;
	private String evadresi;
	private String semt;
	private String sehir;
	private int postakodu;
	private int maas;
	public PersonelKayýtlar() {
		super();
	}
	public PersonelKayýtlar(int id, String adi, String soyadi, String gorevi, String cinsiyeti, String evadresi,
			String semt, String sehir, int postakodu, int maas) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.gorevi = gorevi;
		this.cinsiyeti = cinsiyeti;
		this.evadresi = evadresi;
		this.semt = semt;
		this.sehir = sehir;
		this.postakodu = postakodu;
		this.maas = maas;
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
	public String getGorevi() {
		return gorevi;
	}
	public void setGorevi(String gorevi) {
		this.gorevi = gorevi;
	}
	public String getCinsiyeti() {
		return cinsiyeti;
	}
	public void setCinsiyeti(String cinsiyeti) {
		this.cinsiyeti = cinsiyeti;
	}
	public String getEvadresi() {
		return evadresi;
	}
	public void setEvadresi(String evadresi) {
		this.evadresi = evadresi;
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
	public int getPostakodu() {
		return postakodu;
	}
	public void setPostakodu(int postakodu) {
		this.postakodu = postakodu;
	}
	public int getMaas() {
		return maas;
	}
	public void setMaas(int maas) {
		this.maas = maas;
	}
	

}
