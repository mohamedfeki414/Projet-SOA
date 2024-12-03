package projet.plane;

public class Plane {
	private String numPlane;
	private String villeDepart;
	private String villeArrivee;
	private int heureDepart;
	
	public Plane(String numPlane, String villeDepart,String villeArrivee,int heureDepart) {
		
		this.setNumPlane(numPlane);

		this.setVilleDepart(villeDepart);

		this.setVilleArrivee(villeArrivee);

		this.setHeureDepart(heureDepart);
		
	}

	public String getNumPlane() {
		return numPlane;
	}

	public void setNumPlane(String numPlane) {
		this.numPlane = numPlane;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	
 
}
