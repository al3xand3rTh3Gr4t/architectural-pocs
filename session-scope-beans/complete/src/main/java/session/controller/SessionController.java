package session.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import session.dto.Card;
import session.dto.User;
import session.dto.UserContext;

@RestController
@RequestMapping("/sessionService")
public class SessionController {

	@Autowired
	UserContext userContext;
	
    @Autowired
    private Provider<User> userProvider;
	
	@Autowired 
	Card card;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/sessionMatters/{name}/{surname}/{takeFromSession}")
	public void greeting(@PathVariable(value = "name") String name,
			@PathVariable(value = "surname") String surname,
//			@RequestParam(value = "takeFromSession", required = false) boolean takeFromSession
			@PathVariable("takeFromSession")boolean takeFromSession) {

		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = attr.getRequest().getSession(!takeFromSession);

		if(takeFromSession){
			Card card = userContext.getCard();
			User user = userContext.getUser();
			
			userContext = (UserContext)httpSession.getAttribute("userContext");
		} else {
			User user = userProvider.get();
			user.setName(name);
			user.setSurname(surname);
			user.setId(counter.incrementAndGet());
			
			
			card.setCardNumer(counter.incrementAndGet());
			
			userContext.setCard(card);
			
			httpSession.setAttribute("userContext", userContext);
		}

		return;
	}
	
	@RequestMapping("/getUserContextFromSpringContext")
	public void getUserContextFromSpringContext(){
		Card card = userContext.getCard();
		User user = userContext.getUser();
		
		return;
	}
}
