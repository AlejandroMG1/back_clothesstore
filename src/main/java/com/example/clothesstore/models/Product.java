package com.example.clothesstore.models;

import com.example.clothesstore.validators.DiscountConstrain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscountConstrain
public class Product {
    @Id
    @GeneratedValue
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    Long id;
    @Column
    String Name;
    @Column
    Double price;

    @Min(0)
    @Column
    Double Discount;
    @Column
    String frontImg;
    @Column
    String backImage;
    @Column
    String country;
}
