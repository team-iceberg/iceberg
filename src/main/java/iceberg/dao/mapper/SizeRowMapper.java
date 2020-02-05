package iceberg.dao.mapper;

import iceberg.models.Size;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class SizeRowMapper extends MapperUtils implements RowMapper<Size> {

    @Override
    public Size mapRow(ResultSet resultSet, int i) {
        return Size.builder().id(safeGetString(resultSet, "ID")).libelle(safeGetString(resultSet, "LIBELLE")).build();
    }
}
