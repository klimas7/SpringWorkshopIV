package pl.klimas7.spring.jms;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class MessageInfo implements Serializable {
    private String message;
    private Integer count;
}
