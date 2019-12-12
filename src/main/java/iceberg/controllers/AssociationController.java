package iceberg.controllers;

import iceberg.models.Association;
import iceberg.services.impl.AssociationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/associations")
public class AssociationController {

    @Autowired
    private AssociationServiceImpl associationServiceImpl;

    @GetMapping
    public List<Association> getProducts() {
        return associationServiceImpl.getAllAssociations();
    }
}
