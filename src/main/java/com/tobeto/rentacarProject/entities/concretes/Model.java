package com.tobeto.rentacarProject.entities.concretes;

import com.tobeto.rentacarProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "fuelId")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


}
