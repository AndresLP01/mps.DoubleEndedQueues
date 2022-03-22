import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;


class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue list;
    DoubleLinkedListQueue empty, list1, list2, duplicated;


    @BeforeEach
    public void setup(){
        list = new DoubleLinkedListQueue();

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
    }

    @AfterEach
    public void finish(){
        list = null;
        this.empty = null;
        this.list1 = null;
        this.list2 = null;
    }

    @Test
    public void testReturnExceptionWhenPeekFirstInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> list.peekFirst());
    }

    @Test
    public void testReturnExceptionWhenDeleteFirstInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> list.deleteFirst());
    }
    @Test
    public void testReturnExceptionWhenDeleteLastInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> list.deleteLast());
    }

    @Test
    public void testReturnSizeEqualToListSize(){
        list.append(new DequeNode(5, null, null));
        list.append(new DequeNode(3, null, null));

        int expectedValue = 2;
        int obtainedValue = list.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testReturnSizeBiggerThanThePreviousOne(){
        list.append(new DequeNode(3, null, null));
        int previousValue = list.size();
        list.append(new DequeNode(6, null, null));
        int actualValue = list.size();

        assertTrue(previousValue < actualValue);
    }


    @Test
    public void testReturnSizeEqualsToZeroWhenDeletingLastElement(){
        list.append(new DequeNode(9, null, null));
        list.deleteFirst();
        int expectedValue = 0;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }


    @Test
    public void testDeleteFirstEqualsToLastAfterDeletingOneNodeFromAListWithTwoElements(){
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));
        list.deleteFirst();
        assertEquals(list.peekFirst(), list.peekLast());
    }

    @Test
    public void testPreviousFromLastBecomeLastAfterDeletingLast(){
        list.append(new DequeNode(6, null, null));
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        DequeNode x = list.peekLast();
        DequeNode prev = x.getPrevious();

        list.deleteLast();
        assertEquals(prev, list.peekLast());
    }

    @Test
    public void testDeleteFirstReturnNextFromFirstBecomeFirstAfterDeletingHim(){
        list.append(new DequeNode(6, null, null));
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        DequeNode x = list.peekFirst();
        DequeNode next = x.getNext();

        list.deleteFirst();
        assertEquals(next, list.peekFirst());
    }

    @Test
    public void testAppendLeftReturnNodeIsTheFirstWhenWeAddedIt(){
        list.append(new DequeNode(6, null, null));
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        DequeNode x = list.peekFirst();

        list.appendLeft(new DequeNode(3, null, null));

        assertEquals(x.getPrevious(),list.peekFirst());
    }


    @Test
    public void testPeekLastReturnNullWhenCallingNextFromLastNode(){
        //Devuelve null cuando llamamos al next del ultimo nodo
        list.append(new DequeNode(6, null, null));
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        assertEquals(list.peekLast().getNext(), null);
    }

    @Test
    public void testPeekFirstReturnNullWhenCallingPreviousFromFirstNode(){
        list.append(new DequeNode(6, null, null));
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        assertEquals(list.peekFirst().getPrevious(), null);
    }

    @Test
    public void testSizeReturnValueDifferentFromZeroToAListNotEmpty(){
        list.append(new DequeNode(8, null, null));
        list.append(new DequeNode(3, null, null));
        list.append(new DequeNode(5, null, null));

        int obtainedValue = list.size();
        int notExpectedValue = 0;
        assertNotEquals(0, obtainedValue);
    }


    @Test
    public void testSizeReturnValueOneWhenFirstEqualsLast(){
        list.append(new DequeNode(1, null, null));
        int expectedValue = 1;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testSizeReturZeroWhenEmptyList(){
        int expectedValue = 0;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }


    /*
        -------- getAt Testing --------
     */

    /*
        Scenario: getAt con un índice mayor que el tamaño
     */

    @Test
    public void shouldReturnErrorIfIndexOutOfBounds() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.getAt(1));
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.getAt(1));
        assertThrows(DoubleLinkedListQueueException.class, () -> list2.getAt(list1.size() + 1));
    }

    /*
        Scenario: getAt recibe un indice negativo
     */
    @Test
    public void shouldReturnErrorIfIndexIsNegative() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.getAt(-1));
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.getAt(-5));
        assertThrows(DoubleLinkedListQueueException.class, () -> list2.getAt(-20));
    }

    /*
        Scenario: getAt devuelve un item null
     */
    @Test
    public void shouldReturnNullIfElementAtIndexIsNull() {
        var node = new DequeNode<>(null, null, null);
        list1.append(node); //Index at 1
        assertEquals(null, list1.getAt(1));
    }

    /*
        Scenario: getAt en una lista vacía
     */

    @Test
    public void shouldReturnErrorIfGetAtIfCalledInEmptyList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.getAt(1));
    }
    /*
        Scenario: getAt en una lista no vacía devuelve el elemento correspondiente
     */


    @Test
    public void shouldReturnCorrectElementAtIndex() {
        assertEquals(5, list1.getAt(0).getItem());
        assertEquals(null, list1.getAt(0).getPrevious());
        assertEquals(null, list1.getAt(0).getNext());

    }

    /*
        Scenario: find a una lista vacía
     */

    @Test
    public void shouldReturnErrorIfFindIsCalledInEmptyList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.find(null));
    }

    /*
        Scenario: find de un elemento que no está en la lista
     */

    @Test
    public void shouldReturnErrorIfElementNotInList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.find(90));
    }

    /*
        Scenario: find de un elemento que está en la lista
     */
    @Test
    public void shouldReturnCorrectNode() { //IDK
        var expectedNode1 = new DequeNode<>(5, null, null);
        assertEquals(expectedNode1, list1.find(5));

        var obtainedNode = list2.find(9);
    }

    /*
        Scenario: find de un elemento repetido en la lista
     */
    @Test
    public void shouldReturnOneNodeIfElementIfDuplicated() {
        var auxNext = new DequeNode<>(2, null, null);
        var expectedNode = new DequeNode<>(2, auxNext, null);
    }
    /*
        Eliminar un elemento de una lista vacia
    */

    @Test
    public void testDeleteReturnExceptionWhenDeletingElementFromEmptyList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.delete(new DequeNode(5, null, null)));
    }

    /*
        Intentar eliminar un elemento que no esta en la lista
    */
    @Test
    public void testDeleteReturnExceptionWhenTryingToDeleteELementThatIsNotInTheList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.delete(new DequeNode(9, null, null)));
    }

    /*
        Eliminar un elemento dentro de una lista con 5 elementos
     */

    @Test
    public void testDeleteReturnTrueWhenDeletingElementFromList() {
        int expectedValue = list2.size() - 1;
        list2.delete(list2.find(6));
        int obtainedValue = list2.size();

        assertTrue(list2.find(6) == null);
    }

    /*
        Eliminar el primer elemento de una lista no vacia
     */

    @Test
    public void testDeleteFirstInAList() {
        DequeNode second = list2.peekFirst().getNext();
        list2.delete(list2.peekFirst());

        assertTrue(second.equals(list2.peekFirst()));

    }
}