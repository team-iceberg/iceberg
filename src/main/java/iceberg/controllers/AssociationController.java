package iceberg.controllers;

import iceberg.modele.Association;
import iceberg.services.impl.ImplementAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AssociationController {

    @Autowired
    private ImplementAssociationService implementAssociationService;

    @RequestMapping("/associations")
    public List<Association> getProducts() {
        return implementAssociationService.getAllAssociations();
    }
}
