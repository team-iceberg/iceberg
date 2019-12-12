package iceberg.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Association {

    private String id;

    private String name;

    private String mail;

    private President president;
}
