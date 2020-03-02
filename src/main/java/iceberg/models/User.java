package iceberg.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

/**
 * Class définnissant un utilisateur de l'application.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private static final long serialVersionUID = 1;

    private int id;

    private String mail;

    private boolean isRoot;

    private List<Role> roles;
}
