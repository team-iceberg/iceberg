package iceberg.services;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface UserService {

  void controlToken(String idToken) throws GeneralSecurityException, IOException;
}
