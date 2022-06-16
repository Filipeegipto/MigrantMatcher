package Classes;

public class Item extends Ajuda {

	public Item(String descrição, boolean éAloj, Voluntário v) {
		super(descrição, éAloj, v);
	}
	
	public String toString() {
		return "Item: " + super.getDescrição();
	}
}
