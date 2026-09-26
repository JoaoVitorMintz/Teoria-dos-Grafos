# Resumo da Matéria — Teoria dos Grafos

A **Teoria dos Grafos** é uma área da matemática que estuda as relações entre entidades (objetos) que possuem características ou relações relevantes entre si.

Essas entidades são representadas por **vértices** (ou nós), enquanto suas relações são representadas por **arestas**.

Um grafo pode ser representado pelo par:

**G(V, E)**

Onde:

- **V** representa o conjunto de vértices;
- **E** representa o conjunto de arestas que conectam os vértices.

## Tipos de Grafos

| Tópico | Descrição |
|---|---|
| **Grafo Direcionado (Dígrafo)** | É um grafo representado pelo par **G(V, E)**. Uma aresta **(v, w) ∈ E** pode ser representada por **v → w**, sendo **v** o **vértice de origem** do arco e **w** o **vértice de destino**. A ordem dos vértices é importante: **v → w** não é necessariamente igual a **w → v**. |
| **Grafo Direcionado Acíclico (GDA)** | É um grafo direcionado que não contém ciclos. Isso significa que não é possível seguir as direções das arestas e retornar ao vértice de origem. Todas as árvores são GDA, entretanto, nem todo GDA é uma árvore. |
| **Grafo Não Direcionado** | É um grafo representado pelo par **G(V, E)** onde os vértices estão conectados por arestas que não possuem direção. Diferentemente de um dígrafo, a ordem dos vértices não importa, pois uma conexão entre **v** e **w** é equivalente à conexão entre **w** e **v**. |
| **Grafos Rotulados (Ponderados/Valorados)** | Em aplicações práticas, podem ser utilizados valores ou rótulos associados aos vértices e/ou às arestas/arcos. Esses valores podem representar diferentes informações, dependendo do problema analisado. **Arestas paralelas** são duas ou mais arestas que possuem as mesmas duas extremidades. |
| **Multigrafo** | É um grafo que permite a existência de **múltiplas arestas paralelas** entre um mesmo par de vértices. |
| **Grafo Simples** | É um grafo que não contém **arestas paralelas nem laços**. |

### Exemplo — Arestas paralelas em um multigrafo não direcionado

Imagine duas cidades `A` e `B` conectadas por **duas estradas diferentes**:

~~~text
        Estrada 1
      ╭────────────╮
     ╱              ╲
A ──╯                ╰── B
     ╲              ╱
      ╰────────────╯
        Estrada 2
~~~

No grafo, podemos representar as duas estradas como duas arestas distintas:

`e₁ = {A, B}`

`e₂ = {A, B}`

As duas arestas possuem os **mesmos dois vértices como extremidades**, mas são arestas diferentes. Portanto, são chamadas de **arestas paralelas**.

Como o grafo é **não direcionado**, cada estrada pode ser percorrida nos dois sentidos:

~~~text
A ↔ B
~~~

Isso **não significa** que uma estrada vai de `A` para `B` e a outra de `B` para `A`. Cada estrada, individualmente, pode ser percorrida nos dois sentidos.

- **Não direcionado** → as arestas não possuem direção; `A-B` e `B-A` representam a mesma ligação.
- **Arestas paralelas** → duas ou mais arestas diferentes possuem as mesmas extremidades.
- **Multigrafo** → permite a existência de múltiplas arestas paralelas entre um mesmo par de vértices.
- **Grafo simples** → não permite arestas paralelas nem laços.

**Macete:**

> **Direção** → "A ligação possui sentido?"
>
> **Multiplicidade** → "Pode haver mais de uma ligação entre os mesmos vértices?"

## Representação de Grafos

Para a representação de grafos, é comum utilizar **Matriz de Adjacência** ou **Lista de Adjacência**. Entretanto, a utilização dessas representações depende de determinadas características do grafo:

- Se o grafo contém poucas arestas, isso indica que a maioria dos elementos da matriz de adjacência possui valor **0** (ou **∞**, dependendo da representação utilizada em grafos ponderados).
- Uma matriz onde a maioria dos elementos possui valor **0** (ou **∞**) é chamada de **matriz esparsa**.
- Um grafo `G = (V, E)` é considerado **esparso** quando a quantidade de arestas cresce na ordem da quantidade de vértices, ou seja:

$$
|E| = O(|V|)
$$

Onde:

- `|V|` representa a quantidade de vértices;
- `|E|` representa a quantidade de arestas;
- `O(|V|)` representa uma **ordem de crescimento linear**, indicando que a quantidade de arestas cresce proporcionalmente à quantidade de vértices.

- Um grafo `G = (V, E)` é considerado **denso** quando a quantidade de arestas cresce aproximadamente na ordem quadrática da quantidade de vértices:

$$
|E| = O(|V|^2)
$$

Isso significa que, conforme a quantidade de vértices aumenta, a quantidade de arestas pode crescer proporcionalmente ao quadrado da quantidade de vértices.

### Resumo

- **Grafo esparso** → poucas arestas → crescimento próximo de `O(|V|)`.
- **Grafo denso** → muitas arestas → crescimento próximo de `O(|V|²)`.

| Tópico | Descrição | Grafo Direcionado | Grafo Não Direcionado |
|---|---|---|---|
| **Matriz de Adjacência** | É uma representação de um grafo utilizando uma matriz. Cada linha e coluna representa um vértice. O valor presente na posição **M[i][j]** indica se existe uma aresta ligando o vértice **i** ao vértice **j**. Em grafos simples, geralmente utiliza-se **1** para indicar que existe uma conexão e **0** para indicar que não existe. | É mais comum haver mais espaços vazios na matriz, pois uma conexão de i → j não implica necessariamente a existência de j → i. | É menos comum haver espaços ocupados em apenas uma direção, pois, se existe uma conexão entre i e j, a matriz também deve indicar a conexão entre j e i. Por isso, a matriz de adjacência de um grafo não direcionado é simétrica (espelhada) em relação à diagonal. |
| **Lista de Adjacência** | É uma representação de um grafo utilizando uma **lista encadeada para cada vértice**, onde cada lista **armazena os vértices adjacentes a ele**. É especialmente **eficiente para representar grafos esparsos**. | Costuma formar listas menores, pois cada vértice armazena apenas os vértices para os quais possui uma conexão direcionada. | Costuma formar listas maiores, pois uma conexão entre dois vértices deve ser representada na lista de adjacência de ambos os vértices. |
| **Matriz de Incidência** | Outra abordagem para representação de grafos, onde as **linhas da matriz representam os nós (vértices)** e as **colunas representam as arestas/arcos**. Cada elemento da matriz indica a relação entre um vértice e uma determinada aresta. | Seja um grafo `G = (V, E)`, onde uma aresta `k` sai do nó `i` e incide no nó `j`. A matriz de incidência é dada por: **-1** se a aresta `k` sai do nó `i`, **1** se a aresta `k` chega (incide) no nó `j` e **0** caso contrário. | Seja um grafo `G = (V, E)`, onde uma aresta `k` conecta os nós `i` e `j`. A matriz de incidência é dada por: **1** se a aresta `k` incide no nó `i` ou no nó `j` e **0** caso contrário. |

**Importante**: Para Matriz de Incidência em **grafo direcionado ponderado**, troca-se **0** por **∞** e **1/-1** por **p/-p**, sendo **p** o peso dado. Proporcional para a Matriz de incidência em **grafo não-direcionado ponderado**.

## Conceitos iniciais de Grafos

| Tópico | Descrição |
|---|---|
| **Grafo Completo** | É completo se existir uma ligação entre **cada par de vértices distintos**, sem considerar laços. Todas as estruturas desse tipo com a mesma ordem são isomorfas. Grafos completos não orientados são conhecidos como **cliques** e recebem a notação **Kₙ**. |
| **Conjunto das Partes** | É o conjunto formado por **todos os subconjuntos** de um conjunto `X`, denotado por **P(X)** ou **2ⁿ**. Por exemplo, se `X = {a, b, c}`, então `P(X) = {∅, {a}, {b}, {c}, {a,b}, {a,c}, {b,c}, {a,b,c}}`. |
| **Potência Cartesiana** | **Xᵏ** é o conjunto de todas as **k-uplas ordenadas** formadas pelos elementos de `X`, permitindo repetição. Por exemplo, `X²` contém todos os pares ordenados possíveis. Como a ordem importa, `(a,b) ≠ (b,a)`. |

### Fórmulas de contagem

#### 1. Conjunto das partes — `2ⁿ`

Calcula a **quantidade total de subconjuntos** que podem ser formados a partir de um conjunto com `n` elementos.

- **Quando usar:** quando queremos saber quantos subconjuntos diferentes podem ser formados, independentemente da quantidade de elementos em cada subconjunto.
- **Exemplo:** se `X = {a, b, c}`, então `|P(X)| = 2³ = 8`.

**Ideia para lembrar:** cada elemento tem duas possibilidades: estar ou não estar no subconjunto.

#### 2. Combinação — `C(n,k) = n! / (k!(n-k)!)`

Calcula a quantidade de maneiras de **escolher exatamente `k` elementos** de um conjunto com `n` elementos, sem considerar a ordem.

- **Quando usar:** quando queremos contar subconjuntos com exatamente `k` elementos.
- **Exemplo:** se `X = {a, b, c}` e queremos escolher dois elementos, temos `C(3,2) = 3` possibilidades: `{a,b}`, `{a,c}` e `{b,c}`.

**Ideia para lembrar:** a ordem não importa. Escolher `a` e depois `b` é a mesma coisa que escolher `b` e depois `a`.

**Aplicação em grafos:** calcular a quantidade de arestas possíveis em um grafo completo não orientado, sem laços.

`C(n,2) = n(n-1)/2`

Por exemplo, um grafo completo não orientado com 3 vértices possui `C(3,2) = 3` arestas possíveis.

#### 3. Potência cartesiana — `|Xᵏ| = nᵏ`

Calcula a quantidade de **k-uplas ordenadas** que podem ser formadas com os elementos de um conjunto de `n` elementos, permitindo repetição.

- **Quando usar:** quando queremos contar todos os pares ou sequências ordenadas possíveis, permitindo que um elemento apareça mais de uma vez.
- **Exemplo:** se `X = {a, b, c}`, então `|X²| = 3² = 9` pares ordenados.

**Ideia para lembrar:** a ordem importa e a repetição é permitida.

**Aplicação em grafos:** representar todos os arcos possíveis de um grafo orientado, incluindo laços.

`|X²| = n²`

Por exemplo, com 3 vértices, temos `3² = 9` pares ordenados possíveis, incluindo `(a,a)`, `(b,b)` e `(c,c)`.

#### 4. Arranjo — `A(n,k) = n! / (n-k)!`

Calcula a quantidade de maneiras de **selecionar e ordenar `k` elementos distintos** de um conjunto com `n` elementos, sem repetição.

- **Quando usar:** quando queremos contar sequências ordenadas de elementos distintos.
- **Exemplo:** se `X = {a, b, c}` e queremos formar pares ordenados sem repetição, temos `A(3,2) = 6` possibilidades: `(a,b)`, `(a,c)`, `(b,a)`, `(b,c)`, `(c,a)` e `(c,b)`.

**Ideia para lembrar:** a ordem importa, mas não podemos repetir elementos.

**Aplicação em grafos:** calcular a quantidade de arcos possíveis em um grafo orientado simples, sem laços.

`A(n,2) = n(n-1)`

Por exemplo, com 3 vértices, temos `A(3,2) = 6` arcos possíveis.

### Comparação das fórmulas

| Fórmula | O que calcula? | A ordem importa? | Permite repetição? |
|---|---|---|---|
| **`2ⁿ`** | Todos os subconjuntos de um conjunto. | Não | Não se aplica |
| **`C(n,k)`** | Subconjuntos com exatamente `k` elementos. | Não | Não |
| **`nᵏ`** | Todas as k-uplas ordenadas. | Sim | Sim |
| **`A(n,k)`** | Todas as sequências ordenadas de `k` elementos distintos. | Sim | Não |

### Resumo para Teoria dos Grafos

Considerando um conjunto de 3 vértices `V = {a, b, c}`:

| Operação | Resultado | Interpretação |
|---|---:|---|
| **`2³`** | 8 | Quantidade de subconjuntos de vértices. |
| **`C(3,2)`** | 3 | Quantidade de pares de vértices distintos sem considerar a ordem. Pode ser usada para contar as arestas de um grafo completo não orientado. |
| **`3²`** | 9 | Quantidade de pares ordenados, incluindo laços. Pode representar todos os arcos possíveis de um grafo orientado com laços permitidos. |
| **`A(3,2)`** | 6 | Quantidade de pares ordenados sem repetição. Pode representar todos os arcos possíveis de um grafo orientado simples, sem laços. |

### Macete para lembrar

- **Conjunto das partes (`2ⁿ`):** quero todos os subconjuntos possíveis.
- **Combinação (`C(n,k)`):** quero escolher exatamente `k` elementos, sem me importar com a ordem.
- **Potência cartesiana (`nᵏ`):** quero todas as sequências ordenadas possíveis, permitindo repetição.
- **Arranjo (`A(n,k)`):** quero todas as sequências ordenadas possíveis, sem repetição.

**Atenção:** a combinação e o arranjo podem ser usados para contar ligações em grafos, mas a escolha depende de a ordem importar. Em grafos não orientados, a ligação entre dois vértices não tem direção; em grafos orientados, a direção distingue os arcos.

## Ligações adjacentes, incidentes e semigrau:

| Tópico | Descrição |
|---|---|
| **Adjacência e Incidência** | Em grafos orientados/direcionados, as arestas são chamadas de **arcos**. **Adjacência** é uma relação entre **vértices**: dois vértices são adjacentes quando existe um arco ligando diretamente um ao outro. **Incidência** é uma relação entre um **arco e um vértice**: um arco é incidente a um vértice quando esse vértice constitui uma de suas extremidades. Assim, enquanto a adjacência parte da perspectiva dos **vértices** ("quais vértices estão diretamente ligados?"), a incidência parte da perspectiva do **arco** ("a quais vértices este arco está ligado?"). |]
| **Semigrau** | Em um grafo orientado, um arco **incide exteriormente** em um vértice `x ∈ V` quando `x` é sua **extremidade inicial** (o arco **sai de x**). Um arco **incide interiormente** em `x` quando `x` é sua **extremidade final** (o arco **entra em x**). O conjunto dos arcos incidentes exteriormente em `x` é denotado por **ω⁺(x)** e sua cardinalidade é o **semigrau exterior**, denotado por **d⁺(x)**. Analogamente, o conjunto dos arcos incidentes interiormente em `x` é denotado por **ω⁻(x)** e sua cardinalidade é o **semigrau interior**, denotado por **d⁻(x)** (d é a quantidade enquanto ω é o conjunto) |
| **Arestas incidentes** | Em grafo não orientado, dizemos apenas que uma aresta incide e que o conjunto de **arestas incidentes** são denotadas ω(x) mas em grafos orientados, dizemos que arestas incidentes são denotadas ω(x) = ω⁺(x) U ω⁻(x) |
| **Grau** | Define-se grau de um vértice, denotado por d(x) como sendo o número de ligações que nele incidem. Em grafos orientados d(x) = d⁺(x) + d⁻(x) enquanto em grafos não orientados d(x) = \|ω(x)\| |

### Semigrau — para memorizar

- **ω⁺(x)** = conjunto dos **arcos que saem de x**
- **d⁺(x)** = **quantidade** de arcos que saem de x
  - `d⁺(x) = |ω⁺(x)|`

- **ω⁻(x)** = conjunto dos **arcos que entram em x**
- **d⁻(x)** = **quantidade** de arcos que entram em x
  - `d⁻(x) = |ω⁻(x)|`

**Macete:**

> **ω = conjunto dos arcos**  
> **d = quantidade de arcos**  
> **+ = sai**  
> **− = entra**

Seja um Grafo G = (V, A) sem laços:

 - Valor |V| = n é chamado de **ordem do grafo**
 - Valor |A| = m é chamado de **tamanho de um grafo**
 - **Grafo Trivial** é um grafo onde m = 0 ou, no caso, um arco com vértices e nenhuma aresta
 - Um vértice de grau nulo é um **vértice isolado**
 - Um vértice de grau 1 é chamado de **pendente**

## Simetria de Grafos

| Tópico | Descrição |
|---|---|
| **Simétrico** | Um grafo G = (V, A) será **simétrico** se a relação associada a A for uma relação simétrica. Isso significa que, se `x → w` pertence a A, então `w → x` também pertence a A. |
| **Antissimétrico** | Um grafo G = (V, A) será **antissimétrico** se a relação associada a A for uma relação antissimétrica. Isso significa que, para dois vértices distintos `x ≠ w`, se `x → w` pertence a A, então `w → x` **não pode** pertencer a A. |

## Subgrafo e Grafo parcial

| Tópico | Descrição |
|---|---|
| **Subgrafo** | Um **subgrafo** é uma subestrutura `H = (Y, W)` de um grafo `G = (V, A)` tal que `Y ⊆ V` e `W ⊆ A`, sendo que `W` contém apenas as ligações/arcos de `G` cujas extremidades pertencem aos vértices escolhidos em `Y`. Portanto, um subgrafo pode possuir **menos vértices e menos ligações/arcos** que o grafo original. |
| **Grafo parcial** | Um **grafo parcial**, também chamado de **subgrafo gerador ou abrangente**, é um caso particular de subgrafo `F = (V, W)` no qual **todos os vértices do grafo original são mantidos** (`V_F = V_G`), mas apenas um subconjunto das ligações/arcos é mantido (`W ⊆ A`). Portanto, um grafo parcial pode **remover ligações/arcos, mas não pode remover vértices**. |

### Subgrafo

Para um grafo `G = (V, A)`, escolhemos um subconjunto de vértices:

`Y ⊆ V`

e mantemos apenas as ligações/arcos de `G` cujas extremidades pertencem a `Y`.

- Para um grafo **não orientado**:

  `W = A ∩ P₂(Y)`

- Para um grafo **orientado**:

  `W = A ∩ Y²`

### Grafo parcial

No grafo parcial, **todos os vértices são mantidos**:

`F = (V, W)`

com:

`W ⊆ A`

Assim, a diferença fundamental é:

> **Subgrafo:** pode remover **vértices e ligações/arcos**.
>
> **Grafo parcial:** mantém **todos os vértices** e pode remover apenas **ligações/arcos**.

O grafo original `G` de um subgrafo ou grafo parcial é chamado de **supergrafo**.

### Macete

- **Subgrafo:** `Y ⊆ V` → pode diminuir os vértices.
- **Grafo parcial:** `V` permanece igual → só `W ⊆ A` pode diminuir.

## Hipergrafo

Um **hipergrafo** é uma generalização do conceito de grafo.

Em um grafo tradicional, uma aresta conecta exatamente **dois vértices**:

~~~text
A ───── B
~~~

Podemos representar uma aresta como um par de vértices:

`e = {A, B}`

Já em um hipergrafo, uma **hiperaresta pode conectar dois ou mais vértices ao mesmo tempo**.

Por exemplo:

~~~text
       A
      / \
     /   \
    B─────C
     \   /
      \ /
       D
~~~

Uma hiperaresta poderia ser:

`e₁ = {A, B, C, D}`

Ou seja, uma única hiperaresta relaciona **quatro vértices simultaneamente**.

### Definição

Um hipergrafo pode ser representado por:

`H = (V, A)`

onde:

- `V` = conjunto de vértices;
- `A` = conjunto de hiperarestas;
- cada hiperaresta é um **subconjunto de `V`**.

Assim:

`A ⊆ P(V)`

onde `P(V)` é o conjunto das partes de `V`, ou seja, o conjunto de todos os subconjuntos possíveis de `V`.

### Exemplo

Considere:

`V = {A, B, C, D}`

e:

`A = {{A,B}, {A,B,C}, {B,C,D}}`

Temos três hiperarestas:

- `e₁ = {A,B}` → conecta 2 vértices;
- `e₂ = {A,B,C}` → conecta 3 vértices;
- `e₃ = {B,C,D}` → conecta 3 vértices.

Perceba que uma hiperaresta **não precisa conectar apenas dois vértices**.

> **Macete:**
>
> **Grafo:** uma aresta normalmente conecta `2` vértices.
>
> **Hipergrafo:** uma hiperaresta pode conectar `2, 3, 4, ...` vértices simultaneamente.

---

## Funções e Hipergrafos

As funções **injetora, sobrejetora e bijetora** aparecem quando relacionamos elementos de dois conjuntos.

Uma função pode ser representada como:

`f : A → B`

Isso significa que cada elemento de `A` é associado a **exatamente um** elemento de `B`.

Em hipergrafos, essas propriedades podem ser utilizadas para descrever relações entre conjuntos, por exemplo, entre um conjunto de elementos e um conjunto de hiperarestas.

### Função Injetora

Uma função é **injetora** quando elementos diferentes do domínio nunca são associados ao mesmo elemento do contradomínio.

Formalmente:

`f(x₁) = f(x₂) ⟹ x₁ = x₂`

Ou, equivalentemente:

`x₁ ≠ x₂ ⟹ f(x₁) ≠ f(x₂)`

Exemplo:

~~~text
A ──→ 1
B ──→ 2
C ──→ 3
~~~

Cada elemento possui uma imagem diferente.

Portanto, a função é **injetora**.

### Função Sobrejetora

Uma função é **sobrejetora** quando **todo elemento do contradomínio é atingido por pelo menos um elemento do domínio**.

Formalmente:

`∀y ∈ B, ∃x ∈ A : f(x) = y`

Exemplo:

~~~text
A ──→ 1
B ──→ 2
C ──→ 2
D ──→ 3
~~~

Todos os elementos do contradomínio `{1,2,3}` foram atingidos.

Portanto, a função é **sobrejetora**.

Observe que dois elementos diferentes podem apontar para o mesmo elemento. Isso é permitido em uma função sobrejetora.

### Função Bijetora

Uma função é **bijetora** quando é simultaneamente:

- **injetora**; e
- **sobrejetora**.

Portanto, cada elemento do domínio está associado a um elemento diferente do contradomínio e **todos os elementos do contradomínio são atingidos**.

Exemplo:

~~~text
A ──→ 1
B ──→ 2
C ──→ 3
~~~

Cada elemento de `{A,B,C}` possui uma imagem diferente e todos os elementos de `{1,2,3}` foram atingidos.

Logo, a função é **bijetora**.

---

## Relação com Hipergrafos

Considere um hipergrafo:

`H = (V,A)`

com:

`V = {v₁,v₂,v₃,v₄}`

e:

`A = {e₁,e₂,e₃}`

onde:

`e₁ = {v₁,v₂}`

`e₂ = {v₂,v₃,v₄}`

`e₃ = {v₁,v₄}`

Podemos representar a relação de **incidência** entre vértices e hiperarestas:

~~~text
          Hiperarestas
             e₁    e₂    e₃
             │     │     │
v₁ ──────────●─────┼─────●
v₂ ──────────●─────●
v₃ ──────────┼─────●
v₄ ──────────┼─────●─────●
~~~

Aqui, um vértice pode estar associado a várias hiperarestas.

Por exemplo:

`v₂ ∈ e₁`

e

`v₂ ∈ e₂`

Portanto, a relação entre **vértices e hiperarestas** não precisa ser uma função simples de `V` para `A`, porque um mesmo vértice pode pertencer a várias hiperarestas.

### Onde entram injetora, sobrejetora e bijetora?

Essas propriedades podem ser analisadas quando definimos uma **função específica** entre conjuntos relacionados ao hipergrafo.

Por exemplo, suponha uma função:

`f : V → A`

que associa **cada vértice a uma hiperaresta**.

Se:

~~~text
v₁ ──→ e₁
v₂ ──→ e₂
v₃ ──→ e₃
~~~

e cada vértice recebe uma hiperaresta diferente, temos uma função **injetora**.

Se, além disso, **todas as hiperarestas** forem atingidas, ela também é **sobrejetora**.

Nesse caso, se `|V| = |A|`, a função pode ser **bijetora**.

> **Importante:** ser injetora, sobrejetora ou bijetora **não é uma característica obrigatória de um hipergrafo**. Essas propriedades pertencem às **funções que podemos definir entre conjuntos relacionados ao hipergrafo**.

### Resumo

| Conceito | Ideia principal |
|---|---|
| **Injetora** | Elementos diferentes do domínio possuem imagens diferentes. |
| **Sobrejetora** | Todo elemento do contradomínio é atingido. |
| **Bijetora** | É simultaneamente injetora e sobrejetora. |
| **Hipergrafo** | Uma hiperaresta pode relacionar vários vértices simultaneamente. |

**Macete para funções:**

> **Injetora:** não repete a imagem.
>
> **Sobrejetora:** não deixa ninguém do contradomínio de fora.
>
> **Bijetora:** não repete e não deixa ninguém de fora.

## Grafos Iguais e Isomorfos

### Grafos Iguais

Dois grafos `G₁ = (V₁, A₁)` e `G₂ = (V₂, A₂)` são **iguais** quando possuem exatamente os mesmos vértices e as mesmas arestas/arcos:

`V₁ = V₂` e `A₁ = A₂`

Ou seja, para serem iguais, os dois grafos precisam ter os **mesmos elementos**, não apenas a mesma estrutura.

### Grafos Isomorfos

Dois grafos são **isomorfos** quando podem possuir vértices e arestas diferentes, mas possuem **a mesma estrutura de conexões**.

Para isso, deve existir uma **bijeção** `f` entre os vértices dos dois grafos que preserve as relações de adjacência.

Em outras palavras:

> Se dois vértices são adjacentes em `G₁`, seus vértices correspondentes também devem ser adjacentes em `G₂`, e vice-versa.

Por exemplo:

~~~text
G₁:          G₂:

A ─── B      1 ─── 2
│     │      │     │
C ─── D      3 ─── 4
~~~

Podemos estabelecer a correspondência:

`f(A) = 1`

`f(B) = 2`

`f(C) = 3`

`f(D) = 4`

As letras e números são diferentes, portanto os grafos **não são iguais**.

Porém, as conexões são preservadas:

- `A` é adjacente a `B` → `1` é adjacente a `2`
- `A` é adjacente a `C` → `1` é adjacente a `3`
- `B` é adjacente a `D` → `2` é adjacente a `4`
- `C` é adjacente a `D` → `3` é adjacente a `4`

Portanto, `G₁` e `G₂` são **isomorfos**.

**Macete:**

> **Igual = mesmos elementos + mesma estrutura.**
>
> **Isomorfo = elementos podem mudar, mas a estrutura permanece.**

## Categorias de Grafos

| Tópico | Descrição |
|---|---|
| **Grafo Homogêneo** | Possui **um único tipo de vértice e um único tipo de aresta**. Todos os vértices representam o mesmo tipo de entidade e todas as arestas representam o mesmo tipo de relação. |
| **Grafo Heterogêneo** | Possui **mais de um tipo de vértice e/ou de aresta**. Os diferentes tipos representam entidades ou relações semanticamente distintas. |
| **Grafo Estático** | Grafo cuja estrutura é considerada **fixa em relação ao tempo**. Os vértices e as arestas não são considerados como mudando ao longo do período analisado. |
| **Grafo Dinâmico** | Grafo cuja estrutura ou propriedades **mudam ao longo do tempo**. Vértices e arestas podem surgir ou desaparecer, e seus atributos, como pesos ou estados, também podem mudar. |

### Exemplo de Grafo Homogêneo

Uma **rede de amizades** em uma rede social:

- Vértices = pessoas
- Arestas = relações de amizade

Todos os vértices representam o mesmo tipo de entidade (**pessoa**) e todas as arestas representam o mesmo tipo de relação (**amizade**).

### Exemplo de Grafo Heterogêneo

Uma **rede acadêmica**:

- Vértices = `{Pesquisadores, Artigos, Instituições}`
- Arestas = `{escreveu, afiliado a, citou}`

Nesse caso, existem diferentes tipos de entidades e diferentes tipos de relações. Por exemplo, um pesquisador **escreve** um artigo, um pesquisador é **afiliado a** uma instituição e um artigo **cita** outro artigo.

## Percurso e Caminho

| Tópico | Descrição |
|---|---|
| **Caminho** | É uma sequência de vértices e arcos em um **grafo orientado**, na qual todos os arcos são percorridos respeitando sua orientação, desde um vértice inicial até um vértice final. |
| **Percurso/Cadeia** | É uma sequência de ligações sucessivamente adjacentes, na qual cada ligação possui uma extremidade em comum com a ligação anterior e outra extremidade em comum com a ligação seguinte. Basicamente, o caminho que não se importa com a orientação do grafo |

### Tipos de Percurso

- **Percurso simples** → não repete **ligações/arestas**.
- **Percurso elementar** → não repete **vértices**, com exceção possível do vértice inicial e final quando o percurso é fechado.
- **Percurso fechado** → começa e termina no **mesmo vértice**.
- **Ciclo** → percurso **fechado** que não repete vértices, exceto o primeiro, que coincide com o último.
- **Corda** → é uma aresta que liga dois vértices **não consecutivos** de um ciclo.
- **Cintura g(G)** de um grafo é o seu comprimento de **menor ciclo**.
- **Circunferência c(G)** de um grafo é o comprimento do **maior ciclo**.

### Percurso Simples

Um percurso é **simples** quando nenhuma ligação é utilizada mais de uma vez.

Exemplo:

~~~text
A ── B ── C ── D ── B
~~~

As ligações percorridas são:

`AB, BC, CD, DB`

Nenhuma ligação foi repetida, portanto o percurso é **simples**.

Porém, o vértice `B` foi visitado duas vezes. Portanto, esse percurso **não é elementar**.

### Percurso Elementar

Um percurso é **elementar** quando nenhum vértice é repetido.

Exemplo:

~~~text
A ── B ── C ── D
~~~

O percurso:

`A → B → C → D`

visita cada vértice apenas uma vez. Portanto, é **elementar**.

A principal ideia é:

> **Simples → não repete ligações.**
>
> **Elementar → não repete vértices.**

### Percurso Fechado

Um percurso é **fechado** quando o vértice inicial é igual ao vértice final.

Exemplo:

~~~text
A ── B
│    │
D ── C
~~~

O percurso:

`A → B → C → D → A`

é **fechado**, pois começa em `A` e termina em `A`.

Um percurso fechado pode ou não ser simples e elementar.

### Ciclo

Um **ciclo** é um percurso **simples e fechado**.

Exemplo:

~~~text
A ── B
│    │
D ── C
~~~

`A → B → C → D → A`

- começa e termina em `A` → é fechado;
- nenhuma aresta é repetida → é simples.

Portanto, é um **ciclo**.

### Corda

Uma **corda** é uma aresta que conecta dois vértices **não consecutivos** de um ciclo.

Exemplo:

~~~text
A ─── B
│ ╲   │
│  ╲  │
D ─── C
~~~

Considere o ciclo:

`A → B → C → D → A`

Nesse ciclo, `A` e `C` **não são consecutivos**.

A aresta:

`A ─ C`

é uma **corda**, pois conecta dois vértices do ciclo que não estavam diretamente ligados pelo ciclo.

> **Macete:**
>
> **Simples** → não repete **arestas**.
>
> **Elementar** → não repete **vértices**.
>
> **Fechado** → começa e termina no **mesmo vértice**.
>
> **Ciclo** → simples + fechado.
>
> **Corda** → ligação entre dois vértices **não consecutivos** de um ciclo.

### Tipos de caminho
 - **Circuito** é um caminho simples e fechado em um grafo orientado.

## Conjunto de sucessores, antecessores e vizinhos

| Tópico | Descrição |
|---|---|
| **Sucessor e Antecessor** | Em um grafo **G = (V, A)**, diz-se que `y ∈ V` é **sucessor** de `x ∈ V` quando existe `(x, y) ∈ A`. Nesse caso, `x` é **antecessor** de `y`. |
| **Conjunto de Sucessores** | O conjunto de sucessores de um vértice `x` é denotado por **N⁺(x)** e corresponde ao conjunto de vértices indicados pelas posições não nulas da **linha** associada a `x` na matriz de adjacência. Basicamente, são todos os vértices que possuem uma seta que **sai de `x` e entra neles**. |
| **Conjunto de Antecessores** | O conjunto de antecessores de um vértice `x` é denotado por **N⁻(x)** e corresponde ao conjunto de vértices indicados pelas posições não nulas da **coluna** associada a `x` na matriz de adjacência. Basicamente, são todos os vértices que possuem uma seta que **sai deles e entra em `x`**. |
| **Vizinho** | Também conhecido como **vértice adjacente**, é todo vértice que participa de uma ligação com `x`, independentemente da orientação da ligação, em um grafo orientado ou não orientado. |
| **Conjunto dos Vizinhos** | O conjunto dos vizinhos de um vértice `x ∈ V` é denotado por **N(x)** e corresponde ao conjunto de todos os vértices vizinhos de `x`. |

## Fecho transitivo direto e indireto, descendente e ascendente

Dizemos que um vértice `y` é **atingível** a partir de um vértice `v` em um grafo `G` quando existe em `G` uma sequência de sucessores que começa em `v` e termina em `y`.

| Tópico | Descrição |
|---|---|
| **Fecho transitivo direto** | Simbolizado por **R⁺(v)**, de um vértice em um grafo orientado `G = (V, A)`, é o conjunto de vértices de `G` **atingíveis a partir de `v`, incluindo `v`**. |
| **Fecho transitivo inverso** | Simbolizado por **R⁻(v)**, de um vértice em um grafo orientado `G = (V, A)`, é o conjunto de vértices de `G` **a partir dos quais `v` é atingível, incluindo `v`**. |

Se `y ∈ R⁺(v)`, então `y` é **descendente** de `v`.  
Se `y ∈ R⁻(v)`, então `y` é **ascendente** de `v`.

## Diferença de semigrau e fecho transitivo direto e inverso

A principal diferença está na **perspectiva utilizada**:

- **Semigrau** → considera os **arcos** que estão diretamente ligados a um vértice.
- **N⁺(x) / N⁻(x)** → considera os **vértices diretamente sucessores ou antecessores** de `x`.
- **R⁺(x) / R⁻(x)** → considera os **vértices atingíveis direta ou indiretamente** a partir de `x` ou que conseguem chegar até `x`.

Considere o grafo:

```text
x → w → z
```

Logo, nesse exemplo, podemos dizer que ω⁺(x) = {(x, w)} enquanto N⁺(x) = {w} e R+(x) = {x, w, z}

## Conexidade - Grafos

| Tópico | Descrição |
|---|---|
| **Conexidade** | É a possibilidade de passagem de um vértice a outro em um grafo através das ligações existentes, representando o **estado de ligação** do grafo. Suas características variam conforme o grafo seja **orientado ou não orientado**, estando especialmente relacionada à atingibilidade em grafos orientados. Nos grafos não orientados, as noções de atingibilidade (relacionada a pares de vértices) e de conexidade (relacionada ao grafo como um todo) são correspondentes. |

Um **grafo não direcionado `G = (V, E)`** é **conexo** se existe um **caminho** entre todo par de vértices de `V`.

Um **grafo direcionado `G = (V, A)`** possui quatro classificações de conexidade: **desconexo**, **simplesmente conexo (s-conexo)**, **semi-fortemente conexo (sf-conexo)** e **fortemente conexo (f-conexo)**.

Um **grafo direcionado `G = (V, A)`** é **desconexo** se existir ao menos um par de vértices que não é unido por uma **cadeia**.

Um **grafo direcionado `G = (V, A)`** é **simplesmente conexo (s-conexo)** quando todo par de vértices é unido por ao menos uma **cadeia**.

Um **grafo direcionado `G = (V, A)`** é **semi-fortemente conexo (sf-conexo)** quando, para todo par de vértices, pelo menos um deles é **atingível a partir do outro**. Portanto, entre os dois vértices, existe um caminho orientado em **pelo menos um dos dois sentidos possíveis**.

Um **grafo direcionado `G = (V, A)`** é **fortemente conexo (f-conexo)** quando, para todo par de vértices, **um é atingível a partir do outro e vice-versa**. Todo grafo fortemente conexo também é semi-fortemente conexo e simplesmente conexo, e todo grafo semi-fortemente conexo é simplesmente conexo.

### Exemplo das cidades

Imagine três cidades:

**A, B e C**

e estradas direcionadas entre elas.

A diferença entre os tipos de conexidade pode ser entendida pensando na possibilidade de **ir de uma cidade para outra**.

#### Simplesmente conexo

No **simplesmente conexo**, considera-se a **cadeia**, portanto a orientação das ligações é ignorada.

Assim, se existir uma ligação entre duas cidades, mesmo que a estrada tenha apenas uma direção, podemos considerar que existe uma conexão entre elas para fins de conexidade simples.

Por exemplo:

**A → B**

Mesmo que a estrada permita apenas ir de `A` para `B`, existe uma ligação entre as cidades. Como estamos considerando uma **cadeia**, podemos tratar essa ligação nos dois sentidos para verificar a conexidade.

Portanto, a ideia é:

> **Simplesmente conexo → consegue relacionar as cidades ignorando a orientação das estradas.**

#### Semi-fortemente conexo

No **semi-fortemente conexo**, a orientação passa a ser considerada, pois estamos trabalhando com **caminhos**.

Por exemplo:

**A → B**

É possível **ir de A para B**, mas não necessariamente é possível **voltar de B para A**.

Ainda assim, o par `A` e `B` satisfaz a condição de conexidade semi-forte, pois **um dos vértices é atingível a partir do outro**.

Portanto:

> **Semi-fortemente conexo → para cada par de cidades, é possível ir de uma para a outra em pelo menos um dos sentidos.**

#### Fortemente conexo

No **fortemente conexo**, também consideramos a orientação e os **caminhos**.

Para duas cidades `A` e `B`, deve ser possível:

**A → B**

e também:

**B → A**

Ou seja, é possível **ir e voltar**, embora o caminho utilizado para voltar não precise ser o mesmo utilizado para ir.

Por exemplo:

**A → B → C**

e

**C → A**

Nesse caso, é possível chegar de `A` até `C` e também de `C` até `A`.

Portanto:

> **Fortemente conexo → para todo par de cidades, é possível ir de uma até a outra e também voltar, sempre respeitando a orientação das estradas.**

### Resumo pelo exemplo das cidades

| Tipo | Ideia |
|---|---|
| **Desconexo** | Existem cidades que não possuem ligação entre si. |
| **Simplesmente conexo** | É possível relacionar todas as cidades **ignorando a direção** das estradas, utilizando cadeias. |
| **Semi-fortemente conexo** | Para cada par de cidades, é possível **ir em pelo menos um dos sentidos**, respeitando a direção das estradas. |
| **Fortemente conexo** | Para cada par de cidades, é possível **ir e voltar**, respeitando a direção das estradas. |

**Macete:**

> **Simplesmente → cadeia → ignora a direção.**
>
> **Semi-fortemente → caminho → consegue ir em pelo menos um sentido.**
>
> **Fortemente → caminho → consegue ir e voltar.**

### Categorias de conexidade

Um grafo orientado pertence a uma das seguintes categorias:

| Categoria | Condição |
|---|---|
| **C3** | É **f-conexo**. |
| **C2** | É **sf-conexo**, mas **não é f-conexo**. |
| **C1** | É **s-conexo**, mas **não é sf-conexo**. |
| **C0** | É **desconexo**. |

Portanto, as categorias formam uma classificação hierárquica

### Relação de equivalência em grafos f-conexos

Em um grafo **f-conexo** `G = (V, A)`, a relação de atingibilidade possui três propriedades:

- **Reflexiva:** todo vértice é atingível de si mesmo.
- **Simétrica:** se `x` é atingível de `y`, então `y` é atingível de `x`.
- **Transitiva:** se `z` é atingível de `y` e `y` é atingível de `x`, então `z` é atingível de `x`.

Como a atingibilidade é **reflexiva, simétrica e transitiva**, dizemos que ela é uma **relação de equivalência**.

### Componentes f-conexas

As **componentes f-conexas** são grupos de vértices nos quais **todos conseguem chegar uns aos outros**, respeitando a direção dos arcos.

Por exemplo, considere o grafo com:

- `A → B`
- `B → C`
- `B → D`
- `C → A`

Podemos perceber que `A`, `B` e `C` conseguem chegar uns aos outros:

- `A → B → C`
- `C → A → B`
- `B → C → A`

Portanto, eles formam uma componente f-conexa:

**S₁ = {A, B, C}**

Já o vértice `D` não consegue voltar para `A`, `B` ou `C`. Assim, ele forma outra componente:

**S₂ = {D}**

Portanto, as componentes f-conexas desse grafo são:

**S = {S₁, S₂}**

onde:

- **S₁ = {A, B, C}**
- **S₂ = {D}**

### Grafo reduzido

Depois de encontrar as componentes f-conexas, podemos **transformar cada componente em um único vértice**. Esse novo grafo é chamado de **grafo reduzido**.

No exemplo:

**S₁ = {A, B, C}**

**S₂ = {D}**

Como existe o arco `B → D` no grafo original, e `B` pertence a `S₁` enquanto `D` pertence a `S₂`, no grafo reduzido teremos:

**S₁ → S₂**

Portanto:

- **Componentes f-conexas:** `S₁ = {A, B, C}` e `S₂ = {D}`
- **Grafo reduzido:** `S₁ → S₂`

A ideia é simplesmente **"juntar" em um único vértice todos os vértices que pertencem à mesma componente f-conexa** e manter as ligações existentes entre as componentes.
## Grau

### Grau de Entrada

Em grafos, utiliza-se grau de entrada **d-(x)** para representar o número de vértices que apontam para um vértice **x**.

### Grau de Saída

Em grafos, utiliza-se grau de saída **d+(x)** para representar o número de vértices que o vértice **x** aponta.

## Ordenação de Grafos

Considere uma situação em que é necessário rearranjar com base nas dependências do grafo para ordenar o mesmo.

### Topológica

Nesta ordenação, pega-se os vértices que não possuem dependência (d-() = 0\grau de entrada = 0) e inicialmente insere em uma fila e altera o valor do grau de entrada antes 0 para -1 e remove da fila. O vértice antes dependente deste vértice tem seu grau de entrada decrementado, sendo estes agora, inseridos dentro da fila e realizando o ciclo novamente.

## Caminho Mínimo

### Algoritmo de Djikstra

### Algoritmo de Bellman-Ford

Procura o melhor *caminho* a partir de uma origem a todos os vértices do grafo.Aceita arcos de valores negativos, porém, encontrará apenas caminhos mínimos se não houver circuitos com valor negativo a partir da origem.

Trabalha com os arcos do grafo, procurando um após o outro em uma dada ordem, para ver se algum deles melhora algum caminho da origem até o vértice de chegada do arco e termina quando uma rodada com todos os arcos não mostrando nenhuma melhora

### Algoritmo de Floyd

Utiliza a determinação de caminhos mínimos unindo todos os pares de vértices, sendo simples, matricial e possui boa performance, podendo ser aplicado a grafos contendo arcos de valor negativo.

Utiliza um vértice base k para a construção de triplas com todos os pares (i,j), i, j pertencentes a V, a serem examinados por desigualdades triangulares (envolvendo três vértices). Sendo os vértices rotulados em ordem numérica de 1 a n, o índuce do vértice base (k) usado em uma iteração corresponderá ao valor do contador de iterações e as desigualdades serão de forma:

$$d^k_{ij} = \min \left( d^{k-1}_{ij}, d^{k-1}_{ik} + d^{k-1}_{kj} \right)$$

As modificações de valor são inscritas na própria matriz de valores vigente D(k-1), que se trasformará em D(k) ao final da iteração.

Para registrar modificações, é utilizado matriz auxiliar que é a matriz de roteamento. Matriz R = [rij] que é uma matriz de índices, inicializada co rij = i; rij = j se vij < infinito; rij = 0 em caso contrário. Elementos da matriz são os rótulos dos vértices.

## Algoritmos em Pseudocódigo:

### Componentes f-conexas de um grafo orientado:

```text
Início FCNEX(s₀ | s₀ ∈ V);  // Dados G = (V, A)

    v ← s₀;
    R⁺(v) ← {v};
    R⁻(v) ← {v};
    W ← ∅;

    // Monta o fecho transitivo direto de v
    enquanto (N⁺[R⁺(v)] − R⁺(v) ≠ ∅) faça

        W ← ∅;

        para cada vértice u ∈ R⁺(v) faça
            para cada vértice m ∈ V faça
                se A[u][m] = 1 então
                    W ← W ∪ {m};
                fim-se
            fim-para
        fim-para

        W ← W − R⁺(v);
        R⁺(v) ← R⁺(v) ∪ W;

    fim-enquanto

    // Monta o fecho transitivo inverso de v
    enquanto (N⁻[R⁻(v)] − R⁻(v) ≠ ∅) faça

        W ← ∅;

        para cada vértice u ∈ R⁻(v) faça
            para cada vértice m ∈ V faça
                se A[m][u] = 1 então
                    W ← W ∪ {m};
                fim-se
            fim-para
        fim-para

        W ← W − R⁻(v);
        R⁻(v) ← R⁻(v) ∪ W;

    fim-enquanto

    // Encontra a componente fortemente conexa
    W ← R⁺(v) ∩ R⁻(v);

    Visita(W);
    V ← V − W;

    Se V ≠ ∅ então
        Escolhe sᵢ ∈ V;
        FCNEX(sᵢ);
    fim-se

Fim.
```

### Busca em Largura (BFS):

```text
Início BFS(n);  // n é o vértice inicial

    Visita(n);
    Marca(n);
    Enfileira(n, F);

    enquanto F ≠ ∅ faça

        n ← Desenfileira(F);

        para cada vértice m ∈ V faça

            se A[n][m] = 1 e m não está marcado então

                Visita(m);
                Marca(m);
                Enfileira(m, F);

            fim-se

        fim-para

    fim-enquanto

Fim.
```

### Busca em Profundidade (DFS):

```text
Início DFS(n);  // n é o vértice inicial

    Visita(n);
    Marca(n);
    Empilha(n, P);

    enquanto P ≠ ∅ faça

        n ← Desempilha(P);

        para cada vértice m ∈ V faça

            se A[n][m] = 1 e m não está marcado então

                Visita(m);
                Marca(m);
                Empilha(m, P);

            fim-se

        fim-para

    fim-enquanto

Fim.
```

### Ordenação Topológica:

```text
Início ORDENACAO_TOPOLOGICA(G = (V, A));

    // G é um grafo direcionado e acíclico (GDA)

    // Inicializa os graus de entrada
    para cada vértice v ∈ V faça

        GE[v] ← 0;

        para cada vértice u ∈ V faça
            GE[v] ← GE[v] + A[u][v];
        fim-para

    fim-para

    // Insere na fila os vértices com grau de entrada 0
    F ← ∅;

    para cada vértice v ∈ V faça
        se GE[v] = 0 então
            Enfileira(v, F);
            GE[v] ← -1;
        fim-se
    fim-para

    // Processa os vértices
    enquanto F ≠ ∅ faça

        n ← Desenfileira(F);

        Visita(n);

        // Atualiza os graus de entrada dos vértices adjacentes
        para cada vértice m ∈ V faça

            se A[n][m] = 1 então

                GE[m] ← GE[m] - 1;

                se GE[m] = 0 então
                    Enfileira(m, F);
                    GE[m] ← -1;
                fim-se

            fim-se

        fim-para

    fim-enquanto

Fim.
```