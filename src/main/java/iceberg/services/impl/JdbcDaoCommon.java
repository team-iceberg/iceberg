package iceberg.services.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Abstract class extended by all Jdbc DAO classes
 */
public abstract class JdbcDaoCommon {

    protected final NamedParameterJdbcTemplate jdbc;

    protected JdbcDaoCommon(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

}
