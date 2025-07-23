# Sistema de Pedidos de Sanduíches

## Descrição
Sistema completo para gerenciamento de pedidos de sanduíches, desenvolvido em Java, oferecendo controle de pedidos, cardápio, estoque e atendimento ao cliente.

## Funcionalidades
### Gestão de Pedidos
- Cadastro de pedidos
- Personalização de sanduíches
- Acompanhamento do status
- Histórico de pedidos
- Impressão de comandas

### Gestão de Cardápio
- Cadastro de produtos
- Categorias e subcategorias
- Preços e promoções
- Fotos dos produtos
- Disponibilidade

### Gestão de Estoque
- Controle de ingredientes
- Alertas de estoque baixo
- Registro de entrada/saída
- Inventário
- Relatórios de consumo

### Atendimento
- Interface intuitiva
- Agilidade no atendimento
- Gestão de mesas
- Controle de pagamentos
- Emissão de comprovantes

## Estrutura do Projeto
- `src/` - Código fonte do sistema
  - `main/` - Classes principais
  - `model/` - Classes de modelo
  - `dao/` - Acesso a dados
  - `service/` - Regras de negócio
  - `ui/` - Interface gráfica
  - `utils/` - Utilitários
- `docs/` - Documentação
  - `manual/` - Manual do usuário
  - `api/` - Documentação técnica
- `database/` - Banco de dados
  - `scripts/` - Scripts SQL
  - `migrations/` - Migrações
- `assets/` - Recursos
  - `images/` - Imagens dos produtos
  - `icons/` - Ícones do sistema
- `tests/` - Testes
  - `unit/` - Testes unitários
  - `integration/` - Testes de integração

## Requisitos
### Sistema
- Java JDK 11+
- MySQL 8.0+
- 2GB RAM mínimo
- 500MB espaço em disco

### Desenvolvimento
- IDE: Eclipse, IntelliJ IDEA ou NetBeans
- Maven ou Gradle
- JDBC Driver
- JUnit 5

## Como Executar
1. Clone o repositório:
   ```bash
   git clone [url-do-repositorio]
   ```

2. Configure o banco de dados:
   ```bash
   mysql -u root -p < database/scripts/init.sql
   ```

3. Configure o projeto:
   ```bash
   cp src/main/resources/config.example.properties src/main/resources/config.properties
   # Edite o arquivo config.properties
   ```

4. Execute o sistema:
   ```bash
   mvn clean install
   java -jar target/sanduiche-system.jar
   ```

## Tecnologias Utilizadas
- Java 11
- Java Swing
- JDBC
- MySQL
- Maven
- JUnit 5
- JasperReports
- Log4j2

## Arquitetura
- Padrão MVC
- Arquitetura em camadas
- DAO Pattern
- Factory Pattern
- Observer Pattern

## Autor
[Seu nome será adicionado aqui]

## Data de Criação
[Data será adicionada aqui]

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contribuição
1. Faça o fork do projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request 