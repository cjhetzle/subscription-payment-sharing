package com.cjhetzle.hsb.entity.json;

import com.cjhetzle.hsb.entity.Product;
import com.cjhetzle.hsb.lib.ProductCategory;
import com.cjhetzle.hsb.lib.ProductType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private ProductType type;
    @JsonProperty
    private String description;
    @JsonProperty
    private ProductCategory category;
    @JsonProperty(value = "image_url")
    private String imageUrl;
    @JsonProperty(value = "home_url")
    private String homeUrl;

    public static ProductDto fromEntity(Product product) {

        return new ProductDto(product.getId(), product.getName(), product.getType(),
                product.getDescription(), product.getCategory(),
                product.getImageUrl(), product.getHomeUrl());
    }
}
