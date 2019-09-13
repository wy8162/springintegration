package com.wy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {
        "com.wy" // Scan the JPA Repository
})
@ImportResource(locations = {
        "classpath*:/configuration/integration-beans.xml"
})
public class ApplicationConfiguration {
}
