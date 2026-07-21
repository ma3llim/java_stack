package org.products.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.pagination")
public class PaginationProperties {
    private int maxSize;
    private int defaultSize;
}
