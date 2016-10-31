/**
 * 
 */
package br.com.makersweb.services.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import br.com.makersweb.domain.Contact;
import br.com.makersweb.repository.ContactRepository;
import br.com.makersweb.services.ContactServices;
import br.com.makersweb.services.exceptions.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Service
@EnableTransactionManagement
public class ContactServicesImpl implements ContactServices {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Contact salvar(Contact contact) throws BusinessException {
		if (!ObjectUtils.isEmpty(contact)) {
			if (StringUtils.isEmpty(contact.getFirstName()) || StringUtils.isEmpty(contact.getLastName())
					|| StringUtils.isEmpty(contact.getEmail()) || StringUtils.isEmpty(contact.getPhone())) {
				throw new BusinessException("Por favor informe todos os campos.");
			}
		} else {
			throw new BusinessException("Por favor informe todos os campos.");
		}

		return contactRepository.save(contact);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Contact> listar() {
		return contactRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Contact atualizar(Contact contact) throws BusinessException {
		verificaExistencia(contact);

		return contactRepository.save(contact);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Contact buscar(Long id) throws BusinessException {
		Contact contact = contactRepository.findOne(id);

		if (ObjectUtils.isEmpty(contact)) {
			throw new BusinessException("Nenhum contato encontrado.");
		}

		return contact;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void excluir(Long id) throws BusinessException {
		try {
			contactRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BusinessException("Nenhum contato encontrado.");
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void verificaExistencia(Contact contact) throws BusinessException {
		buscar(contact.getId());
	}

}
