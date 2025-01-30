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
@Table(name = "member_address")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Comment("우편번호")
    @Column(nullable = false)
    private String zipcode;

    @Comment("주소")
    @Column(nullable = false)
    private String address1;

    @Comment("상세주소")
    @Column(nullable = false)
    private String address2;

    public void setMember(Member member) {
        this.member = member;
    }


}
