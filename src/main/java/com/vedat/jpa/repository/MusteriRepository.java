package com.vedat.jpa.repository;

import com.vedat.jpa.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Integer> {
    @Query(value = "Select new com.vedat.jpa.dto.FindId(MAX(m.id)) FROM Musteri m")
    public int findMusteriId();
}
