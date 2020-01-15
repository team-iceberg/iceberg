package iceberg.dao.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

class MapperUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperUtils.class);

    private static final String FIELD_FETCHING_ERROR_MESSAGE = "Echec de la récupération du champ ";

    protected String safeGetString(ResultSet resultSet, String field) {
        try {
            String string = resultSet.getString(field);
            if (string != null) {
                return string.trim();
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return "";
        }
    }

    protected Integer safeGetInt(ResultSet resultSet, String field) {
        try {
            if (resultSet.getString(field) != null) {
                return resultSet.getInt(field);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return null;
        }
    }

    protected Long safeGetLong(ResultSet resultSet, String field) {
        try {
            if (resultSet.getString(field) != null) {
                return resultSet.getLong(field);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return null;
        }
    }

    protected Timestamp safeGetDate(ResultSet resultSet, String field) {
        try {
            return resultSet.getTimestamp(field);
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return null;
        }
    }

    protected Float safeGetFloat(ResultSet resultSet, String field) {
        try {
            if (resultSet.getString(field) != null) {
                return resultSet.getFloat(field);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return null;
        }
    }

    protected Double safeGetDouble(ResultSet resultSet, String field) {
        try {
            if (resultSet.getString(field) != null) {
                return resultSet.getDouble(field);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return null;
        }
    }

    protected boolean safeGetBoolean(ResultSet resultSet, String field) {
        try {
            if (resultSet.getString(field) != null) {
                return resultSet.getBoolean(field);
            }
            return false;
        } catch (SQLException e) {
            LOGGER.warn(FIELD_FETCHING_ERROR_MESSAGE + field, e);
            return false;
        }
    }
}

