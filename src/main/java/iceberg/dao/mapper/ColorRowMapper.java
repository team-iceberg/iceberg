package iceberg.dao.mapper;

import iceberg.models.Color;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class ColorRowMapper extends MapperUtils implements RowMapper<Color> {

    @Override
    public Color mapRow(ResultSet resultSet, int i) {
        return Color.builder()
            .id(safeGetString(resultSet, "ID"))
            .libelle(safeGetString(resultSet, "LIBELLE"))
            .codeHexa(safeGetString(resultSet, "CODE_HEXA")).build();
    }
}
