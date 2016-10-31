/**
 * 
 */
package br.com.makersweb.services;

import java.util.List;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.services.exceptions.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface ContactServices {

	Contact salvar(Contact contact) throws BusinessException;

	List<Contact> listar();

	Contact atualizar(Contact contact) throws BusinessException;
	
	Contact buscar(Long id) throws BusinessException;

	void excluir(Long id) throws BusinessException;

	void verificaExistencia(Contact contact) throws BusinessException;

}
