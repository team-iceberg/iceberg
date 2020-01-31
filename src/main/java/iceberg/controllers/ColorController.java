package iceberg.controllers;

import iceberg.models.Color;
import iceberg.services.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorController.class);

    private ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> getColors() {
        LOGGER.info("Get all colors");
        return colorService.getAllColors();
    }
}
