package Classes;

public class Ajuda {
	private Regi„o regi„o;
	private boolean ÈAl;
	private String desc;
	private Volunt·rio vol;
	private Migrante mig;
	
	public Ajuda(String descriÁ„o, boolean ÈAloj, Volunt·rio v) {
		this.ÈAl = ÈAloj;
		this.desc = descriÁ„o;
		this.vol = v;
	}
	
	public void defineRegi„o(Regi„o r) {
		this.regi„o = r;
	}

	public Regi„o getRegi„o() {
		return this.regi„o;
	}
	
	public boolean ÈAlojamento() {
		return this.ÈAl;
	}
	
	public String getDescriÁ„o() {
		return this.desc;
	}
	
	public Volunt·rio getVolunt·rio() {
		return this.vol;
	}
	
	public void setMigrante(Migrante m) {
		this.mig = m;
	}	
}
