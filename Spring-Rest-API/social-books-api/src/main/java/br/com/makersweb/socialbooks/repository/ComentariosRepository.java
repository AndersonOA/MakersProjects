package br.com.makersweb.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.socialbooks.domain.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

}
