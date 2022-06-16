package Handlers;

import Classes.Ajuda;
import Classes.Alojamento;
import Classes.Item;
import Classes.Região;
import Classes.Voluntário;

public class CriarAjudaHandler {
	private Ajuda a;
	
	public void criarAlojamento(String cap, Voluntário v) {
		this.a = new Alojamento(cap, true, v);
	}
	
	public void defineRegião(Região r) {
		this.a.defineRegião(r);
	}
	
	public void criarItem(String desc, Voluntário v) {
		this.a = new Item(desc, false, v);
	}
	
	public Ajuda criarOfertaDeAjuda() {
		return this.a;
	}
}
