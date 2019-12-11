package iceberg.services.impl;

import iceberg.modele.Association;
import iceberg.services.InterfaceAssociationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementAssociationService implements InterfaceAssociationService {

    public List<Association> getAllAssociations() {
        return List.of(
                new Association("1","Les sympathiques","Mlle Delbecque")
        );
    }
}
