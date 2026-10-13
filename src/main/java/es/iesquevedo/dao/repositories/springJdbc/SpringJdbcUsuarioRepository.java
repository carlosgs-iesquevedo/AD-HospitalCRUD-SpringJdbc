package es.iesquevedo.dao.repositories.springJdbc;

import es.iesquevedo.dao.common.SQLQueries;
import es.iesquevedo.dao.model.Usuario;
import es.iesquevedo.dao.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class SpringJdbcUsuarioRepository implements UsuarioRepository {

  private final JdbcClient jdbcClient;

  public SpringJdbcUsuarioRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public Optional<Usuario> findByUsername(String username) {
    return jdbcClient.sql(SQLQueries.FIND_USUARIO_BY_USERNAME)
        .param(1, username)
        .query(Usuario.class)
        .optional();
  }
}


