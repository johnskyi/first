import lombok.Builder;
import lombok.Data;

import java.util.Objects;


@Data
@Builder
public class Line {
    String number;
    String name;
}
