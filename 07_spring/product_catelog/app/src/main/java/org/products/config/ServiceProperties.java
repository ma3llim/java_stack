package org.products.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.service")
public class ServiceProperties {
    private String name;
    private String version;
}
