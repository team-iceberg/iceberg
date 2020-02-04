package iceberg.services.impl;

import iceberg.dao.SizeDao;
import iceberg.models.Size;
import iceberg.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iceberg.sizeService")
public class SizeServiceImpl implements SizeService {

    @Autowired
    @Qualifier("iceberg.sizeDao")
    private SizeDao sizeDao;

    public List<Size> getAllSizes() {
        return sizeDao.getAll();
    }
}
