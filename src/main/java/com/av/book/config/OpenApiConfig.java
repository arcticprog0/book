package com.av.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Coffee machine System Api",
                description = "Coffee machine", version = "1.0.0",
                contact = @Contact(
                        name = "Andrei K",
                        email = "av7001@mail.ru",
                        url = "https://github.com/arcticprog0"
                )
        )
)
public class OpenApiConfig {

}
