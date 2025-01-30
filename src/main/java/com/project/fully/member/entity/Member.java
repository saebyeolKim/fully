package com.project.fully.member.entity;

import com.project.fully.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티를 마음대로 생성하지 못하게 막고, JPA가 내부적으로 사용할 수 있도록 최소한의 접근 권한을 주는 것
@Entity
@Table(name = "member")
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("이름")
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = "^01[016789]-?\\d{3,4}-?\\d{4}$", message = "올바른 휴대폰 번호를 입력하세요.")
    private String phone;

    @Comment("프로필 이미지")
    private String profileImg;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> points = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Basket> baskets = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FavoriteStore> stores = new ArrayList<>();

    //양방향 연관관계 설정
    public void addAddress(Address address) {
        addresses.add(address);
        address.setMember(this);
    }

    public void addPoint(Point point) {
        points.add(point);
        point.setMember(this);
    }

    public void addBasket(Basket basket) {
        baskets.add(basket);
        basket.setMember(this);
    }

    public void addFavoriteStore(FavoriteStore store) {
        stores.add(store);
        store.setMember(this);
    }
}
