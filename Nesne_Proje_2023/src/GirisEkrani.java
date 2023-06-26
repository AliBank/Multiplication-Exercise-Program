import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GirisEkrani implements ActionListener{
	
	JFrame frame = new JFrame();
	JTextField t1 = new JTextField("Ad-Soyad");
	JTextField t2 = new JTextField("Password");
	JButton button = new JButton("OK");
	public ArrayList<Kisiler> kisi_List = new ArrayList<Kisiler>();
	
	
	GirisEkrani(){
		
		Kisiler admin = new Kisiler("Ali Bank", 1234, true);
		Kisiler ogr1 = new Kisiler("Mehmet Temel");
		Kisiler ogr2 = new Kisiler("Hasan Cemal");
		Kisiler ogr3 = new Kisiler("Mustafa Tural");
		
		kisi_List.add(admin);
		kisi_List.add(ogr1);
		kisi_List.add(ogr2);
		kisi_List.add(ogr3);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		
		t1.setBounds(50,100, 200,30);  
		t2.setBounds(50,150, 200,30);  
		button.setBounds(100, 200, 70, 30);
		button.addActionListener(this);
		frame.add(t1); 
		frame.add(t2);  
		frame.add(button);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			
			 for (int i = 0; i < kisi_List.size(); i++) {
		            Kisiler k = kisi_List.get(i);
		            if((k.getIsim().equals(t1.getText()))&&(Integer.toString(k.getPassword()).equals(t2.getText()))&&(k.get_is_admin()== true)) {
		            	System.out.println("Hello");
		            	frame.dispose();
		            secim_Ekrani secimEkrani= new secim_Ekrani(kisi_List);
		           
		        }
		    }
			
		}
		
	}
	
	
}
