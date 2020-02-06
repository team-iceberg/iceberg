package iceberg.services.impl;

import iceberg.dao.FamilyDao;
import iceberg.models.Family;
import iceberg.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iceberg.familyService")
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    @Qualifier("iceberg.familyDao")
    private FamilyDao familyDao;

    public List<Family> getAllFamilies() {
        return familyDao.getAll();
    }
}
