package iceberg.services.impl;

import iceberg.dao.ColorDao;
import iceberg.models.Color;
import iceberg.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iceberg.colorService")
public class ColorServiceImpl implements ColorService {

    @Autowired
    @Qualifier("iceberg.colorDao")
    private ColorDao colorDao;

    public List<Color> getAllColors()  {
        return colorDao.getAll();
    }
}
