package Handlers;

import Classes.SMSSender;

public class SMSHandler {
	private SMSSender smsS;
	
	public SMSHandler() {
		this.smsS = new SMSSender();
	}
	
	public void send(String num, String text) {
		this.smsS.setNumber(num);
		this.smsS.setText(text);
		this.smsS.send();
	}
	
	public boolean confirmar(String c�digo) {
		return c�digo.equals(this.smsS.toString());
	}
	
	public String toString() {
		return this.smsS.toString();
	}
}
