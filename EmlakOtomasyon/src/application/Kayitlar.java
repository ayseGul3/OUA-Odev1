package application;

public class Kayitlar {
	
	private String ad;
	private String soyad;
	private String kulad;
	private String tel;
	private String eposta;
	private String sifre;

	
	Kayitlar()
	{
		
	}
	Kayitlar(String ad,String soyad,String kulad,String tel,String eposta,String sifre)
	{
		this.ad=ad;
		this.soyad=soyad;
		this.kulad=kulad;
		this.tel=tel;
		this.eposta=eposta;
		this.sifre=sifre;
	}
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getKulad() {
		return kulad;
	}
	public void setKulad(String kulad) {
		this.kulad = kulad;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}


}
