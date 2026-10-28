package com.agendaJac.usuario.infrastructure.repository;

import com.agendaJac.usuario.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    boolean existByEmail(String email);

    Optimal<Usuario> findByEmail(String email);
}
