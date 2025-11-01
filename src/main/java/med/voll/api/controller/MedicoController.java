package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import med.voll.api.model.Medico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public Medico saveMedico(@RequestBody Medico medico) {
        return medico;
    }

    @GetMapping
    public List<Medico> getListaMedicos() {
        return new ArrayList<Medico>();
    }

}
