package com.VitorsosterF.exercicioPraticoAPIREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.VitorsosterF.exercicioPraticoAPIREST.model.Moto;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
}