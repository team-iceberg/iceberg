package iceberg.controllers;

import iceberg.models.Size;
import iceberg.services.SizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sizes")
public class SizeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SizeController.class);

    private SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public List<Size> getSizes() {
        LOGGER.info("Get all sizes");
        return sizeService.getAllSizes();
    }
}
