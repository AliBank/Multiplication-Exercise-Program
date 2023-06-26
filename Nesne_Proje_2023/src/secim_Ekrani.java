import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;


public class secim_Ekrani implements ActionListener  {
	
	public int alt_sinir;
	public int ust_sinir;
	public int soru_sayisi;
	public String ogr_isim;
	public ArrayList<Kisiler> kisiler_List = new ArrayList<Kisiler>();
	
	
	JFrame frame2 = new JFrame();
	JTextField text1 = new JTextField("alt sinir");
	JTextField text2 = new JTextField("ust sinir");
	JTextField text3 = new JTextField("Soru sayisi");
	JTextField text4 = new JTextField("Ogrenci ismi");
	JButton btn = new JButton("Basla");
	
	
	
	secim_Ekrani(ArrayList<Kisiler> kisi_List) {
	
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setSize(620, 620);
	
	text1.setBounds(50,100, 200,30);  
	text2.setBounds(50,150, 200,30); 
	text3.setBounds(50,200, 200,30);
	text4.setBounds(50,250, 200,30);
	
	btn.setBounds(100, 300, 70, 30);
	btn.addActionListener(this);
	frame2.add(text1); 
	frame2.add(text2);
	frame2.add(text3);
	frame2.add(text4);
	frame2.add(btn);
	frame2.setLayout(null);
	frame2.setVisible(true);
	
	kisiler_List.addAll(kisi_List);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			alt_sinir = Integer.parseInt(text1.getText());
			ust_sinir = Integer.parseInt(text2.getText());
			soru_sayisi = Integer.parseInt(text3.getText());
			ogr_isim = text4.getText();
			frame2.dispose();
			carpim_Ekrani carpimEkrani = new carpim_Ekrani(alt_sinir, ust_sinir, soru_sayisi, ogr_isim, kisiler_List);
			}
	}

}
