package Handlers;

import Classes.Ajuda;
import Classes.Alojamento;
import Classes.Item;
import Classes.Regi�o;
import Classes.Volunt�rio;

public class CriarAjudaHandler {
	private Ajuda a;
	
	public void criarAlojamento(String cap, Volunt�rio v) {
		this.a = new Alojamento(cap, true, v);
	}
	
	public void defineRegi�o(Regi�o r) {
		this.a.defineRegi�o(r);
	}
	
	public void criarItem(String desc, Volunt�rio v) {
		this.a = new Item(desc, false, v);
	}
	
	public Ajuda criarOfertaDeAjuda() {
		return this.a;
	}
}
