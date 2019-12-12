package iceberg.services.impl;

import iceberg.models.Association;
import iceberg.services.AssociationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationServiceImpl implements AssociationService {

    public List<Association> getAllAssociations() {
        return List.of(
                Association.builder().mail("association.test@gmail.test").name("association test").build()
        );
    }
}
