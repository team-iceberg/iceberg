package iceberg.dao.impl;

import iceberg.dao.AssociationDao;
import iceberg.dao.mapper.AssociationRowMapper;
import iceberg.exceptions.DaoException;
import iceberg.models.Association;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository("iceberg.associationDao")
public class AssociationDaoImpl extends JdbcDaoCommon implements AssociationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociationDaoImpl.class);

    ResourcePropertySource resourcePropertySource;

    @Autowired
    protected AssociationDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
        super(jdbc);
        resourcePropertySource = new ResourcePropertySource("classpath:db/sql/association.properties");
    }

    @Override
    public List<Association> getAll() {
        try {
            String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.all")).toString();

            return jdbc.query(query, new HashMap<>(), new AssociationRowMapper());
        } catch (DataAccessException dae) {
            LOGGER.error("Error during recovery all ");
            throw new DaoException(dae);
        }
    }
}
