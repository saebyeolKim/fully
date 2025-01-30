package com.project.fully.member.entity;

import com.project.fully.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "point")
public class Point extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Comment("적립/차감")
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, updatable = false)
    private Category category;

    @Comment("적립/차감 포인트")
    @Column(name = "point", nullable = false, updatable = false)
    private int point;

    private enum Category {
        PLUS("적립"), MINUS("차감");

        private final String description;

        Category(String description) {
            this.description = description;
        }
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
