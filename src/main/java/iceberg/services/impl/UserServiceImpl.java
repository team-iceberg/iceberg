package iceberg.services.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import iceberg.dao.UserDao;
import iceberg.exceptions.ForbiddenException;
import iceberg.exceptions.ServiceException;
import iceberg.models.User;
import iceberg.services.UserService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("iceberg.userService")
public class UserServiceImpl implements UserService {

  @Autowired
  @Qualifier("iceberg.userDao")
  private UserDao userDao;

  @Override
  public User controlToken(String idToken) throws GeneralSecurityException, IOException {
    HttpTransport httpTransport = new NetHttpTransport();
    JacksonFactory jacksonFactory = new JacksonFactory();

    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport,
        jacksonFactory)
        .setAudience(Collections.singletonList(
            "854308350863-p7d0q7l8s2shvgmrakngoav58926h56m.apps.googleusercontent.com"))
        .build();

    GoogleIdToken googleIdToken = verifier.verify(idToken);
    if (googleIdToken != null) {
      Payload payload = googleIdToken.getPayload();

      // Print user identifier
      String userId = payload.getSubject();
      System.out.println("User ID: " + userId);

      // Get profile information from payload
      String email = payload.getEmail();

      User user = userDao.getByMail(email);

      if(user != null){
        user.setRoles(userDao.getRolesByUser(user.getId()));
        return user;
      } else {
        throw new ForbiddenException("User " + email + " is unauthorize");
      }
    } else {
      throw new ServiceException("Invalid ID token.");
    }
  }
}
