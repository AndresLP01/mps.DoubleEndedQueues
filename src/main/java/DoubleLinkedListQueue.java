import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue{

    private DequeNode first;
    private DequeNode last;
    private int size;

    public DoubleLinkedListQueue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private void appendIfEmpty(DequeNode node){
        this.first = node;
        this.last = node;
    }

    @Override
    public void append(DequeNode node) {
        if (size()==0)
            appendIfEmpty(node);
        else{
            last.setNext(node);
            node.setPrevious(last);
            node.setNext(null);
            last = node;
        }
        size++;
    }

    @Override
    public void appendLeft(DequeNode node) {
        if (size()==0)
            appendIfEmpty(node);
        else{
            first.setPrevious(node);
            node.setNext(first);
            first = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size()==0)
            throw new DoubleLinkedListQueueException("ERROR: No se puede eliminar de una lista vacia");
        first = first.getNext();
        first.setPrevious(null);
        size--;
    }

    @Override
    public void deleteLast() {
        if (size()==0)
            throw new DoubleLinkedListQueueException("ERROR: No se puede eliminar de una lista vacia");
        last = last.getPrevious();
        last.setNext(null);
        size--;
    }

    @Override
    public DequeNode peekFirst() {
        if (size()==0)
            throw new DoubleLinkedListQueueException("ERROR: No se puede seleccionar el primero de una lista vacia");
        return first;
    }

    @Override
    public DequeNode peekLast() {
        if (size()==0)
            throw new DoubleLinkedListQueueException("ERROR: No se puede seleccionar el ultimo de una lista vacia");
        return last;
    }

    @Override
    public int size() {
       return size;
    }

    public DequeNode<T> getAt(int position){
        DequeNode<T> res;
        int cont = 0;
        if(position == 0){
            res = first;
        }else{
            res = first.getNext();
            while(res != null && cont != position) {
                res = res.getNext();
                cont++;
            }
            if(res == null){
                throw new DoubleLinkedListQueueException("ERROR: El objeto no esta en la lista");
            }
        }
        return res;
    }
    public DequeNode<T> find (T item){
        DequeNode<T> res = first;
        if(res == null){
            throw new DoubleLinkedListQueueException("ERROR: La lista esta vacia");
        }else {
            if (last.getItem() == item) {
                res = last;
            } else {
                res = res.getNext();
                while (res != null && !res.getItem().equals(item)) {
                    res = res.getNext();
                }
                if (res == null) {
                    throw new DoubleLinkedListQueueException("ERROR: El nodo con ese item no esta en la lista");
                }
            }
        }
        return res;
    }
    public void delete(DequeNode<T> node){
        DequeNode<T> ant,curr,sig;
        if(first == null){
            throw new DoubleLinkedListQueueException("ERROR: La lista esta vacia");
        }else {
            if (first.equals(node) && size == 1) {
                first = null;
                last = null;
                size--;
            } else if(first.equals(node)) {
                    first =  first.getNext();
                    first.setPrevious(null);
                }else if(last.equals(node)) {
                    last = last.getPrevious();
                    last.setNext(null);

                 }else{
                    ant = first;
                    curr = first.getNext();
                    while (curr != null && ant != null && !curr.equals(node)) {
                        ant = curr;
                        curr = curr.getNext();
                    }
                    if (curr != null && curr.equals(node)) {
                        sig = curr.getNext();
                        curr = null;
                        ant.setNext(sig);
                        size--;
                    } else {
                        throw new DoubleLinkedListQueueException("ERROR: El nodo no esta en la lista");
                    }
                }
            }
    }
    public void sort(Comparator<?> comparator) {
        DoubleLinkedListQueue<T> aux = new DoubleLinkedListQueue<T>();

        DequeNode min = getMin(this, (Comparator<Object>) comparator);
        while(this.size != 0){
            aux.append(min);
            this.delete(min);
            min = getMin(this,(Comparator<Object>) comparator);
        }
        this.first = aux.first;
        this.last = aux.last;
        this.size = aux.size;
    }
    private DequeNode<T> getMin(DoubleLinkedListQueue list, Comparator<Object> comparator){
        DequeNode aux = list.first.getNext();
        DequeNode res = list.first;
        if(res == null){
            throw new DoubleLinkedListQueueException("ERROR: La lista esta vacia");
        }else{
            while(aux != null && res != null){
                if(comparator.compare(aux.getItem(),res.getItem()) < 0){
                    res = aux;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return res;
    }
}
