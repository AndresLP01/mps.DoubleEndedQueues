import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DequeNodeTest<T> {
    DequeNode<T> node,previous,next;
    @BeforeEach
    public void setup(){
        node = new DequeNode(1,next,previous);
    }
    @Test
    public void siLlamoAgetItemDevuelveItem(){
        int valorEsperado = 1;

        T valorObtenido = node.getItem();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void siLlamoAgetNextDevuelveNext(){
        DequeNode<T> valorEsperado = next;

        DequeNode<T> valorObtenido = node.getNext();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void siLlamoAgetPreviousDevuelvePrevious(){
        DequeNode<T> valorEsperado = previous;

        DequeNode<T> valorObtenido = node.getPrevious();

        assertEquals(valorEsperado,valorEsperado);

    }
    @Test
    public void siLlamoAisFirstNodeYPreviousNoEsNullDevuelveFalse(){
        boolean valorEsperado = false;

        previous = new DequeNode(2,node,null);
        node.setPrevious(previous);

        boolean valorObtenido = node.isFirstNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void siLlamoAisFirstNodeYPreviousEsNullDevuelveTrue(){
        boolean valorEsperado = true;

        boolean valorObtenido = node.isFirstNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void siLlamoAisLastNodeYNextNoEsNullDevuelveFalse(){
        boolean valorEsperado = false;

        next = new DequeNode(3,null,node);
        node.setNext(next);

        boolean valorObtenido = node.isLastNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void siLlamoAisLastNodeYNextEsNullDevuelveTrue(){
        boolean valorEsperado = true;

        boolean valorObtenido = node.isLastNode();

        assertEquals(valorEsperado,valorObtenido);

    }
}
