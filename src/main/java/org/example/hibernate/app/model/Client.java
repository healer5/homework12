package org.example.hibernate.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "client")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
        @SequenceGenerator(name = "client_seq", sequenceName = "seq_client_id")
        private long id;

        @Column(name = "name", length = 200, nullable = false)
        private String name;

        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Ticket> tickets;
}
