package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Timestamp;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpenseDto {
    private String externalId;
    @JsonProperty(value = "amount")
    private String amount;
    @JsonProperty(value = "user_id")
    private String userId;
    @JsonProperty(value = "merchant")
    private String merchant;
    @JsonProperty(value = "currency")
    private String currency;
    @JsonProperty(value = "created_at")
    private Timestamp createdAt;
}
