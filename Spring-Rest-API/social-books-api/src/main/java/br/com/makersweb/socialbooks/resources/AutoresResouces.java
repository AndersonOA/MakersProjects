package br.com.makersweb.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.socialbooks.domain.Autor;
import br.com.makersweb.socialbooks.services.AutoresServices;

@RestController
@RequestMapping("/autores")
public class AutoresResouces {

	@Autowired
	private AutoresServices autorServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(autorServices.listar());
	}
}
