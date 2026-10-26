package es.iesquevedo.ui;

import es.iesquevedo.domain.dto.PacienteDTO;
import es.iesquevedo.domain.services.PacienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class RestPaciente {
  private final PacienteService pacienteService;

  public RestPaciente(PacienteService pacienteService) {
    this.pacienteService = pacienteService;
  }

  @GetMapping("/pacientes")
  public List<PacienteDTO> getAll() {
    return pacienteService.getAll();
  }
}
