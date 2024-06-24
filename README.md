
# Gerenciamento de Notas de Estudantes

## Descrição
Este projeto é uma aplicação Java para gerenciar as notas de estudantes em uma disciplina específica. A aplicação permite cadastrar, alterar, remover, consultar e listar estudantes, além de calcular a média das notas. Os dados são armazenados em um arquivo CSV para persistência.

## Funcionalidades
- **Cadastrar Estudante**: Permite adicionar um novo estudante ao sistema.
- **Alterar Estudante**: Permite alterar os dados de um estudante existente.
- **Remover Estudante**: Permite remover um estudante do sistema.
- **Consultar Estudante**: Permite consultar os dados de um estudante específico.
- **Listar Estudantes**: Lista todos os estudantes cadastrados.
- **Listar Estudantes com Média Abaixo de 6.0**: Lista estudantes com média de notas abaixo de 6.0.
- **Listar Estudantes com Média Acima de 6.0**: Lista estudantes com média de notas acima de 6.0.
- **Mostrar Média da Turma**: Calcula e exibe a média das notas de todos os estudantes.
- **Salvar Dados**: Salva os dados dos estudantes no arquivo CSV.
- **Sair**: Encerra o programa e salva novamente.

## Estrutura do Projeto

### Classe Pessoa
Representa uma pessoa com nome e CPF.

### Classe Estudante
Representa um estudante, estendendo a classe Pessoa e adicionando atributos específicos como matrícula e notas. A classe Estudante também inclui métodos para calcular a média das notas e para converter os dados do estudante para um formato CSV.

### Classe Disciplina
Gerencia a lista de estudantes e implementa as funcionalidades principais do sistema. Esta classe inclui métodos para:
- **Listar Estudantes**: Lista todos os estudantes cadastrados.
- **Calcular Média da Turma**: Calcula a média das notas de todos os estudantes.
- **Buscar Estudante por Matrícula**: Busca um estudante específico pelo número de matrícula.
- **Inserir Estudante**: Adiciona um novo estudante à lista.
- **Alterar Estudante**: Altera os dados de um estudante existente.
- **Remover Estudante**: Remove um estudante da lista.
- **Listar Estudantes com Média Acima de 6.0**: Lista estudantes com média de notas acima de 6.0.
- **Listar Estudantes com Média Abaixo de 6.0**: Lista estudantes com média de notas abaixo de 6.0.
- **Gravar Arquivo**: Salva os dados dos estudantes em um arquivo CSV.
- **Carregar Dados**: Carrega os dados dos estudantes a partir de um arquivo CSV.

### Classe Principal (Main)
Gerencia a interação com o usuário e o menu principal. Esta classe controla o fluxo do programa, exibindo o menu de opções e chamando os métodos apropriados na classe Disciplina com base na escolha do usuário.

## Formato do Arquivo CSV
O arquivo CSV utilizado para armazenar os dados dos estudantes deve seguir o seguinte formato:
```
nome;cpf;matricula;nota01;nota02
```
Os valores numéricos para `nota01` e `nota02` utilizam vírgulas como separadores decimais.

### Exemplo de Conteúdo do Arquivo CSV
```
Artur;105;123;10,00;10,00
Pedro;456;789;8,00;7,50
Maria;789;456;6,00;5,50
```

## Como Executar
1. Compile todas as classes Java:
   ```
   javac Pessoa.java Estudante.java Disciplina.java Main.java
   ```
2. Execute a classe principal:
   ```
   java Main
   ```
3. Siga as instruções no menu para interagir com o sistema.

## Requisitos
- Java JDK 8 ou superior
- Um editor de texto ou IDE para escrever o código Java
- Acesso ao terminal ou prompt de comando para compilar e executar o programa

## Estrutura de Pastas
```
├── src
│   ├── Pessoa.java
│   ├── Estudante.java
│   ├── Disciplina.java
│   └── Main.java
├── estudantes.csv
└── README.md
```

## Considerações Finais
Este projeto foi desenvolvido com o objetivo de praticar conceitos de programação orientada a objetos em Java, bem como manipulação de arquivos e interação com o usuário via terminal. Especialmente feito para ganhar um pontinho extra na disciplina, nao que seja necessario.
