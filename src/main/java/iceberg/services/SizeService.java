package iceberg.services;

import iceberg.models.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface SizeService {

    List<Size> getAllSizes();
}
