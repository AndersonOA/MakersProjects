/**
 * 
 */
package br.com.makersweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RestController
@RequestMapping("/")
public class TesteController {
	
	@RequestMapping(value = "index.html")
	public @ResponseBody String hello() {
		return "{value: 'Hello word.'}";
	}

}
