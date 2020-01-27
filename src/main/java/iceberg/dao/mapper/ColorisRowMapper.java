package iceberg.dao.mapper;

import iceberg.models.Coloris;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class ColorisRowMapper  extends MapperUtils implements RowMapper<Coloris> {

    @Override
    public Coloris mapRow(ResultSet resultSet, int i) {
        return Coloris.builder().libelle(safeGetString(resultSet, "LIBELLE")).codeHexa(safeGetString(resultSet, "CODE_HEXA")).build();
    }
}
