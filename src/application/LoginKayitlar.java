package application;

public class LoginKayitlar {
	private int id;
	private String adi;
	private String sifre;
	public LoginKayitlar(int id, String adi, String sifre) {
		super();
		this.id = id;
		this.adi = adi;
		this.sifre = sifre;
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
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
