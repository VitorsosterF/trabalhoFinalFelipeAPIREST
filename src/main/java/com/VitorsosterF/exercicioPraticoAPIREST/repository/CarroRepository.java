package com.VitorsosterF.exercicioPraticoAPIREST.repository;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}