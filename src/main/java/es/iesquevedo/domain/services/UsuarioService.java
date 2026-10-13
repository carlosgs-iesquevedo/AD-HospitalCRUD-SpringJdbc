package es.iesquevedo.domain.services;

import es.iesquevedo.dao.repositories.UsuarioRepository;
import es.iesquevedo.domain.dto.UsuarioDTO;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public boolean login(UsuarioDTO usuario) {

    return usuarioRepository.findByUsername(usuario.getUsername())
        .map(u -> u.getUsername().equals(usuario.getUsername())
            && u.getPassword().equals(usuario.getPassword()))
        .orElse(false);
  }

}
