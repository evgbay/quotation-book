package ru.bay.quotation_book.core.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.bay.quotation_book.core.model.Constant;

@Configuration
@PropertySource("classpath:" + Constant.PROPERTIES)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
