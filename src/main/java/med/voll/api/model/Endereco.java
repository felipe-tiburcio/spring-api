package med.voll.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import med.voll.api.dto.EnderecoDTO;
import med.voll.api.model.enums.UF;

@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UF uf;
    private String cep;

    public Endereco() {
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.logradouro();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
        this.bairro = enderecoDTO.bairro();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.cep = enderecoDTO.cep();
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, UF uf,
            String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public UF getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

}
