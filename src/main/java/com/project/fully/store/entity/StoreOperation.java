package com.project.fully.store.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "store_operation")
public class StoreOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Comment("월 ~ 일")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @Comment("운영시작시간")
    private LocalTime openTime;

    @Comment("운영종료시간")
    private LocalTime closeTime;

    @Comment("휴일여부")
    @Column(nullable = false)
    private Boolean isHoliday;

    public void setStore(Store store) {
        this.store = store;
    }

}
