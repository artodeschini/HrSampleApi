package org.todeschini.rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todeschini.rh.model.Empregado;
import org.todeschini.rh.repository.EmpregadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService implements IEmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    @Override
    public List<Empregado> listarEmpregados() {
        return repository.findAll();
    }

    @Override
    public Optional<Empregado> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Empregado saveEmpregado(Empregado e) {
        return repository.save(e);
    }

    @Override
    public void deleteEmpregado(Empregado e) {
        repository.delete(e);
    }
}
