package org.todeschini.rh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todeschini.rh.exception.ResourceNotFoundException;
import org.todeschini.rh.model.Empregado;
import org.todeschini.rh.service.IEmpregadoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpregadoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpregadoController.class);

    @Autowired
    private IEmpregadoService service;

    @GetMapping("/empregados")
    public ResponseEntity<List<Empregado>> listarAll() {
        return ResponseEntity.ok(service.listarEmpregados());
    }

    @PostMapping("/empregados")
    public ResponseEntity<Empregado> saveEmpregado(@RequestBody Empregado e) {
        LOGGER.info(e.toString());
        return new ResponseEntity<Empregado>(service.saveEmpregado(e), HttpStatus.CREATED);
    }

    @GetMapping("/empregados/{id}")
    public ResponseEntity<Empregado> getEmpregadoById(@PathVariable Integer id) {
        Empregado empregado = service.findById(id).orElse(null);
        if ( empregado == null ) {
            throw new ResourceNotFoundException("Nao foi possivel encontrar empregado com o id " + id);
        }
        return ResponseEntity.ok(empregado);
    }

    @DeleteMapping("/empregados/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Integer id) {
        Empregado empregado = service.findById(id).orElse(null);
        if ( empregado == null ) {
            throw new ResourceNotFoundException("Nao foi possivel encontrar empregado com o id " + id);
        }

        service.deleteEmpregado(empregado);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/empregados/{id}")
    public ResponseEntity<Empregado> editar(@PathVariable Integer id, @RequestBody Empregado e) {
        Empregado empregado = service.findById(id).orElse(null);
        if ( empregado == null ) {
            throw new ResourceNotFoundException("Nao foi possivel encontrar empregado com o id " + id);
        }
        empregado.setNome(e.getNome());
        empregado.setDepartamento(e.getDepartamento());
        empregado.setSaldo(e.getSaldo());

        empregado = service.saveEmpregado(empregado);

        return ResponseEntity.ok(empregado);
    }
}
