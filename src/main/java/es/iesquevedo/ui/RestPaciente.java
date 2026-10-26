package es.iesquevedo.ui;

import es.iesquevedo.domain.dto.PacienteDTO;
import es.iesquevedo.domain.dto.PacienteDTOAlta;
import es.iesquevedo.domain.services.PacienteService;
import org.springframework.web.bind.annotation.*;

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


  @PostMapping("/pacientes")
  public Long nuevoPaciente(PacienteDTOAlta pacienteDTO) {
    return pacienteService.add(pacienteDTO);
  }

  @PutMapping("/pacientes/{id}")
  public PacienteDTO actualizarPaciente(@PathVariable Long id,
                                        @RequestBody PacienteDTO pacienteDTO) {
    pacienteDTO.setId(id);
    //return pacienteService.update(pacienteDTO);
    return null; // Implementar la lógica de actualización
  }

  @DeleteMapping("/pacientes/{id}")
  public void eliminarPaciente(@PathVariable Long id) {
    //pacienteService.delete(id);
    // Implementar la lógica de borrado
  }
}
