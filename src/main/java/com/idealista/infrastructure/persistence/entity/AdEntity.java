package com.idealista.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AD")
public class AdEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String typology;
    private String description;
    @OneToMany(targetEntity = PictureEntity.class)
    private List<PictureEntity> pictures;
    private Integer houseSize;
    private Integer gardenSize;
    @NotNull
    private Integer score;
    private Date irrelevantSince;
}
