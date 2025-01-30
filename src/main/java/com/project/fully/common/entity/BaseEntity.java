package com.project.fully.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Status status = Status.ACTIVE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updatedDate = LocalDateTime.now();

    public enum Status {
        ACTIVE("활성화"), INACTIVE("비활성화"), DELETE("삭제");

        private final String description;

        Status(String description) {
            this.description = description;
        }
    }

}
