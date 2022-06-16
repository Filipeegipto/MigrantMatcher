package Handlers;
import Classes.CatUtilizadores;
import Classes.Voluntário;

public class IdentificarHandler {
	
	private CatUtilizadores catUtilizadores;
	
	public IdentificarHandler () {
		this.catUtilizadores = new CatUtilizadores();
	}

	public Voluntário criarVoluntário(int numTelefone) {
		return catUtilizadores.criarVoluntário(numTelefone);
	}

}
