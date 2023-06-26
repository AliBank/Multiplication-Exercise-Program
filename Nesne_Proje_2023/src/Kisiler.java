import java.util.ArrayList;

public class Kisiler {
	private String isim;
	private int password;
	private boolean is_admin;
	private ArrayList<log> log_List = new ArrayList<log>();
	
	public Kisiler(String isim, int password, boolean is_admin) {
		
		this.isim = isim;
		this.password = password;
		this.is_admin = is_admin;
	}
	
	public Kisiler(String isim) {
		this.isim= isim;
	}

	public String getIsim() {
		return isim;
	}

	public int getPassword() {
		return password;
	}
	
	public boolean get_is_admin() {
		return is_admin;
	}
	
	public ArrayList<log> getLog_List() {
		return log_List;
	}
	
	public void addLog_List(log yeni_Log) {
		log_List.add(yeni_Log);
	}
	
	

}
