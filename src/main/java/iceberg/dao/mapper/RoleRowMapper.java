package iceberg.dao.mapper;

import iceberg.models.Role;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class RoleRowMapper extends MapperUtils implements RowMapper<Role> {

  @Override
  public Role mapRow(ResultSet resultSet, int i) {
    return Role.builder()
        .idAssociation(safeGetInt(resultSet, "ID_ASSOCIATION"))
        .isAdmin(safeGetBoolean(resultSet, "IS_ADMIN"))
        .isMember(safeGetBoolean(resultSet, "IS_MEMBER"))
        .isVisitor(safeGetBoolean(resultSet, "IS_VISITOR"))
        .build();
  }
}
