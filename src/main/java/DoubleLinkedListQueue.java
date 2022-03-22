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
        if (size() == 1){
            first = null;
            last  = null;
        }else{
            first = first.getNext();
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (size() == 0)
            throw new DoubleLinkedListQueueException("ERROR: No se puede eliminar de una lista vacia");
        if (size() == 1){
            last  = null;
            first = null;
        }else {
            last = last.getPrevious();
            last.setNext(null);
        }
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
            }
            if(res == null){
                throw new DoubleLinkedListQueueException("El objeto no esta en la lista");
            }
        }
        return res;
    }
    public DequeNode<T> find (T item){
        DequeNode<T> res;
        if(first.getItem() == item){
            res = first;
        }else if(last.getItem() == item){
            res = last;
        }else{
            res = first.getNext();
            while(res.getItem() != item && res != null){
                res = res.getNext();
            }
            if(res == null){
                throw new DoubleLinkedListQueueException("El nodo con ese item no esta en la lista");
            }
        }
        return res;
    }
    public void delete(DequeNode<T> node){
        DequeNode<T> ant,curr,sig;
        if(first.equals(node)){
            curr = first.getNext();
            first = curr;
        }else{
            ant = first;
            curr = first.getNext();
            while(!curr.equals(node) && curr != null && ant != null){
                ant = curr;
                curr = curr.getNext();
            }
            if(curr.equals(node)){
                sig = curr.getNext();
                curr = null;
                ant.setNext(sig);
            }else{
                throw new DoubleLinkedListQueueException("El nodo no esta en la lista");
            }
        }
    }
    public void sort(Comparator<?> comparator){

    }
}
