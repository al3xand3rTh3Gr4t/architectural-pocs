package session.dto;

import java.io.Serializable;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserContext implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 2109876312575251947L;

	@Autowired
	private Card card;
	
    @Autowired
    private Provider<User> userProvider;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public User getUser() {
		return userProvider.get();
	}


}
