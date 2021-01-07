package application;



public class OdevTakipKayitlar {
	
	
	private int Id;
	private String adi;
	private String soyadi;
	private String sinifi;
	private String bolumu;
	private String odevalacagiders;
	private String konusu;
	private String Vtarihi;
	private String Ttarihi;
	private int not;
	private String mail;
	public OdevTakipKayitlar() {
		super();
	}
	public OdevTakipKayitlar(int id, String adi, String soyadi, String sinifi, String bolumu, String odevalacagiders,
			String konusu, String vtarihi, String ttarihi, int not, String mail) {
		super();
		Id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.sinifi = sinifi;
		this.bolumu = bolumu;
		this.odevalacagiders = odevalacagiders;
		this.konusu = konusu;
		Vtarihi = vtarihi;
		Ttarihi = ttarihi;
		this.not = not;
		this.mail = mail;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getOdevalacagiders() {
		return odevalacagiders;
	}
	public void setOdevalacagiders(String odevalacagiders) {
		this.odevalacagiders = odevalacagiders;
	}
	public String getKonusu() {
		return konusu;
	}
	public void setKonusu(String konusu) {
		this.konusu = konusu;
	}
	public String getVtarihi() {
		return Vtarihi;
	}
	public void setVtarihi(String vtarihi) {
		Vtarihi = vtarihi;
	}
	public String getTtarihi() {
		return Ttarihi;
	}
	public void setTtarihi(String ttarihi) {
		Ttarihi = ttarihi;
	}
	public int getNot() {
		return not;
	}
	public void setNot(int not) {
		this.not = not;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
