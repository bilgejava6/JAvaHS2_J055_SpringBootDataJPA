package com.muhammet.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblcar")
public class Car {
    /**
     * Repository yazılacak,
     * -- model e göre sorgulama - eq, like
     * -- year e göre sorgulama, >, < =
     * -- yakıt türüne göre arama
     * -- aktif olan ve olmayan araçları listele
     * -- fiyatı belli bir değerin arasında olan araçlar
     * -- belli bir model e ait belli bir yakıt türü olan araçlar
     * -- model adında a harfi geçmeyen araçlar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;
    String make;
    Integer year;
    Integer dailyRate;
    Integer fuelType;
    Boolean isAvaliable;
    Integer km;
    Double price;

}
