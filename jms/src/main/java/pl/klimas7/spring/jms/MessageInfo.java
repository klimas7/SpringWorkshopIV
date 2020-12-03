package pl.klimas7.spring.jms;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MessageInfo implements Serializable {
    private String message;
    private Integer count;
}
