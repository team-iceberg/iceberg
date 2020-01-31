package iceberg.dao.impl;

import iceberg.dao.ColorDao;
import iceberg.dao.mapper.ColorRowMapper;
import iceberg.exceptions.DaoException;
import iceberg.models.Color;
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

@Repository("iceberg.colorDao")
public class ColorDaoImpl extends JdbcDaoCommon implements ColorDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorDaoImpl.class);

    ResourcePropertySource resourcePropertySource;

    @Autowired
    protected ColorDaoImpl(NamedParameterJdbcTemplate jdbc) throws IOException {
        super(jdbc);
        resourcePropertySource = new ResourcePropertySource("classpath:db/sql/color.properties");
    }

    @Override
    public List<Color> getAll() {
        try {
            String query = Objects.requireNonNull(resourcePropertySource.getProperty("get.all")).toString();

            return jdbc.query(query, new HashMap<>(), new ColorRowMapper());
        } catch (DataAccessException dae) {
            LOGGER.error("Error during recovery all colors ");
            throw new DaoException(dae);
        }
    }
}
