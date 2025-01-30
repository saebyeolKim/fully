package com.project.fully.store.entity;

import com.project.fully.common.entity.BaseEntity;
import com.project.fully.member.entity.FavoriteStore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "store")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("가게이름(**점)")
    @Column(nullable = false)
    private String name;

    @Comment("우편번호")
    @Column(nullable = false)
    private String zipcode;

    @Comment("주소")
    @Column(nullable = false)
    private String address1;

    @Comment("상세주소")
    @Column(nullable = false)
    private String address2;

    @Comment("가게 번호")
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreOperation> operations = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FavoriteStore> favoriteStores = new ArrayList<>();

    @Comment("비고")
    private String etc;

    public void addStoreOperation(StoreOperation storeOperation) {
        operations.add(storeOperation);
        storeOperation.setStore(this);
    }
}
