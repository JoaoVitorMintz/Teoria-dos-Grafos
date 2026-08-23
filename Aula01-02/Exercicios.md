# Enunciado exercício 1:
Você utilizaria uma lista de adjacência ou uma matriz de adjacência
em cada um dos casos abaixo? Justifique matematicamente sua
escolha.

a) O grafo tem 10.000 vértices e 1.000.000.000 arestas, e é importante
usar tão pouco espaço quanto possível.
b) O grafo tem 100.000.000 vértices e 1000 arestas, e é importante
usar tão pouco espaço quanto possível.
Obs.: Considere que a matriz armazena um inteiro que ocupa 4 bytes. A
Lista armazena a informação em 2 bytes e um ponteiro em 2 bytes.

# Minha resposta:
Acredito que, no a, o ideal seria uma matriz de adjacencia pois a matriz, que teria tamanho 10000x10000 teria suas células mais bem aproveitadas com todas elas sendo ocupadas (estou considerando que não é 1.000.000.000 mas sim 100.000.000, acho que prof colocou errado) enquanto o b, seria melhor uma lista já que uma matriz de adjacencia teria tamanho muito grande mas pouca célula/espaço ocupado, sendo apenas 0.0000000000001 das células aproveitadas.

# Análise da IA:


Sua intuição está correta! Vamos justificar matematicamente com os cálculos de espaço:

## Análise de Espaço

### a) 10.000 vértices, 1.000.000.000 arestas

**Matriz de adjacência:**
- Espaço: $V^2 \times 4 = 10.000^2 \times 4 = 400.000.000$ bytes ≈ **381 MB**

**Lista de adjacência:**
- Espaço: $E \times (2 + 2) = 1.000.000.000 \times 4 = 4.000.000.000$ bytes ≈ **3,7 GB** (grafo direcionado)
- Ou **7,4 GB** se for não direcionado (cada aresta aparece 2×)

**Veredito: Matriz de adjacência** ✅

A matriz usa **10× menos espaço** que a lista neste caso. Isso ocorre porque o grafo é **denso**: com 10.000 vértices, o máximo de arestas em um grafo direcionado é $V(V-1) = 99.990.000$. Se temos 1 bilhão de arestas, isso é matematicamente impossível para um grafo simples — ou é um **multigrafo** (múltiplas arestas entre mesmos vértices) ou há erro no enunciado.

Se considerarmos **100.000.000 arestas** (seu palpite de erro do professor):
- Lista: 400.000.000 bytes ≈ **381 MB** (mesmo espaço da matriz!)
- Nesse caso, ambas são equivalentes, mas a matriz ainda é válida pela simplicidade.

O **ponto de equilíbrio** é quando $E \approx V^2$. Aqui, $V^2 = 100.000.000$, então:
- Se $E > V^2$: matriz é melhor
- Se $E < V^2$: lista é melhor

***

### b) 100.000.000 vértices, 1.000 arestas

**Matriz de adjacência:**
- Espaço: $V^2 \times 4 = (10^8)^2 \times 4 = 4 \times 10^{16}$ bytes ≈ **36.380 TB** 🤯

**Lista de adjacência:**
- Espaço: $E \times (2 + 2) = 1.000 \times 4 = 4.000$ bytes ≈ **4 KB** (direcionado)
- Ou **8 KB** se for não direcionado

**Veredito: Lista de adjacência** ✅

A lista usa **quatro quatrilhões de vezes menos espaço**! Este é um grafo **extremamente esparso**: a densidade é:

$$\text{densidade} = \frac{E}{V^2} = \frac{1.000}{10^{16}} = 10^{-13} = 0,00000000001\%$$

Ou seja, apenas **1 em cada 10 trilhões** de células da matriz seria utilizada — desperdício massivo.

***

## Regra Geral

A escolha depende da **densidade do grafo** ($d = E/V^2$):

| Estrutura | Melhor quando | Complexidade espacial |
|-----------|---------------|----------------------|
| **Matriz** | Grafo denso ($E \approx V^2$) | $O(V^2)$ |
| **Lista** | Grafo esparso ($E \ll V^2$) | $O(V + E)$ |

O **ponto de equilíbrio** teórico ocorre quando $E \approx V^2$, considerando os tamanhos dados (4 bytes por célula em ambos os casos).

***

## Sobre o item (a)

Você está certo em suspeitar do enunciado! Um grafo simples direcionado com 10.000 vértices pode ter no máximo **~100 milhões** de arestas, não 1 bilhão. Se for 100 milhões, matriz e lista empatam (~381 MB cada), mas a matriz ainda faz sentido pela constante menor e acesso $O(1)$.