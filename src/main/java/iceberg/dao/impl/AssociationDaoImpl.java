package iceberg.dao.impl;

import iceberg.dao.AssociationDao;
import iceberg.models.Association;
import iceberg.services.impl.JdbcDaoCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("iceberg.associationDao")
public class AssociationDaoImpl extends JdbcDaoCommon implements AssociationDao {

    ResourcePropertySource resourcePropertySource;

    @Autowired
    protected AssociationDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
        super(jdbc);
        resourcePropertySource = new ResourcePropertySource("classpath:db/sql/association.properties");
    }

    @Override
    public List<Association> getAll() {
        return null;
    }
}
