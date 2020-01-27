package iceberg.controllers;

import iceberg.models.Coloris;
import iceberg.services.ColorisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coloris")
public class ColorisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorisController.class);

    private ColorisService colorisService;

    @Autowired
    public ColorisController(ColorisService colorisService) {
        this.colorisService = colorisService;
    }

    @GetMapping
    public List<Coloris> getColoris() {
        LOGGER.info("Get all coloris");
        return colorisService.getAllColoris();
    }
}
