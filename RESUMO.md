# Resumo da Matéria — Teoria dos Grafos - Parei no slide 44 da aula 2

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

## Conceitos iniciais de Grafos:

| Tópico | Descrição |
|---|---|
| **Grafo Completo** | É completo se existir uma ligação entre **cada par de vértices distintos** (sem considerar laços). Todas as estruturas desse tipo com a mesma ordem são isomorfas. Grafos completos não-orientados são conhecidos como **cliques** e recebem a notação **Kₙ**. |
| **Conjunto das Partes** | É o conjunto formado por **todos os subconjuntos** de um conjunto X, denotado por **P(X) ou 2ˣ**. Exemplo: X = {x₁, x₂, x₃, x₄}. Então P(X) contém todos os subconjuntos de X, desde o conjunto vazio até {x₁, x₂, x₃, x₄}. Se X possui n elementos, então P(X) possui **2ⁿ subconjuntos**. Os subconjuntos que possuem exatamente k elementos podem ser contados por **Combinação: C(n,k) = n! / (k!(n-k)!)**. |
| **Potência Cartesiana** | **Xᵏ** é o conjunto de todas as **k-uplas ordenadas** formadas pelos elementos de X, permitindo repetição. Exemplo: se X = {x₁, x₂, x₃, x₄}, então X² = {(x₁,x₁), (x₁,x₂), (x₁,x₃), (x₁,x₄), (x₂,x₁), ..., (x₄,x₄)}. Como a ordem importa, **(x₁,x₂) ≠ (x₂,x₁)**. Se X possui n elementos, então **|Xᵏ| = nᵏ**. |

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

CONTINUAR A PARTIR DAQUI
-------------------------

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


## Análise de Grafos

| Tópico | Descrição |
|---|---|
| **Caminho** | É uma cadeia de um grafo orientado o qual a orientação dos arcos é sempre a mesma a partir do vértice inicial e consegue alcançar até o vértice final. No caso não orientado, percurso = caminho. |
| **Percurso/Cadeia** | É uma sequência de ligações sucessivamente adjacentes, onde cada ligação possui uma extremidade adjacente à ligação anterior e outra extremidade adjacente à ligação subsequente. |

## Conexidade - Grafos

| Tópico | Descrição |
|---|---|
| **Conexidade** | possibilidade de passagem de um vértice a outra em um grafo através das ligações existentes, traduzindo o **estado de ligação** e adquirindo aspectos diferentes conforme o grafo sendo **orientado ou não**, voltado para atingibilidade especialmente em **grafos orientados**. Nos grafos não orientados as noções de atingibilidade (relacionada a pares de vértices) e de conexidade (relacionado a grafos como um todo) são correspondentes. |

Um **grafo não-direcionado G = (V, E)** é **conexo** se existe um caminho G entre todo o part de vértices de V.

Um **grafo direcionado G = (V, E)**, são definidos quatro tipos de conexidade: **desconexo**, simplesmente conexo (**s-conexo**), semi-fortemente conexo (**sf-conexo**) e fortemente conexo (**f-conexo**).

Um **grafo direcionado G = (V, A)** é **desconexo** se nele existir ao menos um part de vértices não unidos por uma cadeia.

Um **grafo direcionado G = (V, A)** é **simplesmente conexo (s-conexo)** no qual todo par de vértices é unido por ao menos uma cadeia.

Um **grafo direcionado G = (V, A)** é **semi-fortemente conexo (sf-conexo)** quando, em todo o part de vértices ao menos um deles é atingível a partir do outro (logo, entre eles, existe em ao menos um dos dois sentidos possíveis)

Um **grafo direcionado G = (V, A)** é **fortemente conexo (f-conexo)** é sempre também sf-conexo e s-conexo, e que tdo grafo sf-conexo é s conexo. Para evitar dúvidas, utiliza-se classificação em **categorias de conexidade**.

Diz-se então que um grafo orientado pertence a categoria:
 - C3, se é f-conexo
 - C2, se é sf-conexo e não é f-conexo
 - C1, se é s-conexo e não é sf-conexo
 - C0, se é desconexo

Em um grafo f-conexo G - (V, A):
 - Todo vértice é atingível de si mesmo: relação reflexiva
 - Se x é atingível de y, então y é atingível de x: relação simétrica
 - Se z é atingível de y e y é atingível de x, então z é atingível de x: relação transitiva.

A atingibilidade é uma relação reflexiva, simétrica e transitiva dizemos então que é uma **relação de equivalência**

### Grafo direcionado - Componentes f-conexas

Sobre o conjunto de vértices de um grafo orientado qualquer G = (V, A) definimos uma **partição S**:

Sejam os subgrafos correspondentes aos $$\mid S_i$$ como sendo partição contendo componentes f-conexas.

$$
S = \left\{ S_i \mid S_i \subset V,\; S_i \cap S_j = \varnothing,\; i,j=1,\ldots,r,\; i\neq j \right\}
$$

Sendo este, do conjuento de vértices **V**.

Defini-se **grafo reduzido** um Grafo G = (V, A), obtido de um grafo G (orientado ou não) através de uma sequência de contrações de vértices, feitas segundo um critério pré-definido.

Podemos reduzir um grafo orientado G por meio de suas componentes f-conexas.

Um grafo orientado G = (V,A) originará um grafo reduzido Gr = (S, W), onde S é a partição de Gr, em componentes f-conexas e W sendo:

$$
W = \left\{ (S_i, S_j) \mid \exists (x,y),\; x \in S_i,\; y \in S_j \right\}
$$

Sendo W um conjunto dos arcos que unem essas componentes.

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
