# Algoritmo de ordenação bubble sort

![alt text](https://coffops.com/wp-content/uploads/2021/02/bubble_sort_post.png)

<!-- wp:paragraph -->
<p>O algoritmo de ordenação bubble sort, ou ordenação por flutuação, é um dos mais simples algoritmos de ordenação. A ideia é percorrer o vector diversas vezes, e a cada passagem fazer flutuar para o topo o maior elemento da sequência.</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>O algoritmo percorre a lista de itens solicitáveis ​​do início ao fim, verifica a ordem dos elementos um a um e altera a posição, se necessário. Percorra a lista até que nenhum elemento do parágrafo anterior tenha sido movido.</p>
<!-- /wp:paragraph -->

![alt text](https://coffops.com/wp-content/uploads/2021/02/bubble_sort.gif)

## Vamos ao algoritmo bubble sort em Java

    public int[] bubbleSort(int[] list){

        boolean sortedList = false;
        while(!sortedList){
            sortedList = true;
            for(int i = 0; (i < list.length && i+1 < list.length); i++){
                if(list[i] > list[i+1]){
                    int temp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = temp;
                    sortedList = false;
                }
            }
        }
    
        return list;
    }

# Confira o post completo em:
https://coffops.com/algoritmo-de-ordenacao-bubble-sort

## Autor

From **[COFFOPS](https://coffops.com/)** By **[Luiz Antonio Rech](https://github.com/aluizrech)**

---

