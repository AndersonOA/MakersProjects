/**
 * 
 */
package br.com.makersweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.domain.Contact;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
