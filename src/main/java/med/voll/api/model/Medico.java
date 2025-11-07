package med.voll.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import med.voll.api.dto.MedicoCreateDTO;
import med.voll.api.dto.MedicoUpdateDTO;
import med.voll.api.model.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String telefone;
        private String crm;

        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;

        public Medico() {
        }

        public Medico(MedicoCreateDTO medicoDTO) {
                this.nome = medicoDTO.nome();
                this.email = medicoDTO.email();
                this.telefone = medicoDTO.telefone();
                this.crm = medicoDTO.crm();
                this.especialidade = medicoDTO.especialidade();
                this.endereco = new Endereco(medicoDTO.endereco());
        }

        public Long getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public String getEmail() {
                return email;
        }

        public String getTelefone() {
                return telefone;
        }

        public String getCrm() {
                return crm;
        }

        public Especialidade getEspecialidade() {
                return especialidade;
        }

        public Endereco getEndereco() {
                return endereco;
        }

        public void atualizarDados(MedicoUpdateDTO medicoDTO) {
                if (medicoDTO.nome() != null) {
                        this.nome = medicoDTO.nome();
                }

                if (medicoDTO.telefone() != null) {
                        this.telefone = medicoDTO.telefone();
                }

                if (medicoDTO.endereco() != null) {
                        this.endereco.atualizar(medicoDTO.endereco());
                }

        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Medico other = (Medico) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                return true;
        }

};
