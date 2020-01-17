package iceberg.dao;

import iceberg.models.Association;

import java.util.List;

public interface AssociationDao {

    /**
     * Get all associations
     *
     * @return Lsit of {@link Association}
     */
    List<Association> getAll();
}
