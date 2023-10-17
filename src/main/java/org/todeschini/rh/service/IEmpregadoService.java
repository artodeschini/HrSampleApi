package org.todeschini.rh.service;

import org.todeschini.rh.model.Empregado;

import java.util.List;
import java.util.Optional;

public interface IEmpregadoService {

    public List<Empregado> listarEmpregados();

    public Optional<Empregado> findById(Integer id);

    public Empregado saveEmpregado(Empregado e);

    public void deleteEmpregado(Empregado e);
}
