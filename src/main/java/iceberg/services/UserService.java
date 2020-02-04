package iceberg.services;

import iceberg.models.User;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface UserService {

  User controlToken(String idToken) throws GeneralSecurityException, IOException;
}
