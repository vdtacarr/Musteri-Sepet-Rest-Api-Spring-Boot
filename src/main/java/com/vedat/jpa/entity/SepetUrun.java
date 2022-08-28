package com.vedat.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SepetUrun")
public class SepetUrun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int sepetId;
    private BigDecimal tutar;
    private String aciklama;

}
