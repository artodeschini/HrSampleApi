package org.todeschini.rh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.todeschini.rh.model.Empregado;
import org.todeschini.rh.service.IEmpregadoService;

import java.util.List;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpregadoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpregadoController.class);

    @Autowired
    private IEmpregadoService service;

    @GetMapping("/empregados")
    public List<Empregado> listarAll() {
        return service.listarEmpregados();
    }

    @PostMapping("/empregados")
    public Empregado saveEmpregado(@RequestBody Empregado e) {
        LOGGER.info(e.toString());
        return service.saveEmpregado(e);

    }
}
