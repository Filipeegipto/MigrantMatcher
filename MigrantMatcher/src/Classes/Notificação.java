package Classes;
import Handlers.SMSHandler;

public class Notificação {
	private Região região;
	private Migrante migrante;
	private SMSHandler smsh;
	
	public Notificação(Região r, Migrante m, SMSHandler sh) {
		this.região = r;
		this.migrante = m;
		this.smsh = sh;
	}
	
	public void send() {
		this.smsh.send(((Integer) this.migrante.getNumero()).toString(), "Já existem ajudas disponiveis na região " + this.região.getNome());
	}
}
