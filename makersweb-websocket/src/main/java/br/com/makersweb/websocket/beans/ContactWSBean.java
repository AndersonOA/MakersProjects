/**
 * 
 */
package br.com.makersweb.websocket.beans;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.utils.BaseBean;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class ContactWSBean extends BaseBean {

	private static final long serialVersionUID = -5613124901916216164L;
	private final Contact contact;
	private final String action;

	public ContactWSBean(Contact contact, String action) {
		this.contact = contact;
		this.action = action;
	}

	public Contact getContact() {
		return contact;
	}

	public String getAction() {
		return action;
	}
}
