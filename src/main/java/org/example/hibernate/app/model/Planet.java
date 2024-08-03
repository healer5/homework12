package org.example.hibernate.app.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "planet")
public class Planet {
        @Id
        @Pattern(regexp = "[A-Z0-9]+")
        @Column(name = "id", length = 10, nullable = false)
        private String id;

        @Column(name = "name", length = 500, nullable = false)
        private String name;
}
