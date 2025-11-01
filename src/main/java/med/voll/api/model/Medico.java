package med.voll.api.model;

import med.voll.api.model.enums.Especialidade;

public record Medico(
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {
};
