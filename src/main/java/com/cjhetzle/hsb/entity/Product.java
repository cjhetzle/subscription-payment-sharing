package com.cjhetzle.hsb.entity;

import com.cjhetzle.hsb.entity.json.ProductDto;
import com.cjhetzle.hsb.lib.ProductCategory;
import com.cjhetzle.hsb.lib.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private ProductType type;

    @Column
    private String description;

    @NonNull
    @Column
    private ProductCategory category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "home_url")
    private String homeUrl;

    public static Product fromDto(ProductDto dto) {
        return new Product(dto.getId(), dto.getName(), dto.getType(),
                dto.getDescription(), dto.getCategory(), dto.getImageUrl(),
                dto.getHomeUrl());
    }
}