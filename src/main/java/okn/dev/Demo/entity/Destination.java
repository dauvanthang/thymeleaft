package okn.dev.Demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Destination {
    @Id
    private int maVung;
    
    private String tenVung;

	public int getMaVung() {
		return maVung;
	}

	public void setMaVung(int maVung) {
		this.maVung = maVung;
	}

	public String getTenVung() {
		return tenVung;
	}

	public void setTenVung(String tenVung) {
		this.tenVung = tenVung;
	}

    

}
