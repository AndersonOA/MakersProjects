/**
 * 
 */
package br.com.makersweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Controller
public class HelloWSController {

	@RequestMapping(value = "helloWS.html")
	public ModelAndView helloWS() {
		ModelAndView mav = new ModelAndView("helloWS");
		
		return mav;
	}
}
