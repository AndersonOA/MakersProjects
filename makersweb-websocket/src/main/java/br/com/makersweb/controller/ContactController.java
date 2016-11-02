/**
 * 
 */
package br.com.makersweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.services.ContactServices;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Controller
public class ContactController {
	
	@Autowired
	private ContactServices contactServices;
	
	@RequestMapping(value = "listWS.html")
	public ModelAndView contacts() {
		ModelAndView mav = new ModelAndView("listWS");
		mav.addObject("contacts", obtemContacts());
		
		return mav;
	}
	
	@RequestMapping(value = "listar.html")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("listar");
		mav.addObject("contacts", obtemContacts());
		
		return mav;
	}
	
	@RequestMapping(value = "create.html")
	public ModelAndView create(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("create");
		
		if (!ObjectUtils.isEmpty(id)) {
			mav.addObject("contact", obtemContact(id));
		}
		
		return mav;
	}
	
	private List<Contact> obtemContacts() {
		List<Contact> contacts = contactServices.listar();
		
		if (!ObjectUtils.isEmpty(contacts) && contacts.size() > 0) {
			return contacts;
		}
		
		return new ArrayList<Contact>();
	}
	
	private Contact obtemContact(Long id) {
		return contactServices.buscar(id);
	}

}
