package iceberg.dao.mapper;

import iceberg.models.Association;
import iceberg.models.President;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class AssociationRowMapper extends MapperUtils implements RowMapper<Association> {

    @Override
    public Association mapRow(ResultSet resultSet, int i) {
        President president = President.builder().build();
        return Association.builder()
            .name(safeGetString(resultSet, "NAME"))
            .mail(safeGetString(resultSet, "MAIL"))
            .president(president).build();
    }
}
