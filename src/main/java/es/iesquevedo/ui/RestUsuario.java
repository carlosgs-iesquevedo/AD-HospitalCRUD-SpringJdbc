package es.iesquevedo.ui;

import es.iesquevedo.domain.dto.UsuarioDTO;
import es.iesquevedo.domain.services.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUsuario {

    private final UsuarioService usuarioService;

    public RestUsuario(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    public boolean login(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.login(usuarioDTO);
    }
}