# 🏥 Clinic Management System

Sistema completo de gestão para clínicas médicas composto por:

- Backend REST API (Spring Boot)
- Frontend Web (React)
- Banco de dados PostgreSQL

O sistema tem como objetivo centralizar o gerenciamento de pacientes, profissionais de saúde, consultas, atendimentos, prontuários e processos financeiros de uma clínica.

---

## 📌 Sobre o projeto

O **Clinic Management System** é um sistema de gestão para clínicas médicas que está sendo desenvolvido de forma incremental, contemplando tanto o **backend** quanto o **frontend** da aplicação.

Atualmente, o projeto possui uma API REST desenvolvida em Spring Boot responsável pelo gerenciamento de pacientes e profissionais de saúde, incluindo validações de negócio, tratamento centralizado de exceções, documentação interativa e persistência de dados. Nas próximas etapas, o sistema será expandido para abranger funcionalidades como agendamento de consultas, prontuário eletrônico, emissão de receitas, solicitação de exames, gestão financeira, convênios e controle de acesso.

Além do backend, também será desenvolvido um **frontend web**, proporcionando uma experiência completa para recepcionistas, profissionais de saúde e administradores da clínica. O objetivo é simular um sistema utilizado em ambientes reais, cobrindo desde o cadastro de informações até o gerenciamento operacional da clínica.

---

## 🚀 Tecnologias utilizadas

### Backend

| Tecnologia | Finalidade |
|---|---|
| **Java 17** | Linguagem principal |
| **Spring Boot 3.3.5** | Framework backend |
| **Spring Web (MVC)** | Construção da API REST |
| **Spring Data JPA / Hibernate** | Persistência e mapeamento objeto-relacional |
| **PostgreSQL** | Banco de dados relacional |
| **Bean Validation (Jakarta Validation)** | Validação de dados de entrada |
| **MapStruct** | Mapeamento entre entidades e DTOs |
| **Lombok** | Redução de boilerplate (getters/setters/construtores) |
| **springdoc-openapi (Swagger UI)** | Documentação interativa da API |
| **Docker / Docker Compose** | Containerização da aplicação e do banco de dados |
| **Maven** | Gerenciamento de dependências e build |


### Frontend (Planejado)

| Tecnologia | Finalidade |
|------------|------------|
| **React** | Interface web |
| **TypeScript** | Tipagem estática |
| **Axios** | Comunicação com API |
| **React Router**| Navegação |
| **Material UI** | Componentes visuais |

---

## ⚙️ Funcionalidades

## 👨‍⚕️ Gestão de Profissionais

### Implementado

- Cadastro de profissionais
- Atualização de dados
- Consulta por identificador
- Busca paginada
- Ativação
- Inativação lógica

### Planejado

- Controle de especialidades
- Agenda profissional
- Horários de atendimento
- Férias e afastamentos
- Múltiplas unidades

### 🧑‍🤝‍🧑 Gestão de pacientes

### Implementado

- Cadastro de pacientes
- Atualização cadastral
- Consulta por CPF
- Ativação
- Inativação lógica

### Planejado

- Histórico de atendimentos
- Histórico financeiro
- Controle de convênios
- Cadastro de responsáveis
- Upload de documentos
## 📅 Agendamento de Consultas

### Planejado

- Agendamento
- Reagendamento
- Cancelamento
- Confirmação
- Controle de disponibilidade
- Controle de conflitos de horário
- Lista de espera
---

## 🩺 Atendimento Clínico

### Planejado

- Registro de atendimento
- Evolução clínica
- Observações médicas
- Registro de sintomas
- Diagnósticos

## 📄 Prontuário Eletrônico

### Planejado

- Histórico completo do paciente
- Evoluções clínicas
- Anexos
- Prescrições
- Solicitações de exames

## 🧪 Exames

### Planejado

- Solicitação de exames
- Registro de resultados
- Upload de laudos
- Histórico de exames

## 🔐 Segurança

### Planejado

- Spring Security
- JWT
- Controle de permissões
- Perfis de acesso
- Auditoria

## 🗂️ Estrutura do projeto

```
src/main/java/med/voll/api/CRUD/
├── api/
│   ├── controller/      → Endpoints REST 
│   ├── dto/             → Objetos de transferência de dados 
│   ├── exception/       → Tratamento global de exceções
│   └── swagger/         → Anotações customizadas de documentação da API
├── core/
│   ├── configuration/   → Configuração do OpenAPI/Swagger
│   ├── constants/       → Constantes de validação
│   ├── enums/           → Especialidade médica e Sexo
│   ├── response/        → Padrão de resposta da API (ApiResult)
│   └── validation/      → Validador customizado de CPF
└── domain/
    ├── entity/          → Entidades JPA 
    ├── repository/      → Interfaces Spring Data JPA
    └── service/         → Regras de negócio
```

---
