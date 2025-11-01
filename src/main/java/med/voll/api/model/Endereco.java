package med.voll.api.model;

import med.voll.api.model.enums.UF;

public record Endereco(
                String logradouro,
                String numero,
                String complemento,
                String bairro,
                String cidade,
                UF uf,
                String cep) {
}
