package com.example.demo2.Repository;

import com.example.demo2.Model.Nomos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomosRepository extends JpaRepository<Nomos,Long> {
}
