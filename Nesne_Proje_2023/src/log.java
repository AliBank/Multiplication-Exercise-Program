import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;

public class log {
	
	private LocalDateTime startTime;
	private  LocalDateTime endTime;
	private long kacDakika;
	private int soru_Sayisi;
	private int ust_Sinir;
	private int alt_Sinir;
	private ArrayList<Integer> kacSaniye = new ArrayList<Integer>();
	private ArrayList<Boolean> DogruYanlis = new ArrayList<>();
	public ArrayList<String> Sorular = new ArrayList<String>();
	private int hiz_Skoru;
	private int dogruluk_Skoru;
	private int basari_Skoru;
	
	
	public void kacSaniye_add(int a) {
		kacSaniye.add(a);
		
	}
	

	public void DogruYanlis_add(boolean a) {
		DogruYanlis.add(a);
		
	}
	

	public void Sorular_add(String a) {
		Sorular.add(a);
		
	}
	
	
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public long getKacDakika() {
		return kacDakika;
	}
	public void setKacDakika(long kacDakika) {
		this.kacDakika = kacDakika;
	}
	public int getSoru_Sayisi() {
		return soru_Sayisi;
	}
	public void setSoru_Sayisi(int soru_Sayisi) {
		this.soru_Sayisi = soru_Sayisi;
	}
	public int getUst_Sinir() {
		return ust_Sinir;
	}
	public void setUst_Sinir(int ust_Sinir) {
		this.ust_Sinir = ust_Sinir;
	}
	public int getAlt_Sinir() {
		return alt_Sinir;
	}
	public void setAlt_Sinir(int alt_Sinir) {
		this.alt_Sinir = alt_Sinir;
	}
	public ArrayList<Integer> getKacSaniye() {
		return kacSaniye;
	}
	public void setKacSaniye(ArrayList<Integer> kacSaniye) {
		this.kacSaniye = kacSaniye;
	}
	public ArrayList<Boolean> getDogruYanlis() {
		return DogruYanlis;
	}
	public void setDogruYanlis(ArrayList<Boolean> dogruYanlis) {
		DogruYanlis = dogruYanlis;
	}
	
	
	public ArrayList<String> getSorular() {
		return Sorular;
	}
	public void setSorular(ArrayList<String> sorular) {
		Sorular = sorular;
	}
	public int getHiz_Skoru() {
		return hiz_Skoru;
	}
	public void setHiz_Skoru(int hiz_Skoru) {
		this.hiz_Skoru = hiz_Skoru;
	}
	public int getDogruluk_Skoru() {
		return dogruluk_Skoru;
	}
	public void setDogruluk_Skoru(int dogruluk_Skoru) {
		this.dogruluk_Skoru = dogruluk_Skoru;
	}
	public int getBasari_Skoru() {
		return basari_Skoru;
	}
	public void setBasari_Skoru(int basari_Skoru) {
		this.basari_Skoru = basari_Skoru;
	}
	
	
}
