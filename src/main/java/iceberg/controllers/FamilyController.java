package iceberg.controllers;

import iceberg.models.Family;
import iceberg.services.FamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/families")
public class FamilyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SizeController.class);

    private FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public List<Family> getFamilies() {
        LOGGER.info("Get all families");
        return familyService.getAllFamilies();
    }
}
