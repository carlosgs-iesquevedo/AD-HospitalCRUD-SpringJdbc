package es.iesquevedo.dao.repositories.springJdbc;

import es.iesquevedo.dao.common.SQLQueries;
import es.iesquevedo.dao.mappers.PacienteRowMapper;
import es.iesquevedo.dao.model.Paciente;
import es.iesquevedo.dao.repositories.PacienteRepository;
import es.iesquevedo.domain.error.PacienteDuplicadoError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Slf4j
@Repository
public class SpringJdbcPacienteRepository implements PacienteRepository {

    private final JdbcClient jdbcClient;
    private final PacienteRowMapper pacienteRowMapper;

    public SpringJdbcPacienteRepository(JdbcClient jdbcClient,
        PacienteRowMapper pacienteRowMapper) {
        this.jdbcClient = jdbcClient;
        this.pacienteRowMapper = pacienteRowMapper;
    }

    @Override
    public List<Paciente> findAll() {
        return jdbcClient.sql(SQLQueries.FIND_ALL_PACIENTES)
            .query(pacienteRowMapper) //mapea resultset a Paciente
            .list();
    }

    @Override
    @Transactional
    public Long add (Paciente paciente) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcClient.sql(SQLQueries.ADD_PACIENTE)
                .param(1, paciente.getNombre())
                .param(2, Date.valueOf(paciente.getFechaNacimiento()))
                .param(3, paciente.getTelefono())
                .update(keyHolder, "paciente_id");

            Long idPaciente = keyHolder.getKeyAs(Long.class);

            jdbcClient.sql(SQLQueries.ADD_USUARIO)
                .param(1, paciente.getUsuario().getUsername())
                .param(2, paciente.getUsuario().getPassword())
                .param(3, idPaciente)
                .update();

            return idPaciente;
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());
            throw new PacienteDuplicadoError();
        }

    }

}
