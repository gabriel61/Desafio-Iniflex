# Desafio Iniflex - Sistema de Gerenciamento de Funcionários

O objetivo é criar um sistema de gerenciamento de funcionários que atenda a uma série de requisitos específicos, como inserção, remoção, listagem, agrupamento e cálculos relacionados aos funcionários de uma empresa.

## Descrição do Desafio

O projeto foi desenvolvido para atender **todos os requisitos abaixo**:

1. **Classe `Pessoa`**:
   - Atributos: `nome` (String) e `dataNascimento` (LocalDate).

2. **Classe `Funcionario`** (estende `Pessoa`):
   - Atributos: `salario` (BigDecimal) e `funcao` (String).

3. **Classe Principal**:
   - **3.1** Inserir todos os funcionários na ordem da tabela fornecida.
   - **3.2** Remover o funcionário "João" da lista.
   - **3.3** Imprimir funcionários com:
      - Data formatada: `dd/mm/aaaa`.
      - Salário formatado: separador de milhar como ponto e decimal como vírgula (ex: `1.234,56`).
   - **3.4** Aplicar aumento de 10% nos salários.
   - **3.5** Agrupar funcionários por função em um `Map<String, List<Funcionario>>`.
   - **3.6** Imprimir funcionários agrupados por função.
   - **3.8** Imprimir funcionários que fazem aniversário em **outubro (10)** e **dezembro (12)**.
   - **3.9** Imprimir funcionário mais velho (nome e idade).
   - **3.10** Imprimir funcionários em ordem alfabética.
   - **3.11** Imprimir total dos salários.
   - **3.12** Imprimir quantos salários mínimos cada funcionário recebe (salário mínimo = R$1.212,00).

---

## Abordagem do Projeto

### Implementação dos Requisitos
- **Menu Interativo**: Utilização de um menu com `switch` para navegar entre as funcionalidades.
- **Formatação de Dados**:
   - Datas: `DateTimeFormatter` para `dd/MM/yyyy`.
   - Salários: `DecimalFormat` para exibir `1.234,56`.
- **Remoção do João**: Implementada logo após a inserção inicial (requisito 3.2).
- **Agrupamento por Função**: Uso de `Collectors.groupingBy` para criar o `Map`.
- **Ordenação**: Métodos de stream e `Comparator` para ordenar listas.

### Funcionalidades do Menu
| Opção | Requisito Atendido | Descrição |
|-------|--------------------|-----------|
| 1     | 3.1                | Insere funcionários (ordem da tabela). |
| 2     | 3.3                | Lista todos formatados (data e salário). |
| 3     | 3.4                | Aplica aumento de 10%. |
| 4     | 3.5 e 3.6          | Agrupa e imprime por função. |
| 5     | 3.8                | Lista aniversariantes de outubro/dezembro. |
| 6     | 3.9                | Exibe funcionário mais velho. |
| 7     | 3.10               | Ordena por nome. |
| 8     | 3.11               | Calcula total dos salários. |
| 9     | 3.12               | Exibe salários em múltiplos do mínimo. |

---
## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/Desafio-Iniflex.git
   ```
2. **Navegue até o diretório do projeto**:
   ```bash
   cd Desafio-Iniflex/src
   ```
3. **Compile o código** (UTF-8 para evitar erros de encoding):
   ```bash
   javac -encoding UTF-8 iniflex/model/*.java iniflex/service/*.java iniflex/Main.java
   ``` 
4. **Execute o programa**:
   ```bash
   java iniflex.Main
   ```
5. **Siga as instruções do menu**:
   ```bash
   Escolha uma opção digitando o número correspondente e pressione Enter
   ```
---

## Tecnologias Utilizadas

- **Java 17+**
- **BigDecimal**: Para cálculos precisos de salário.
- **LocalDate**: Para manipulação de datas.
- **Streams API**: Para operações de filtragem, ordenação e agrupamento.
- **IntelliJ IDEA**: IDE utilizado.

## Melhorias Implementadas

- **Menu Interativo**: Facilita a navegação e teste das funcionalidades.
- **Ordenação de Cargos**: Opção 4 exibe funções em ordem alfabética.
- **Salários Mínimos Decrescentes**: Opção 9 ordena do maior para o menor.

## Melhorias Futuras

- **Persistência de Dados**: Salvar e carregar funcionários em um arquivo JSON ou CSV.
- **Validações de Entrada**: Adicionar validações para evitar erros do usuário.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

<br>

## ✒️ Autor

<br>

<a href="https://github.com/gabriel61">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/gabriel61" width="100px;" alt="">
</a>

[![Linkedin Badge](https://img.shields.io/badge/-GabrielOliveira-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/sogabris/)](https://www.linkedin.com/in/sogabris/)
<br>
sogabris@gmail.com
<br>