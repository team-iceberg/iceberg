package iceberg.controllers;

import iceberg.models.Association;
import iceberg.models.User;
import iceberg.services.UserService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

  private UserService userService;

  /**
   * Instantiates a new AuthenticationController.
   *
   * @param userService the user service
   */
  @Autowired
  public AuthenticationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity authenticateUser(@RequestBody String idToken){
    LOGGER.info("Authentication");
    try {
      User user = userService.controlToken(idToken);
      return ResponseEntity.status(HttpStatus.OK).body(user);
    } catch (GeneralSecurityException | IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
    }
  }
}
