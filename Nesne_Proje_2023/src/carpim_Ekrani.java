import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDateTime;


public class carpim_Ekrani implements ActionListener {
	private int sayi_h;
	private int sayi_l;
	private int sayi_a;
	private int sayi_b;
	private int counter;
	
	public int minute_time_1 = 0;
	public int seconds_time_1 = 0;
	
	public int minute_time_2 = 0;
	public int seconds_time_2 = 0;
	
	public String ogrenci_isim;
	private log log_Kayit = new log();
	public ArrayList<Kisiler> kisiler_Listesi = new ArrayList<Kisiler>();
	public int gecenZaman = 0;
	public int seconds = 0;
	public int minutes = 0;
	public String seconds_string = String.format("%02d", seconds);
	public String minutes_string = String.format("%02d", minutes);
	
	JLabel timeLabel = new JLabel();
	JFrame framekran = new JFrame();
	JTextField tex = new JTextField();
	JTextField cevap = new JTextField();
	JButton buton = new JButton("ileri");
	
	Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gecenZaman = gecenZaman + 1000;
			minutes = (gecenZaman/60000) % 60;
			seconds = (gecenZaman/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			timeLabel.setText(minutes_string+ ":" + seconds_string);
		}
	});
	
carpim_Ekrani(int alt_sinir, int ust_sinir, int soru_sayisi, String ogr_isim, ArrayList<Kisiler> kisiler_List){
		
		this.ogrenci_isim = ogr_isim;
		log_Kayit.setAlt_Sinir(alt_sinir);
		log_Kayit.setUst_Sinir(ust_sinir);
		log_Kayit.setSoru_Sayisi(soru_sayisi);
		this.counter = soru_sayisi;
		this.sayi_h = ust_sinir;
		this.sayi_l = alt_sinir;
		this.counter--;
		
		framekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framekran.setSize(420, 420);
		tex.setBounds(50,100, 200,30); 
		cevap.setBounds(50, 150, 200, 30);
		
		Random random = new Random();
        sayi_a = random.nextInt(ust_sinir - alt_sinir + 1) + alt_sinir;
        sayi_b = random.nextInt(ust_sinir - alt_sinir + 1) + alt_sinir;
        String carpim_Text = sayi_a + " " + "x " + sayi_b + " = ";
        tex.setText(carpim_Text);
		
		buton.setBounds(100, 200, 70, 30);
		buton.addActionListener(this);
		
		timeLabel.setText(minutes_string+":"+ seconds_string);
		timeLabel.setBounds(50, 250, 200, 40);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		
		framekran.add(tex); 
		framekran.add(cevap);
	    framekran.add(buton);
	    framekran.add(timeLabel);
		framekran.setLayout(null);
		framekran.setVisible(true);
		
		kisiler_Listesi.addAll(kisiler_List);
		LocalDateTime currentTime = LocalDateTime.now();
		log_Kayit.setStartTime(currentTime);
		
		timer.start();
        
	}
	
	
	public int getSayi_h() {
		return sayi_h;
	}

	public void setSayi_h(int sayi_h) {
		this.sayi_h = sayi_h;
	}

	public int getSayi_l() {
		return sayi_l;
	}

	public void setSayi_l(int sayi_l) {
		this.sayi_l = sayi_l;
	}

	
	public int getSayi_a() {
		return sayi_a;
	}

	public void setSayi_a(int sayi_a) {
		this.sayi_a = sayi_a;
	}

	public int getSayi_b() {
		return sayi_b;
	}

	public void setSayi_b(int sayi_b) {
		this.sayi_b = sayi_b;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public log getLog_Kayit() {
		return log_Kayit;
	}

	public void setLog_Kayit(log log_Kayit) {
		this.log_Kayit = log_Kayit;
	}

	

	
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() == buton) && (counter > 0) && (cevap.getText() != null) && (!cevap.getText().isEmpty())) {
			int answer = Integer.parseInt(cevap.getText());
			
			if(answer == sayi_a * sayi_b) {
				log_Kayit.DogruYanlis_add(true);
			}
			
			this.seconds_time_2 = this.seconds;
			this.minute_time_2 = this.minutes;
			
	        int perDakika = this.minute_time_2 - this.minute_time_1;
			int perSaniye = this.seconds_time_2 - this.seconds_time_1;
			log_Kayit.kacSaniye_add((60 * perDakika) + perSaniye);
			
			
			Random random = new Random();
	        sayi_a = random.nextInt(sayi_h - sayi_l + 1) + sayi_l;
	        sayi_b = random.nextInt(sayi_h - sayi_l + 1) + sayi_l;
	        String carpim_Text = sayi_a + " " + "x " + sayi_b + " = ";
	        tex.setText(carpim_Text);
	        log_Kayit.Sorular_add(carpim_Text);
	        
	        this.minute_time_1 = this.minute_time_2;
	        this.seconds_time_1 = this.seconds_time_2;
	        this.cevap.setText("");
	        counter--;
	        
		}
		
		if((e.getSource() == buton) && (counter == 0) && (cevap.getText() != null) && (!cevap.getText().isEmpty())) {
			
			timer.stop();
			LocalDateTime currentEndTime = LocalDateTime.now();
			log_Kayit.setEndTime(currentEndTime);
			log_Kayit.setKacDakika(minutes);
			gecenZaman = 0;
			minutes = 0;
			seconds = 0;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			timeLabel.setText(minutes_string+ ":" + seconds_string);
			framekran.dispose();
			secim_Ekrani yeni_secimEkrani = new secim_Ekrani(kisiler_Listesi);
			
			for (int i = 0; i < kisiler_Listesi.size(); i++) {
				if(kisiler_Listesi.get(i).getIsim().equals(this.ogrenci_isim)) {
					Kisiler temp_Kisi = kisiler_Listesi.get(i);
					temp_Kisi.addLog_List(log_Kayit);
				}
			}
			int dogru_sayisi = 0;
			for (int i = 0; i < log_Kayit.getDogruYanlis().size(); i++) {
				if(log_Kayit.getDogruYanlis().get(i)) {
					dogru_sayisi ++;
				}
			}
			
			log_Kayit.setDogruluk_Skoru(log_Kayit.getSoru_Sayisi() / dogru_sayisi);
			log_Kayit.setHiz_Skoru(log_Kayit.getSoru_Sayisi() / (int)(log_Kayit.getKacDakika()));
			log_Kayit.setBasari_Skoru(dogru_sayisi / (int)(log_Kayit.getKacDakika()));
			
			
		}
	}
}
