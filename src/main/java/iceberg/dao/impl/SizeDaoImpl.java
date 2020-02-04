package iceberg.dao.impl;

import iceberg.dao.SizeDao;
import iceberg.dao.mapper.SizeRowMapper;
import iceberg.exceptions.DaoException;
import iceberg.models.Size;
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

@Repository("iceberg.sizeDao")
public class SizeDaoImpl extends JdbcDaoCommon implements SizeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SizeDaoImpl.class);

    ResourcePropertySource resourcePropertySource;

    @Autowired
    protected SizeDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
        super(jdbc);
        resourcePropertySource = new ResourcePropertySource("classpath:db/sql/size.properties");
    }

    @Override
    public List<Size> getAll() {
        try {
            String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.all")).toString();

            return jdbc.query(query, new HashMap<>(), new SizeRowMapper());
        } catch (DataAccessException dae) {
            LOGGER.error("Error during recovery all sizes ");
            throw new DaoException(dae);
        }
    }
}