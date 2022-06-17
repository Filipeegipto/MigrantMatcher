package Main;
import java.util.Random;
import java.util.Scanner;

import Classes.Migrante;
import Classes.NoSuchHelpException;
import Classes.NoSuchRegionException;
import Classes.Volunt�rio;
import Handlers.CriarAjudaHandler;
import Handlers.CriarOfertaDeAjudaHandler;
import Handlers.IdentificarHandler;
import Handlers.PedirAjudaHandler;
import Handlers.RegistarHandler;
import Handlers.SMSHandler;

public class MigrantMatcher {

	private CriarAjudaHandler cah;
	private CriarOfertaDeAjudaHandler codah;
	private IdentificarHandler ih;
	private PedirAjudaHandler pah;
	private RegistarHandler rh;
	private SMSHandler sh;
	
	public static void main (String[] args) throws NoSuchRegionException, NoSuchHelpException {
		MigrantMatcher m = new MigrantMatcher();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			String s = "";
			System.out.println("� Volunt�rio ou Migrante?");
			s = sc.nextLine();
			if (s.equals("Volunt�rio")) {
				m.runVolunt�rio(sc);
			} else if (s.equals("Migrante")){
				m.runMigrante(sc);
			} else {
				System.out.println("Input inv�lido");
			}
		}
		sc.close();
	}
	
	private MigrantMatcher() {
		String[] regi�es = {"geral", "Viana do Castelo", "Braga", "Vila Real", "Bragan�a", "Porto", 
				"Aveiro", "Viseu", "Guarda", "Coimbra", "Castelo Branco", "Leiria", "Santar�m",
				"Portalegre", "Lisboa", "Set�bal", "�vora", "Beja", "Faro", "Funchal", 
				"S�o Miguel", "Pico", "Terceira", "S�o Jorge", "Faial", "Flores"};
		this.cah = new CriarAjudaHandler();
		this.ih = new IdentificarHandler();
		this.pah = new PedirAjudaHandler(regi�es);
		this.codah = new CriarOfertaDeAjudaHandler(this.pah.pedirListaDeRegi�es());
		this.rh = new RegistarHandler();
		this.sh = new SMSHandler();
	}
	
	private void runVolunt�rio(Scanner sc) {
		System.out.println("Indique o seu n�mero de telefone");
		Volunt�rio v = this.ih.criarVolunt�rio(Integer.parseInt(sc.nextLine()));
		System.out.println("Pretende oferecer Alojamento ou Item?");
		String s = sc.nextLine();
		if(s.equals("Alojamento")) {
			System.out.println("Insira a capacidade do seu alojamento:");
			this.cah.criarAlojamento(sc.nextLine(), v);
			System.out.println("Indique em qual das seguintes regi�es se "
					+ "encontra a sua estadia \n" + this.pah.pedirListaDeRegi�es().toString());
			this.cah.defineRegi�o(this.pah.getRegi�o(sc.nextLine()));
		} else if (s.equals("Item")) {
			System.out.println("Indique a descri��o do Item");
			this.cah.criarItem(sc.nextLine(), v);
		} else {
			System.out.println("Input inv�lido");
		}
		Random rd = new Random();
		Integer n = (Integer) v.getNumero();
		Integer t = (Integer) rd.nextInt(100000);
		this.sh.send(n.toString(), t.toString());
		System.out.println("Introduza o c�digo que recebeu para confirmar a ajuda. \n");
		if(this.sh.confirmar(sc.nextLine()))
			this.codah.criarOfertaDeAjuda(this.cah.criarOfertaDeAjuda());
	}
	
	private void runMigrante(Scanner sc) throws NoSuchRegionException, NoSuchHelpException {
		System.out.println("Pretende registar-se Individualmente ou em Familia?");
		String s = sc.nextLine();
		if(s.equals("Individualmente")) {
			System.out.println("Indique o seu nome e n�mero de telefone, separados por um espa�o");
			s = sc.nextLine();
			Migrante m = this.rh.criarMigrante(s.substring(0, s.indexOf(" ")), 
					Integer.parseInt(s.substring(s.indexOf(" ")+1)));
			procuraAjuda(s, sc, m);
		} else if (s.equals("Familia")) {
			System.out.println("Indique o tamanho do seu agregado familiar.");
			this.rh.criarFamilia(Integer.parseInt(sc.nextLine()));
			System.out.println("Indique o seu nome e n�mero de telefone, separados por um espa�o");
			s = sc.nextLine();
			Migrante m = this.rh.criarMigranteCabe�a(s.substring(0, s.indexOf(" ")), 
					Integer.parseInt(s.substring(s.indexOf(" ")+1)));
			boolean adicionarMembro = true;
			while(adicionarMembro) {
				System.out.println("Indique o nome de um membro familiar.");
				this.rh.criarMigrante(sc.nextLine());				
				System.out.println("Pretende adicionar mais algum membro?");
				s = sc.nextLine();
				if(!s.equals("Sim") && !s.equals("sim"))
					adicionarMembro = false;
			}
			procuraAjuda(s, sc, m);
		} else {
			System.out.println("Input inv�lido");
		}
	}
	
	private void procuraAjuda(String s, Scanner sc, Migrante m) throws NoSuchRegionException, NoSuchHelpException {
		System.out.println("Aqui tem a lista de regi�es: \n" + this.pah.pedirListaDeRegi�es().toString());
		System.out.println("Indique a regi�o desejada. \n");
		s = this.pah.escolherRegi�o(sc.nextLine()).toString(0);
		if (!s.equals("N�o existem ajudas disponiveis nesta regi�o. \n")) {
			System.out.println("Aqui tem a lista de ajudas disponiveis. \n" + s); 
			int[] ajudas = new int[10]; //tamanho suficiente
			int at = -1;
			boolean querMais = true;
			while(querMais) {
				at++;
				System.out.println("Indique o n�mero da ajuda pretendida.");
				ajudas[at] = Integer.parseInt(sc.nextLine());
				this.pah.criarPedido(ajudas[at], m);
				System.out.println("Pretende adicionar mais ajudas? \n");
				s = sc.nextLine();
				if(!s.equals("Sim") && !s.equals("sim")) {
					querMais = false;
				}
			}
			System.out.println("Deseja confirmar?");
			s = sc.nextLine();
			if(s.equals("Sim") || s.equals("sim"))
				for(int i = 0; i <= at; i++) {
					Integer dest = (Integer) this.pah.confirmarPedido(ajudas[i]).getNumero();
					this.sh.send(dest.toString(), "Uma ajuda sua foi atribuida, obrigado!");
				}
		} else {
			System.out.println(s + "Deseja ser notificado quando houverem?");
			s = sc.nextLine();
			if (s.equals("sim") || s.equals("Sim")) {
				this.pah.serNotificado(m, this.sh);
			}
		}
	}
}
