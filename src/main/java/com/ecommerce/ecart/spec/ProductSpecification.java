package com.ecommerce.ecart.spec;

import org.springframework.data.jpa.domain.Specification;

import com.ecommerce.ecart.entity.Product;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {

        return (root, query, cb) -> {
            if (category == null || category.isBlank()) {
                return null;
            }
            return cb.equal(root.get("category"), category);
        };
    }

    public static Specification<Product> priceBetween(Double min, Double max) {

        return (root, query, cb) -> {

            if (min == null && max == null) {
                return null;
            }

            if (min == null) {
                return cb.lessThanOrEqualTo(root.get("price"), max);
            }

            if (max == null) {
                return cb.greaterThanOrEqualTo(root.get("price"), min);
            }

            return cb.between(root.get("price"), min, max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyword) {

        return (root, query, cb) -> {

            if (keyword == null || keyword.isBlank()) {
                return null;
            }

            String search = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("name")), search),
                    cb.like(cb.lower(root.get("description")), search)
            );
        };
    }

    public static Specification<Product> ratingGreaterThan(Double ratings) {

        return (root, query, cb) -> {

            if (ratings == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("ratings"), ratings);
        };
    }
}