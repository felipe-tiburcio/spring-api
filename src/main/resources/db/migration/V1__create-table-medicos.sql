CREATE TABLE medicos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  telefone VARCHAR(20) NOT NULL,
  crm VARCHAR(20) NOT NULL,
  especialidade VARCHAR(50) NOT NULL,
  -- Embedded Endereco fields
  logradouro VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  complemento VARCHAR(100),
  numero VARCHAR(20)
);