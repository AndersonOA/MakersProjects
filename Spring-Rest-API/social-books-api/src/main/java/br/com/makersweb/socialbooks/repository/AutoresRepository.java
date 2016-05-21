package br.com.makersweb.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
