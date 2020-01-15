package iceberg.services.impl;

import iceberg.dao.AssociationDao;
import iceberg.models.Association;
import iceberg.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iceberg.associationService")
public class AssociationServiceImpl implements AssociationService {

    @Autowired
    @Qualifier("iceberg.associationDao")
    private AssociationDao associationDao;

    public List<Association> getAllAssociations() {
        return associationDao.getAll();
    }
}
