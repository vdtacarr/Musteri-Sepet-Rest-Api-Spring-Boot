package com.vedat.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ad;
    private String soyad;
    private String sehir;

}
