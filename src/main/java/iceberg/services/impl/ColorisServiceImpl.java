package iceberg.services.impl;

import iceberg.dao.ColorisDao;
import iceberg.models.Coloris;
import iceberg.services.ColorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iceberg.colorisService")
public class ColorisServiceImpl implements ColorisService {

    @Autowired
    @Qualifier("iceberg.colorisDao")
    private ColorisDao colorisDao;

    public List<Coloris> getAllColoris()  {
        return colorisDao.getAll();
    }
}
