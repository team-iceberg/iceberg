package iceberg.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Color {

    private String id;

    private String libelle;

    private String codeHexa;
}
