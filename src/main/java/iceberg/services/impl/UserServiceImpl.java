package iceberg.services.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import iceberg.services.UserService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.springframework.stereotype.Service;

@Service("iceberg.userService")
public class UserServiceImpl implements UserService {

  @Override
  public void controlToken(String idToken) throws GeneralSecurityException, IOException {
    HttpTransport httpTransport = new NetHttpTransport();
    JacksonFactory jacksonFactory = new JacksonFactory();

    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jacksonFactory)
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
      boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
      String name = (String) payload.get("name");
      String pictureUrl = (String) payload.get("picture");
      String locale = (String) payload.get("locale");
      String familyName = (String) payload.get("family_name");
      String givenName = (String) payload.get("given_name");

      System.out.println(payload.toPrettyString());

      // Use or store profile information
      // ...

    } else {
      System.out.println("Invalid ID token.");
    }
  }
}
