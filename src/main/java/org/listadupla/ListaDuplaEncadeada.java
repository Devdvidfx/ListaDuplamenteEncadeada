package org.listadupla;

public class ListaDuplaEncadeada<T> { //classe ListaDuplamenteEncadeada que recebe um tipo genérico T.

    private NoDuplo<T> primeiroNo; //Referência para o primeiro nó da lista.
    private NoDuplo<T> ultimoNo; //Referência para o último nó da lista.
    private int tamanhoLista; //Variável que armazena o tamanho da lista.

    public ListaDuplaEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){ //Método para obter um elemento da lista pelo índice.
        return this.getNo(index).getConteudo(); //Retorna o conteúdo do nó no índice especificado.
    }

    public void add(T elemento) {//Método para adicionar um elemento ao final da lista.
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);//Define que o próximo nó após o novo nó é nulo.
        novoNo.setNoPrevio(ultimoNo);//Define que o nó anterior ao novo nó é o último nó atual.

        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);//Define que o próximo nó após o último nó é o novo nó.
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento){//Método para adicionar um elemento em um índice específico da lista.
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if(index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int index){ // Método para remover um elemento em um índice específico da lista.
        if(index == 0){ // Se o índice for 0...
            primeiroNo = primeiroNo.getNoProximo(); // ...define o primeiro nó como o próximo nó após o primeiro nó.
            if(primeiroNo != null){ // Se o primeiro nó não for nulo...
                primeiroNo.setNoPrevio(null); // ...define que o nó anterior ao primeiro nó é nulo.
            }
        }else {
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar != ultimoNo){ // Se o nó atual não for o último nó...
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            }else{
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
    }

    public NoDuplo<T> getNo(int index) throws IndexOutOfBoundsException {//Método para obter um nó da lista pelo índice.
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; (i < index) && (noAuxiliar != null); i++){//Percorre a lista até o índice especificado.
            noAuxiliar = noAuxiliar.getNoProximo();//Define o nó auxiliar como o próximo nó.
        }
        return noAuxiliar;
    }

    public int size(){// Método para obter o tamanho da lista.
        return this.tamanhoLista;
    }

    @Override
    public String toString() {//Método para converter a lista para uma string.
        StringBuilder strRetorno = new StringBuilder();//Inicializa a string de retorno.

        NoDuplo<T> noAuxiliar = primeiroNo;//Inicializa o nó auxiliar como o primeiro nó.
        for(int i = 0; i < size(); i++){ // Percorre a lista.
            strRetorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]--->");//Adiciona o conteúdo do nó auxiliar à string de retorno.
            noAuxiliar = noAuxiliar.getNoProximo();//Define o nó auxiliar como o próximo nó.
        }
        strRetorno.append("null");//Adiciona "null" ao final da string de retorno.
        return strRetorno.toString();
    }
}
