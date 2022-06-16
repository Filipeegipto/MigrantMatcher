package Classes;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;
import com.telegramsms.TelegramSMSSender;

public class SMSSender extends TelegramSMSSender {
	private PidgeonSMSSender ps;
	private String num;
	private String txt;
	
	public SMSSender() {
		this.ps = new PidgeonSMSSender();
	}
	

	@Override
	public void send() {
		this.ps.send(this.num, this.txt);
	}


	@Override
	public void setNumber(String num) {
		this.num = num;
	}


	@Override
	public void setText(String txt) {
		this.txt = txt;
	}


	@Override
	public String toString() {
		return this.txt;
	}
}
