package Handlers;
import Classes.CatUtilizadores;
import Classes.Volunt�rio;

public class IdentificarHandler {
	
	private CatUtilizadores catUtilizadores;
	
	public IdentificarHandler () {
		this.catUtilizadores = new CatUtilizadores();
	}

	public Volunt�rio criarVolunt�rio(int numTelefone) {
		return catUtilizadores.criarVolunt�rio(numTelefone);
	}

}
