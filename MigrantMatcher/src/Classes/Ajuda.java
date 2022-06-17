package Classes;

public class Ajuda {
	private Regi�o regi�o;
	private boolean �Al;
	private String desc;
	private Volunt�rio vol;
	private Migrante mig;
	
	public Ajuda(String descri��o, boolean �Aloj, Volunt�rio v) {
		this.�Al = �Aloj;
		this.desc = descri��o;
		this.vol = v;
	}
	
	public void defineRegi�o(Regi�o r) {
		this.regi�o = r;
	}

	public Regi�o getRegi�o() {
		return this.regi�o;
	}
	
	public boolean �Alojamento() {
		return this.�Al;
	}
	
	public String getDescri��o() {
		return this.desc;
	}
	
	public Volunt�rio getVolunt�rio() {
		return this.vol;
	}
	
	public void setMigrante(Migrante m) {
		this.mig = m;
	}	
}
