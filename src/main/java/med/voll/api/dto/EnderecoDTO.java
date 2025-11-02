package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.enums.UF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank String logradouro,

        String numero,

        String complemento,

        @NotBlank String bairro,

        @NotBlank String cidade,

        @NotNull UF uf,

        @NotBlank @Pattern(regexp = "\\d{8}") String cep) {

    public EnderecoDTO(Endereco endereco) {
        this(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep());
    }
}
