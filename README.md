# 🎬 Lista de Filmes — LDC

Aplicação de **linha de comando desenvolvida em Java** para gerenciamento de uma lista de filmes organizada por título e associada a categorias.

O projeto utiliza **listas duplamente encadeadas circulares** para representar tanto a lista principal de categorias quanto as listas de filmes, com separação das responsabilidades entre classes de controle e classes de modelo.

O projeto foi desenvolvido com foco no estudo de **Estruturas de Dados**, **Programação Orientada a Objetos (POO)** e manipulação de estruturas encadeadas em Java.

---

## 📋 Sobre o projeto

A aplicação permite cadastrar e gerenciar filmes por meio de um menu interativo no terminal.

Cada filme possui:

- **Título**
- **Gênero**
- **Classificação**
- **Ano de lançamento**

Os filmes são organizados alfabeticamente pelo **título**.

Além da lista principal de filmes, o projeto possui uma estrutura de **categorias**, permitindo associar filmes a uma determinada categoria e consultar os filmes pertencentes a ela.

---

## ⚙️ Funcionalidades

O menu principal disponibiliza as seguintes operações:

| Opção | Funcionalidade |
|---|---|
| `1` | Cadastrar um novo filme |
| `2` | Remover um filme |
| `3` | Exibir os dados de um filme |
| `4` | Editar os dados de um filme |
| `5` | Exibir todos os filmes cadastrados |
| `6` | Exibir os filmes de uma categoria |
| `7` | Exibir novamente o menu |
| `0` | Encerrar o programa |

### Edição de filmes

Ao selecionar a opção `4`, é possível alterar:

- Gênero;
- Classificação;
- Ano de lançamento.

O título é utilizado para localizar o filme e não possui opção de edição no menu atual.

---

## 🧱 Estrutura do projeto

```text
Lista-de-Filmes---LDC/
│
├── .idea/
│   ├── .gitignore
│   ├── description.html
│   ├── encodings.xml
│   ├── misc.xml
│   ├── modules.xml
│   ├── project-template.xml
│   └── runConfigurations.xml
│
├── src/
│   └── AtvLDC/
│       ├── Controle/
│       │   ├── Categoria.java
│       │   ├── Filme.java
│       │   ├── NodePrincipal.java
│       │   └── NodeSecundaria.java
│       │
│       ├── Interface/
│       │   └── Aplicacao.java
│       │
│       ├── Modelo/
│       │   ├── ListaCategorias.java
│       │   └── ListaFilmes.java
│       │
│       └── Main.java
│
├── AtvExtra2LDC.iml
├── .gitignore
└── README.md
```

---

## 🏗️ Organização das classes

O projeto está dividido em três grupos principais:

```text
AtvLDC/
│
├── Controle/
│   ├── Categoria
│   ├── Filme
│   ├── NodePrincipal
│   └── NodeSecundaria
│
├── Modelo/
│   ├── ListaCategorias
│   └── ListaFilmes
│
└── Interface/
    └── Aplicacao
```

### `Controle`

Contém as classes que representam os dados e os nós utilizados pelas listas.

### `Modelo`

Contém as estruturas responsáveis pelo armazenamento e gerenciamento dos filmes e categorias.

### `Interface`

Contém a classe responsável pela interação com o usuário por meio do terminal.

---

## 🎞️ Classe `Filme`

A classe `Filme` representa um filme cadastrado na aplicação.

Seus atributos são:

```java
private String titulo;
private String genero;
private String classificacao;
private int ano;
```

### Métodos principais

```java
getTitulo()
getGenero()
getClassificacao()
getAno()

setGenero()
setClassificacao()
setAno()

compareTo()
toString()
```

O método `compareTo()` compara os filmes utilizando o título:

```java
this.titulo.compareTo(busFil.titulo);
```

Assim, o título é utilizado para organizar e localizar os filmes na lista.

O método `toString()` apresenta os dados completos do filme.

---

## 🗂️ Classe `Categoria`

A classe `Categoria` representa uma categoria de filmes.

Possui os atributos:

```java
private String descricao;
private ListaFilmes lista;
```

A `descricao` identifica a categoria e `lista` representa a lista de filmes associada à categoria.

A comparação entre categorias também é realizada utilizando a descrição:

```java
this.descricao.compareTo(busCateg.descricao);
```

---

## 🔗 Classe `NodePrincipal`

`NodePrincipal` representa um nó da lista principal de categorias.

Cada nó possui:

```java
private Categoria info;
private NodePrincipal ante;
private NodePrincipal prox;
```

Onde:

- `info` armazena uma categoria;
- `ante` referencia o nó anterior;
- `prox` referencia o próximo nó.

---

## 🔗 Classe `NodeSecundaria`

`NodeSecundaria` representa um nó da lista de filmes.

Possui:

```java
private Filme info;
private NodeSecundaria ante;
private NodeSecundaria prox;
```

Onde:

- `info` armazena um filme;
- `ante` referencia o nó anterior;
- `prox` referencia o próximo nó.

---

# 📚 Estruturas de dados

## Lista principal de categorias

A classe `ListaCategorias` utiliza `NodePrincipal` para armazenar as categorias.

A lista mantém referências para:

```java
private NodePrincipal primeiro;
private NodePrincipal ultimo;
private int qtd;
```

As categorias são organizadas de acordo com sua descrição.

A estrutura utiliza referências para o nó anterior e para o próximo nó, formando uma **lista duplamente encadeada circular**.

Conceitualmente:

```text
                 ┌─────────────────────────────┐
                 │                             │
                 ▼                             │
        ┌──────────────┐    ┌──────────────┐   │
        │   Categoria  │◄──►│   Categoria  │───┤
        └──────────────┘    └──────────────┘   │
                 ▲                             │
                 │                             │
                 └─────────────────────────────┘
```

O último elemento aponta para o primeiro e o primeiro mantém referência para o último.

---

## Lista de filmes

A classe `ListaFilmes` utiliza `NodeSecundaria` para armazenar os filmes.

A lista mantém:

```java
private NodeSecundaria primeiro;
private NodeSecundaria ultimo;
private int qtd;
```

Os filmes são inseridos em ordem alfabética pelo título.

A estrutura também é circular e duplamente encadeada:

```text
                 ┌─────────────────────────────┐
                 │                             │
                 ▼                             │
        ┌──────────────┐    ┌──────────────┐   │
        │     Filme    │◄──►│     Filme    │───┤
        └──────────────┘    └──────────────┘   │
                 ▲                             │
                 │                             │
                 └─────────────────────────────┘
```

---

# 🔄 Relação entre categorias e filmes

O projeto utiliza uma estrutura em que uma `Categoria` possui uma `ListaFilmes`.

A organização pretendida pode ser representada por:

```text
ListaCategorias
       │
       ├── Categoria
       │      │
       │      └── ListaFilmes
       │             ├── Filme
       │             ├── Filme
       │             └── Filme
       │
       ├── Categoria
       │      │
       │      └── ListaFilmes
       │             ├── Filme
       │             └── Filme
       │
       └── Categoria
              │
              └── ListaFilmes
                     └── Filme
```

Dessa forma, cada categoria pode manter uma lista própria de filmes.

---

# 🛠️ Principais operações

## Inserção de filme

A classe `ListaFilmes` disponibiliza:

```java
inserir(Filme film, Categoria categ)
```

A operação cria um novo `NodeSecundaria`, verifica a posição correta de acordo com o título e insere o filme na lista.

Antes da inserção, o método verifica se já existe um filme com o mesmo título.

Quando um filme duplicado é encontrado, a aplicação informa:

```text
Filme já cadastrado. Inseção não efetuada.
```

Após a inserção, são solicitados:

```text
Gênero
Classificação
Ano de lançamento
```

---

## Busca de filme

A operação:

```java
buscaFilme(Filme film)
```

percorre a lista procurando um filme pelo título.

Quando encontra o filme, retorna o `NodeSecundaria` correspondente.

Caso não encontre, retorna:

```java
null
```

Como os filmes estão organizados alfabeticamente, a busca pode ser encerrada quando a comparação indica que o elemento procurado deveria estar antes do elemento atual.

---

## Remoção de filme

A operação:

```java
removeFilme(Filme film)
```

remove um filme da lista.

O método trata diferentes situações:

- lista vazia;
- remoção do primeiro filme;
- remoção do último filme;
- remoção de um filme intermediário;
- filme não encontrado.

A remoção ajusta as referências `ante` e `prox` dos nós vizinhos.

---

## Exibição de um filme

A operação:

```java
exibeFilme(Filme film)
```

procura o filme pelo título e, quando encontrado, apresenta seus dados:

```text
Titulo: ...
Gênero: ...
Classificação: ...
Ano: ...
```

---

## Exibição de todos os filmes

A operação:

```java
exibeListaFilme()
```

percorre a lista a partir do primeiro nó até retornar novamente ao primeiro elemento.

Cada filme é exibido juntamente com sua posição na lista.

---

## Edição de filme

A operação:

```java
editaFilme(Filme film)
```

localiza um filme pelo título e apresenta um menu específico:

```text
Opções para edição:
1 - Editar gênero.
2 - Editar classificação.
3 - Editar ano.
0 - Sair do menu de edições.
```

A edição permite alterar os dados armazenados no objeto `Filme`.

---

## Consulta por categoria

A classe `ListaCategorias` disponibiliza:

```java
exibeCategoria(Categoria categ)
```

A operação procura uma categoria pela descrição e, caso ela seja encontrada, solicita a exibição da lista de filmes associada à categoria.

Quando a categoria não existe, é exibida a mensagem:

```text
Categoria não cadastrada.
```

---

# 🖥️ Classe `Aplicacao`

A classe:

```text
AtvLDC.Interface.Aplicacao
```

é responsável pela interação com o usuário.

Seu método:

```java
public static void main(String[] args)
```

inicializa os objetos necessários e controla o menu principal.

A aplicação utiliza `Scanner` para receber os dados digitados no terminal.

O fluxo geral é:

```text
              ┌───────────────┐
              │   Aplicacao   │
              └───────┬───────┘
                      │
                      ▼
               ┌─────────────┐
               │    Menu     │
               └──────┬──────┘
                      │
          ┌───────────┼───────────┐
          │           │           │
          ▼           ▼           ▼
       Inserir      Buscar      Remover
          │           │           │
          └───────────┼───────────┘
                      │
                      ▼
               ┌─────────────┐
               │ ListaFilmes │
               └──────┬──────┘
                      │
                      ▼
                NodeSecundaria
                      │
                      ▼
                    Filme
```

---

# ▶️ Como executar

## Pré-requisitos

O projeto está configurado no IntelliJ IDEA para utilizar **JDK 17**.

É recomendado utilizar:

- **JDK 17 ou compatível**;
- IntelliJ IDEA ou outra IDE compatível com Java;
- terminal, caso a execução seja feita por linha de comando.

Para verificar a versão do Java:

```bash
java -version
```

Para verificar o compilador:

```bash
javac -version
```

---

## 💻 Executando pelo IntelliJ IDEA

O projeto possui arquivos de configuração do IntelliJ IDEA e o módulo:

```text
AtvExtra2LDC.iml
```

Para executar:

1. Abra o projeto no IntelliJ IDEA.
2. Localize:
   ```text
   src/AtvLDC/Interface/Aplicacao.java
   ```
3. Abra a classe `Aplicacao`.
4. Execute o método `main`.
5. Utilize o menu apresentado no terminal.

> A classe `Aplicacao` é o ponto de entrada efetivamente utilizado pelo programa. O arquivo `src/AtvLDC/Main.java` não possui implementação no estado atual do projeto.

---

## ⌨️ Executando pelo terminal

Na raiz do projeto, compile os arquivos Java:

```bash
javac -d out src/AtvLDC/Controle/*.java src/AtvLDC/Modelo/*.java src/AtvLDC/Interface/*.java
```

Depois, execute:

```bash
java -cp out AtvLDC.Interface.Aplicacao
```

O diretório `out/` é utilizado para armazenar os arquivos `.class` gerados durante a compilação e está configurado no `.gitignore`.

---

# 🧪 Exemplo de utilização

Ao iniciar a aplicação, o menu apresenta:

```text
Menu de opções para a lista de filmes:
1 - Cadastrar um novo filme na lista.
2 - Remover um filme da lista.
3 - Exibir os dados de um único filme.
4 - Editar os dados de um filme.
5 - Exibir os dados de todos os filmes cadastrados.
6 - Exibir os dados de todos os filmes de uma categoria.
0 - Sair do programa.
```

### Cadastrando um filme

Selecione:

```text
1
```

Informe a categoria:

```text
Informe a descrição de sua categoria: Ação
```

Depois informe o título:

```text
Informe o título do filme: Matrix
```

Na sequência, são solicitados:

```text
Informe o gênero do filme:
Informe a sua classificação:
Informe o ano de lançamento:
```

---

# ⚠️ Estado atual da implementação

A estrutura do projeto demonstra a implementação de uma lista duplamente encadeada circular para filmes e outra estrutura semelhante para categorias.

Entretanto, **a integração entre `Categoria`, `ListaCategorias` e `ListaFilmes` apresenta limitações na implementação atual**.

Em particular, a classe `Categoria` possui o atributo:

```java
private ListaFilmes lista;
```

mas o projeto não inicializa essa lista no construtor da categoria.

Além disso, `ListaFilmes.inserir()` cria uma nova instância de `ListaCategorias` durante a operação de inserção, em vez de manter uma estrutura de categorias compartilhada pela aplicação.

Como consequência, a funcionalidade de associação e consulta de filmes por categoria **necessita de ajustes no código para funcionar integralmente como a estrutura proposta**.

Esta documentação descreve o comportamento e a organização presentes no código enviado, sem considerar essas limitações como funcionalidades já corrigidas.

---

# 🧠 Conceitos aplicados

O projeto permite praticar conceitos importantes de Java e Estruturas de Dados:

- Programação Orientada a Objetos;
- Classes e objetos;
- Encapsulamento;
- Construtores;
- Métodos `get` e `set`;
- Referências entre objetos;
- Listas duplamente encadeadas;
- Listas duplamente encadeadas circulares;
- Nós (`Node`);
- Referências para elementos anteriores e posteriores;
- Inserção ordenada;
- Busca sequencial;
- Remoção de elementos;
- Atualização de objetos;
- Percurso de listas;
- Estruturas condicionais;
- Estruturas de repetição;
- Entrada de dados com `Scanner`;
- Organização de dados por categorias.

---

# 🎯 Objetivos do projeto

O projeto tem como principais objetivos:

- implementar uma lista duplamente encadeada circular;
- armazenar filmes em uma estrutura dinâmica;
- organizar filmes alfabeticamente pelo título;
- trabalhar com categorias associadas a listas de filmes;
- praticar operações de inserção, busca, remoção e edição;
- manipular referências entre nós;
- desenvolver uma aplicação interativa em Java;
- aplicar conceitos de Programação Orientada a Objetos;
- compreender o funcionamento de estruturas encadeadas.

---

# 📌 Características da aplicação

- Aplicação executada pelo **terminal**;
- Desenvolvida em **Java**;
- Utiliza **JDK 17** na configuração do projeto;
- Não utiliza banco de dados;
- Não possui interface gráfica;
- Os dados são mantidos apenas durante a execução;
- Filmes são identificados pelo título;
- Filmes são organizados alfabeticamente;
- A estrutura utiliza listas duplamente encadeadas circulares;
- Categorias possuem uma estrutura destinada a armazenar seus filmes.

---

# 👨‍💻 Autor

Projeto desenvolvido para fins acadêmicos, com foco no estudo de **Java**, **Programação Orientada a Objetos** e **Estruturas de Dados**.

---

# 🛠️ Tecnologias

- **Java**
- **JDK 17**
- **IntelliJ IDEA**
- **Git / GitHub**
