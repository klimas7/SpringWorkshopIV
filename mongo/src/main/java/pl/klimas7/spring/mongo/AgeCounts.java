package pl.klimas7.spring.mongo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgeCounts {
    private Integer age;
    private Integer count;
}
