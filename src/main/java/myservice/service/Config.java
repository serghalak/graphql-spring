package myservice.service;

import graphql.schema.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class Config {

    TypeResolver petTypeResolver = env -> {
        Object object = env.getObject();
        if (object instanceof Dog) {
            return env.getSchema().getObjectType("Dog");
        } else if (object instanceof Cat) {
            return env.getSchema().getObjectType("Cat");
        } else {
            return env.getSchema().getObjectType("Pet");
        }
    };

    // TypeResolver for IPet
    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .type("Pet", typeWiring -> typeWiring
                        .typeResolver(petTypeResolver))
                .type("IPet", typeWiring -> typeWiring
                        .typeResolver(petTypeResolver));
    }
}
