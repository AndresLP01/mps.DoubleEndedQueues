public class DoubleLinkedListQueue implements DoubleEndedQueue{

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
        first = first.getNext(); //TODO Si la lista es de 1, first.getNext apunta a null, en last pasa lo mismo.
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
}
