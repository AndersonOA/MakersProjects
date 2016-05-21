package br.com.makersweb.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.makersweb.socialbooks.domain.Autor;
import br.com.makersweb.socialbooks.repository.AutoresRepository;

@Service
public class AutoresServices {
	
	@Autowired
	private AutoresRepository autorRepository;
	
	public List<Autor> listar() {
		return autorRepository.findAll();
	}
	
	

}
