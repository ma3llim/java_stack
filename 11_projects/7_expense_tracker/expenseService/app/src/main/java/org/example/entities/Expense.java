package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Expense {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "external_id")
    private String externalId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "merchant")
    private String merchant;
    @Column(name = "currency")
    private String currency;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @PrePersist
    @PreUpdate
    private void generateExternalId() {
        if (this.externalId == null) {
            this.externalId = UUID.randomUUID().toString();
        }
        if (this.createdAt == null) {
            this.createdAt = new Timestamp(Instant.now().toEpochMilli());
        }
    }
}
