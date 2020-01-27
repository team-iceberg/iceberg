package iceberg.dao.impl;

import iceberg.dao.ColorisDao;
import iceberg.dao.mapper.ColorisRowMapper;
import iceberg.exceptions.DaoException;
import iceberg.models.Coloris;
import iceberg.services.impl.JdbcDaoCommon;
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

@Repository("iceberg.colorisDao")
public class ColorisDaoImpl extends JdbcDaoCommon implements ColorisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorisDaoImpl.class);

    ResourcePropertySource resourcePropertySource;

    @Autowired
    protected ColorisDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
        super(jdbc);
        resourcePropertySource = new ResourcePropertySource("classpath:db/sql/coloris.properties");
    }

    @Override
    public List<Coloris> getAll() {
        try {
            String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.all")).toString();

            return jdbc.query(query, new HashMap<>(), new ColorisRowMapper());
        } catch (DataAccessException dae) {
            LOGGER.error("Error during recovery all ");
            throw new DaoException(dae);
        }
    }
}
