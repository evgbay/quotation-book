package ru.bay.quotation_book.ui.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import ru.bay.quotation_book.core.Constant;
import ru.bay.quotation_book.ui.UIOutput;

public class ConsoleCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var environment = context.getEnvironment();
        String output = environment.getProperty(Constant.OUTPUT_PROPERTY);
        return UIOutput.CONSOLE.name().toLowerCase().equals(output);
    }
}
