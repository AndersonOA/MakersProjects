/**
 * 
 */
package br.com.makersweb.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@ServerEndpoint("/ws/hello")
public class HelloWS {
	
	private static final Logger LOGGER = Logger.getLogger(HelloWS.class);

	public HelloWS() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("WebSocket Instanciado!");
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Session [%s] opened.", session.getId()));
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Session [%s] closed.", session.getId()));
		}
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		LOGGER.error(String.format("Error on Session [%s].", session.getId()), throwable);
	}
	
	@OnMessage
	public String onHelloMessage(String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Message received [%s].", message));
		}
		
		return "Message received = " + message;
	}

}
