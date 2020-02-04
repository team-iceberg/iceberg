package iceberg.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class définnissant un utilisateur de l'application.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private static final long serialVersionUID = 1;

    private Integer idAssociation;

    private boolean isAdmin;

    private boolean isMember;

    private boolean isVisitor;
}
