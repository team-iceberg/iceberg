package iceberg.dao.mapper;

import iceberg.models.Family;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class FamilyRowMapper extends MapperUtils implements RowMapper<Family> {

    @Override
    public Family mapRow(ResultSet resultSet, int i) {
        return Family.builder().id(safeGetString(resultSet, "ID")).libelle(safeGetString(resultSet, "LIBELLE")).build();
    }
}
