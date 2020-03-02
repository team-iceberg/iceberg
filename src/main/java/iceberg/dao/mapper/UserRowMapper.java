package iceberg.dao.mapper;

import iceberg.models.User;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper extends MapperUtils implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet resultSet, int i) {
    return User.builder()
        .id(safeGetInt(resultSet, "ID"))
        .mail(safeGetString(resultSet, "MAIL"))
        .isRoot(safeGetBoolean(resultSet, "IS_ROOT")).build();
  }
}
