package Classes;

public class Item extends Ajuda {

	public Item(String descri��o, boolean �Aloj, Volunt�rio v) {
		super(descri��o, �Aloj, v);
	}
	
	public String toString() {
		return "Item: " + super.getDescri��o();
	}
}
