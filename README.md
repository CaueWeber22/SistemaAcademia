# SistemaAcademia
Este projeto é um sistema web de gerenciamento de dados para uma academia, permitindo a inclusão, visualização, alteração e exclusão de dados relacionados a treinos, exercícios, usuários e funcionários.
Por se tratar de um sistema apenas para gerenciamentos de dados, possui uma interface simples e intuitiva. 

# Status do projeto
O projeto está completo, mas futuramente poderá ter novas funcionalidades adicionadas, como um sistema de login e interfaces para navegação dos usuários.

# Tecnologias Utilizadas
- Back-End: Java 22, Spring (Boot, web e data), Thymeleaf e Hibernate.
- Front-End: HTML, CSS, JavaScript, jQuery e Bootstrap.
- Banco de Dados: MySQL

# Desenvolvedor: 
Projeto desenvolvido por Cauê Weber de Souza Veras.

# Estrutura do Projeto
src/main/resources/static: contém arquivos estáticos como CSS, JavaScript e imagens.

src/main/resources/templates: contém templates Thymeleaf.

Dentro das pastas templates e static os arquivos (JavaScript, HTML e CSS) estão divididos dentro de subpastas para usuários, funcionários, exercícios e treinos.


com.adm.controller: contém os arquivos para controle de get e post do sistema.

com.adm.academia.data: contém as entidades (models).

com.adm.academia.data.repository: contém os repositórios para requisições ao banco de dados.

com.adm.academia.exception: classes para auxiliar no envio de mensagens de validação.

com.adm.academia.service: contem as classes para intermediação da comunicação entre controller e repository.

# Funcionalidades
As funcionalidades possuem validações para garantir a integridade dos dados e comunicação eficaz com o banco de dados, assegurando que todas as operações de CRUD (Create, Read, Update, Delete) sejam realizadas de forma segura e eficiente.

**Gerenciamento de Usuários**

Cadastro de Usuários: Permite a criação de novos usuários com validação dos dados de entrada. Todos os campos obrigatórios são verificados antes de inserir o novo usuário no banco de dados.

Visualização de Usuários: Exibe uma lista de todos os usuários cadastrados no sistema, com a possibilidade de visualizar detalhes específicos de cada usuário.

Edição de Usuários: Permite a atualização dos dados dos usuários existentes. As alterações são validadas antes de serem salvas no banco de dados.

Exclusão de Usuários: Facilita a remoção de usuários do sistema, garantindo que todos os dados relacionados sejam corretamente atualizados no banco de dados.    
<br/>

**Gerenciamento de Funcionários**

• Cadastro de Funcionários: Possibilita o registro de novos funcionários, com validação completa dos dados de entrada. A • inserção é feita no banco de dados após a validação dos dados fornecidos.

• Visualização de Funcionários: Fornece uma interface para visualizar todos os funcionários cadastrados, com detalhes específicos de cada um disponível para consulta.

• Edição de Funcionários: Permite a modificação dos dados dos funcionários. As mudanças são validadas e posteriormente salvas no banco de dados.

• Exclusão de Funcionários: Realiza a exclusão de funcionários, garantindo que todas as referências e dados associados sejam corretamente gerenciados no banco de dados.    
<br/>

**Gerenciamento de Treinos**

• Cadastro de Treinos: Permite a criação de novos treinos com validação de todos os campos obrigatórios antes da inserção no banco de dados.

• Visualização de Treinos: Exibe uma lista de todos os treinos cadastrados no sistema, com detalhes específicos disponíveis para consulta.

• Edição de Treinos: Permite a atualização das informações dos treinos. As alterações são validadas e salvas no banco de dados.

• Exclusão de Treinos: Facilita a remoção de treinos, garantindo que o banco de dados seja atualizado corretamente e que todas as referências sejam mantidas.    
<br/>

**Gerenciamento de Exercícios**

• Cadastro de Exercícios: Possibilita o registro de novos exercícios, com validação completa dos dados de entrada antes da inserção no banco de dados.

• Visualização de Exercícios: Fornece uma interface para visualizar todos os exercícios cadastrados, com a possibilidade de visualizar detalhes específicos de cada exercício.

• Edição de Exercícios: Permite a modificação dos dados dos exercícios. As mudanças são validadas antes de serem salvas no banco de dados.

• Exclusão de Exercícios: Realiza a exclusão de exercícios, garantindo que todas as referências e dados associados sejam corretamente gerenciados no banco de dados.    
