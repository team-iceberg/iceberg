package iceberg.dao.impl;

import iceberg.dao.UserDao;
import iceberg.dao.mapper.RoleRowMapper;
import iceberg.dao.mapper.UserRowMapper;
import iceberg.exceptions.DaoException;
import iceberg.models.Role;
import iceberg.models.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("iceberg.userDao")
public class UserDaoImpl extends JdbcDaoCommon implements UserDao {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

  ResourcePropertySource resourcePropertySource;

  @Autowired
  protected UserDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
    super(jdbc);
    resourcePropertySource = new ResourcePropertySource("classpath:db/sql/user.properties");
  }

  @Override
  public User getByMail(String mail) {
    try {
      String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.by.mail"))
          .toString();

      Map<String, Object> params = new HashMap<>();
      params.put("MAIL", mail);

      return jdbc.queryForObject(query, params, new UserRowMapper());
    } catch (DataAccessException dae) {
      LOGGER.error("Error during get informations of user with mail : %s", mail);
      throw new DaoException(dae);
    }
  }

  @Override
  public List<Role> getRolesByUser(int id) {
    try {
      String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.roles.by.user"))
          .toString();

      Map<String, Object> params = new HashMap<>();
      params.put("ID_USER", id);

      return jdbc.query(query, params, new RoleRowMapper());
    } catch (DataAccessException dae) {
      LOGGER.error("Error during get informations of user %s", id);
      throw new DaoException(dae);
    }
  }
}
