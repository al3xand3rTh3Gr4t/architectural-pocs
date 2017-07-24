package session.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3557376013614382391L;
	private long cardNumer;

	public long getCardNumer() {
		return cardNumer;
	}

	public void setCardNumer(long cardNumer) {
		this.cardNumer = cardNumer;
	}
	
}
