package iceberg.controllers;

import iceberg.models.Association;
import iceberg.services.AssociationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/associations")
public class AssociationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociationController.class);

    private AssociationService associationService;

    /**
     * Instantiates a new AssociationController.
     *
     * @param associationService the association service
     */
    @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @GetMapping
    public List<Association> getProducts() {
        LOGGER.info("Get all associations");
        return associationService.getAllAssociations();
    }
}
