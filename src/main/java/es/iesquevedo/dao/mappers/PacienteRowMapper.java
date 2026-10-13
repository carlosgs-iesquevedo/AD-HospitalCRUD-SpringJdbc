package es.iesquevedo.dao.mappers;

import es.iesquevedo.dao.model.Paciente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PacienteRowMapper  implements RowMapper<Paciente> {

    @Override
    public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Paciente.builder()
                .id(rs.getLong("paciente_id"))
                .nombre(rs.getString("nombre"))
                .fechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate())
                .telefono(rs.getString("telefono"))
                .build();
    }
}

