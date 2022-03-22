import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexOperationsTest {
    DoubleLinkedListQueue empty, list1, list2, duplicated;


    @BeforeEach
    public void startUp(){
        this.empty = new DoubleLinkedListQueue<>();
        this.list1 = new DoubleLinkedListQueue<>();
        this.list2 = new DoubleLinkedListQueue<>();
        this.duplicated = new DoubleLinkedListQueue<>();

        list1.append(new DequeNode(5, null, null));
        list2.append(new DequeNode(5, null, null));
        list2.append(new DequeNode(1, null, null));
        list2.append(new DequeNode(6, null, null));
        list2.append(new DequeNode(9, null, null));
        list2.append(new DequeNode(12, null, null));

        duplicated.append(new DequeNode(2,null,null));
        duplicated.append(new DequeNode(2,null,null));
    }

    @AfterEach
    public void finish(){
        this.empty = null;
        this.list1 = null;
        this.list2 = null;
    }

    /*
        -------- getAt Testing --------
     */

    /*
        Scenario: getAt con un índice mayor que el tamaño
     */

    @Test
    public void shouldReturnErrorIfIndexOutOfBounds(){
        assertThrows(DoubleLinkedListQueueException.class, ()->empty.getAt(1));
        assertThrows(DoubleLinkedListQueueException.class, ()->list1.getAt(1));
        assertThrows(DoubleLinkedListQueueException.class, ()->list2.getAt(list1.size()+1));
    }
    /*
        Scenario: getAt recibe un indice negativo
     */
    @Test
    public void shouldReturnErrorIfIndexIsNegative(){
        assertThrows(DoubleLinkedListQueueException.class, ()->empty.getAt(-1));
        assertThrows(DoubleLinkedListQueueException.class, ()->list1.getAt(-5));
        assertThrows(DoubleLinkedListQueueException.class, ()->list2.getAt(-20));
    }
    /*
        Scenario: getAt devuelve un item null
     */
    @Test
    public void shouldReturnNullIfElementAtIndexIsNull(){
        var node = new DequeNode<>(null,null,null);
        list1.append(node); //Index at 1
        assertEquals(null,list1.getAt(1));
    }

    /*
        Scenario: getAt en una lista vacía
     */

    @Test
    public void shouldReturnErrorIfGetAtIfCalledInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, ()->empty.getAt(1));
    }
    /*
        Scenario: getAt en una lista no vacía devuelve el elemento correspondiente
     */


    @Test
    public void shouldReturnCorrectElementAtIndex(){
        int expectedValue = 5;
        assertEquals(expectedValue, list1.getAt(0));
    }

    /*
        Scenario: find a una lista vacía
     */

    @Test
    public void shouldReturnErrorIfFindIsCalledInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, ()->empty.find(null));
    }

    /*
        Scenario: find de un elemento que no está en la lista
     */

    @Test
    public void shouldReturnErrorIfElementNotInList(){
        assertThrows(DoubleLinkedListQueueException.class, ()-> list1.find(90));
    }

    /*
        Scenario: find de un elemento que está en la lista
     */
    @Test
    public void shouldReturnCorrectNode(){ //IDK
        var expectedNode1 = new DequeNode<>(5,null,null);
        assertEquals(expectedNode1, list1.find(5));

        var obtainedNode = list2.find(9);

        var expectedNode2 = new DequeNode<>(9,DequeNode.class,DequeNode.class);

        assertEquals(expectedNode2,obtainedNode);
    }

    /*
        Scenario: find de un elemento repetido en la lista
     */
    @Test
    public void shouldReturnOneNodeIfElementIfDuplicated(){
        var auxNext = new DequeNode<>(2,null,null);
        var expectedNode = new DequeNode<>(2, auxNext,null);
    }
}
