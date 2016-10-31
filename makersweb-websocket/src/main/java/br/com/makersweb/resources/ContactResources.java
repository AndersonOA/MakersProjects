/**
 * 
 */
package br.com.makersweb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.services.ContactServices;
import br.com.makersweb.services.exceptions.BusinessException;
import br.com.makersweb.utils.DefaultResponse;
import br.com.makersweb.utils.MakersWebUtils;
import br.com.makersweb.websocket.ContactWS;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RestController
@RequestMapping("/api")
public class ContactResources {
	
	@Autowired
	private ContactServices contactServices;

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Contact request) {
		DefaultResponse response = new DefaultResponse();
		
		try {
			Contact contact = contactServices.salvar(request);
			ContactWS.sendContact(contact, MakersWebUtils.STS_ADD);
			
			response.setError(false);
			response.setTypeError(MakersWebUtils.E_USER_SUCESS);
			response.setMessage(MakersWebUtils.AjaxErro("Contato Cadastrado com sucesso!", MakersWebUtils.E_USER_SUCESS));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(MakersWebUtils.E_USER_WARNING);
			response.setMessage(MakersWebUtils.AjaxErro(e.getMessage(), MakersWebUtils.E_USER_WARNING));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
