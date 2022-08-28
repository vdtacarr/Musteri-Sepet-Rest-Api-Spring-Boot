package com.vedat.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Sepet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int musteriId;

}
