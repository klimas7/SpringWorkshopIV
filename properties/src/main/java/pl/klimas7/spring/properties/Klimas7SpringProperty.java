package pl.klimas7.spring.properties;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.Delimiter;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Setter
@ConfigurationProperties(prefix = "klimas7.spring")
public class Klimas7SpringProperty {
    private String p1;
    private String p2;
    private List<String> p3;
    @Delimiter("@")
    private List<String> p3a;

    private String p4;
    private String p4a;

    private Integer p5;

    private String[] p6;

    private String p6b;

    @Autowired
    private PropertyGenerator propertyGenerator;

    @Autowired
    private TestProperty testProperty;

    public Map<String, String> getP6() {
        return propertyGenerator.generate(p6);
    }

    public Map getP6b() {
        StandardEvaluationContext testContext = new StandardEvaluationContext(testProperty);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(p6b);
        return exp.getValue(testContext, Map.class);
    }

    public void printProperties() {
        Arrays.stream(this.getClass().getDeclaredFields())
                .forEach(this::printFieldValue);
        log.info("p6: " + getP6());
        log.info("p6b: " + getP6b());
    }

    @SneakyThrows
    private void printFieldValue(Field field) {
        log.info(field.getName() + ": " + field.get(this));
    }
}
