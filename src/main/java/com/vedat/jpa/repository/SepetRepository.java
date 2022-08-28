package com.vedat.jpa.repository;

import com.vedat.jpa.entity.Sepet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SepetRepository extends JpaRepository<Sepet, Integer> {
    @Query(value = "Select new com.vedat.jpa.dto.FindId(MAX(s.id)) FROM Sepet s")
    public int findSepetId();
}
