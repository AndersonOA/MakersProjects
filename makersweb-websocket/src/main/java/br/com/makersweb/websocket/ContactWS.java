/**
 * 
 */
package br.com.makersweb.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.websocket.beans.ContactWSBean;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@ServerEndpoint("/ws/contact")
public class ContactWS {
	
	private static final Logger LOGGER = Logger.getLogger(ContactWS.class);
	private static final Set<Session> SESSIONS;
	private static final ObjectMapper JSON_MAPPER;
	
	static {
		SESSIONS = Collections.synchronizedSet(new HashSet<Session>());
		JSON_MAPPER = new ObjectMapper();
	}
	
	@OnOpen
	public void onOpen(Session session) {
		LOGGER.info(String.format("Sessão [%s] aberta.", session.getId()));
		
		SESSIONS.add(session);
	}
	
	@OnClose
	public void onClose(Session session) {
		LOGGER.info(String.format("Sessão [%s] fechada.", session.getId()));
		
		SESSIONS.remove(session);
	}
	
	public static void sendContact(Contact contact, String action) {
		try {
			ContactWSBean contactWS = new ContactWSBean(contact, action);
			String json = JSON_MAPPER.writeValueAsString(contactWS);
			for (Session session : SESSIONS) {
				session.getBasicRemote().sendText(json);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		
	}

}
