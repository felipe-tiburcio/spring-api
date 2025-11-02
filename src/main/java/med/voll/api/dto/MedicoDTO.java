package med.voll.api.dto;

import med.voll.api.model.enums.Especialidade;
import med.voll.api.model.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
                @NotBlank(message = "Nome é obrigatório.") String nome,

                @NotBlank(message = "Email é obrigatório.") 
                @Email String email,

                String telefone,

                @NotBlank(message = "CRM é obrigatório.") 
                @Pattern(regexp = "\\d{4,6}", message = "CRM tem 4 a 6 dígitos") String crm,

                @NotNull 
                Especialidade especialidade,

                @NotNull 
                @Valid 
                EnderecoDTO endereco) {

        public MedicoDTO(Medico medico) {
                this(
                                medico.getNome(),
                                medico.getEmail(),
                                medico.getTelefone(),
                                medico.getCrm(),
                                medico.getEspecialidade(),
                                new EnderecoDTO(medico.getEndereco()));
        }

};
