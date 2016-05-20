package br.com.makersweb.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
