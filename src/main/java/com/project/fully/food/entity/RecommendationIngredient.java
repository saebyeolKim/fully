package com.project.fully.food.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table
public class RecommendationIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendation_id")  // Recommendation FK
    private Recommendation recommendation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")  // Ingredient FK
    private Ingredient ingredient;

    public RecommendationIngredient(Recommendation recommendation, Ingredient ingredient) {
        this.recommendation = recommendation;
        this.ingredient = ingredient;
    }
}
