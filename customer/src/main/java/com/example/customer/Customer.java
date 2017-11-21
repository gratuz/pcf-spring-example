package com.example.customer;


import lombok.*;

import javax.persistence.*;

@Table(name = "customer_data")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter private Long id;


    @Column(length = 48)
    @Getter @Setter private String name;

    @Column(length = 48)
    @Getter @Setter private String email;



}




