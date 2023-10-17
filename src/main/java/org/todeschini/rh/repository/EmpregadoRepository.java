package org.todeschini.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todeschini.rh.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {
}
