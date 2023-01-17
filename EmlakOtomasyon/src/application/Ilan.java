package application;

public class Ilan {
	
	private int id;
	private String baslik;
	private String kategori;
	private String tur;
	private String sehir;
	private int katsay;
	private int bulkat;
	private int odasay;
	private int metrekare;
	private double fiyat;
	private String adres;
	private String aciklama;
	
	Ilan()
	{
		
	}
	
	Ilan(int id,String baslik, String kategori, String tur, String sehir, int katsay, int bulkat, int odasay, int metrekare, double fiyat, String adres, String aciklama)
	{
		this.id=id;
		this.baslik=baslik;
		this.kategori=kategori;
		this.tur=tur;
		this.sehir=sehir;
		this.katsay=katsay;
		this.bulkat=bulkat;
		this.odasay=odasay;
		this.metrekare=metrekare;
		this.fiyat=fiyat;
		this.adres=adres;
		this.aciklama=aciklama;
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public int getKatsay() {
		return katsay;
	}

	public void setKatsay(int katsay) {
		this.katsay = katsay;
	}

	public int getBulkat() {
		return bulkat;
	}

	public void setBulkat(int bulkat) {
		this.bulkat = bulkat;
	}

	public int getOdasay() {
		return odasay;
	}

	public void setOdasay(int odasay) {
		this.odasay = odasay;
	}

	public int getMetrekare() {
		return metrekare;
	}

	public void setMetrekare(int metrekare) {
		this.metrekare = metrekare;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	

}
