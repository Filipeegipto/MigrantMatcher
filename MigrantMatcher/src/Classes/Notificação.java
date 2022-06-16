package Classes;
import Handlers.SMSHandler;

public class Notifica��o {
	private Regi�o regi�o;
	private Migrante migrante;
	private SMSHandler smsh;
	
	public Notifica��o(Regi�o r, Migrante m, SMSHandler sh) {
		this.regi�o = r;
		this.migrante = m;
		this.smsh = sh;
	}
	
	public void send() {
		this.smsh.send(((Integer) this.migrante.getNumero()).toString(), "J� existem ajudas disponiveis na regi�o " + this.regi�o.getNome());
	}
}
