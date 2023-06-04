package com.example.FlipCommerce.model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "card")
@Builder
public class Card {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    int id;

    @Column(name = "card_no", unique = true, nullable = false, columnDefinition = "varchar(255) default ' ' ")
    String cardNo;

    @Column(name = "cvv")
    int cvv;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    CardType cardType;

    @Column(name = "valid_till")
    Date validTill;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
