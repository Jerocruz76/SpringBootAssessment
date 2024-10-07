package com.riwi.SpringBootAssessment.domain.model.entities;

import com.riwi.SpringBootAssessment.domain.model.enums.StatusLoad;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loads")
public class LoadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusLoad status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carried_id", nullable = false, referencedColumnName = "id")
    private UserEntity carrier_id;
}
