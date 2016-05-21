package br.com.makersweb.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.makersweb.socialbooks.domain.Autor;
import br.com.makersweb.socialbooks.repository.AutoresRepository;
import br.com.makersweb.socialbooks.services.exceptions.AutorExistenteException;
import br.com.makersweb.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresServices {
	
	@Autowired
	private AutoresRepository autorRepository;
	
	public List<Autor> listar() {
		return autorRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = autorRepository.findOne(autor.getId());
			
			if (null != a) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		
		return autorRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autorRepository.findOne(id);
		
		if (null == autor) {
			throw new AutorNaoEncontradoException("Autor não encontrado.");
		}
		
		return autor;
	}

}
