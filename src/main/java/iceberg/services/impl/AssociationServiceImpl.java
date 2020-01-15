package iceberg.services.impl;

import iceberg.models.Association;
import iceberg.models.President;
import iceberg.services.AssociationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationServiceImpl implements AssociationService {

    public List<Association> getAllAssociations() {
        President president = President.builder().name("Président").mail("president@test.fr").build();
        return List.of(Association.builder().name("association test").mail("association.test@gmail.test").president(president).build());
    }
}
