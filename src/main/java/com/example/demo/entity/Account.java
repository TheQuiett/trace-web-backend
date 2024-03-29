package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GeneratedColumn;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity()
@Table()
@Data()
/**
 *@Where(clause = "deleted_at = null")
 * 문구를 넣으면 해당 테이블을 통해서 기본적으로
 * clause의 조건을 포함하도록 한다.
 */
@Where(clause = "deleted_at is null")
public class Account {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy="uuid2")
    private UUID id;

//    private String key;

    @Column(unique = true)
    private String userId;

    @Column()
    private String userName;

    @Column()
    private String userPassword;

    @Column()
    private String userAddress;

    @Column(columnDefinition = "timestamptz")
    private OffsetDateTime deletedAt;

    @Column(columnDefinition = "timestamptz")
    private OffsetDateTime lastLoginDate;

    @OneToMany(mappedBy = "account")
    private List<Item> itemList;


}
