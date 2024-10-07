package com.riwi.SpringBootAssessment.domain.model.entities;

import com.riwi.SpringBootAssessment.domain.model.enums.Material;
import com.riwi.SpringBootAssessment.domain.model.enums.StatusPallet;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pallets")
public class PalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight_capacity", nullable = false)
    private Float weightCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "material", nullable = false)
    private Material material;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPallet status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "load_id",nullable = false,referencedColumnName = "id")
    private LoadEntity loadId;
}
