import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexOperationsTest {
    DoubleLinkedListQueue empty, list1, list2;


    @BeforeEach
    public void startUp(){
        this.empty = new DoubleLinkedListQueue<>();
        this.list1 = new DoubleLinkedListQueue<>();
        this.list2 = new DoubleLinkedListQueue<>();

        list1.append(new DequeNode(5, null, null));
        list2.append(new DequeNode(5, null, null));
        list2.append(new DequeNode(1, null, null));
        list2.append(new DequeNode(6, null, null));
        list2.append(new DequeNode(9, null, null));
        list2.append(new DequeNode(12, null, null));
    }

    @AfterEach
    public void finish(){
        this.empty = null;
        this.list1 = null;
        this.list2 = null;
    }


    /*
        Eliminar un elemento de una lista vacia
    */

    @Test
    public void testDeleteReturnExceptionWhenDeletingElementFromEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.delete(new DequeNode(5, null, null)));
    }

    /*
        Intentar eliminar un elemento que no esta en la lista
    */
    @Test
    public void testDeleteReturnExceptionWhenTryingToDeleteELementThatIsNotInTheList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.delete(new DequeNode(9, null, null)));
    }

    /*
        Eliminar un elemento dentro de una lista con 5 elementos
     */

    @Test
    public void testDeleteReturnTrueWhenDeletingElementFromList(){
        int expectedValue = list2.size() - 1;
        list2.delete(list2.find(6));
        int obtainedValue = list2.size();

        assertTrue(list2.find(6)==null);
    }

    /*
        Eliminar el primer elemento de una lista no vacia
     */

    @Test
    public void testDeleteFirstInAList(){
        DequeNode second = list2.peekFirst().getNext();
        list2.delete(list2.peekFirst());

        assertTrue(second.equals(list2.peekFirst()));
    }
}
