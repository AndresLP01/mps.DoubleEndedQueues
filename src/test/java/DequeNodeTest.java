import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest<T> {
    DequeNode<T> node,previous,next;
    @BeforeEach
    public void setup(){
        node = new DequeNode(1,next,previous);
    }
    @Test
    public void testReturnItemIfCallGetItem(){
        int valorEsperado = 1;

        T valorObtenido = node.getItem();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void testReturnNextIfCallGetNext(){
        DequeNode<T> valorEsperado = next;

        DequeNode<T> valorObtenido = node.getNext();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void testReturnPreviousIfCallGetPrevious(){
        DequeNode<T> valorEsperado = previous;

        DequeNode<T> valorObtenido = node.getPrevious();

        assertEquals(valorEsperado,valorEsperado);

    }
    @Test
    public void testRerturnFalseIfCallIsFirstNodeAndPreviousIsNotNull(){
        boolean valorEsperado = false;

        previous = new DequeNode(2,node,null);
        node.setPrevious(previous);

        boolean valorObtenido = node.isFirstNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void testReturnTrueIfCallIsFirstNodeAndPreviousIsNull(){
        boolean valorEsperado = true;

        boolean valorObtenido = node.isFirstNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void testReturnFalseIfCallIsLastNodeAndNextIsNotNull(){
        boolean valorEsperado = false;

        next = new DequeNode(3,null,node);
        node.setNext(next);

        boolean valorObtenido = node.isLastNode();

        assertEquals(valorEsperado,valorObtenido);

    }
    @Test
    public void testReturnTrueIfCallIsLastNodeAndNextIsNull(){
        boolean valorEsperado = true;

        boolean valorObtenido = node.isLastNode();

        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    public void testReturnTrueIfPreviousAndNextAreNull(){
        var nodePrev = new DequeNode<>(null,null,null);
        var nodePost = new DequeNode<>(null, null, null);
        node.setNext((DequeNode<T>) nodePost);
        node.setPrevious((DequeNode<T>) nodePrev);

        assertTrue(node.isNotATerminalNode());
    }

    @Test
    public void testSetNextMustChangeNextNode(){
        assertTrue(node.getNext() == null);
        var node1 = new DequeNode<>(null,null,null);
        node.setNext((DequeNode<T>) node1);
        assertTrue(node.getNext()!=null && node.getNext()== node1);
    }
    @Test
    public void testSetItemMustChangeNodeItem(){
        T itemPrev = node.getItem();
        assertEquals(itemPrev, node.getItem());
        T itemPost = null;
        node.setItem(itemPost);
        assertEquals(itemPost,node.getItem());
    }

    @Test
    public void testSetPreviousMustChangePrevious() {
        assertTrue(node.getPrevious() == null);
        var node1 = new DequeNode<>(null, null, null);
        node.setPrevious((DequeNode<T>) node1);
        assertTrue(node.getPrevious() != null && node.getPrevious() == node1);
    }
}
