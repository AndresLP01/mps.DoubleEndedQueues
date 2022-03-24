import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue list;
    private DoubleLinkedListQueue<Object> empty;
    private DoubleLinkedListQueue list1;
    private DoubleLinkedListQueue list2;
    private DoubleLinkedListQueue duplicated;

    @BeforeEach
    public void setup(){
        list = new DoubleLinkedListQueue();

        this.empty = new DoubleLinkedListQueue<>();
        this.list1 = new DoubleLinkedListQueue<>();
        this.list2 = new DoubleLinkedListQueue<>();
        this.duplicated = new DoubleLinkedListQueue<>();

        list1.append(new DequeNode<>(30, null, null));
        list2.append(new DequeNode<>(20, null, null));
        list2.append(new DequeNode<>(1, null, null));
        list2.append(new DequeNode<>(8, null, null));
        list2.append(new DequeNode<>(6, null, null));
        list2.append(new DequeNode<>(12, null, null));
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
    public void testShouldReturnNullWhenDeletingLastInAList(){
        list1.deleteLast();
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.peekFirst());
    }

    @Test
    public void testShouldReturnFirstWhenAppendLeft(){
        DequeNode<Integer> x = new DequeNode<>(5, null, null);
        empty.appendLeft(x);
        assertEquals(x, empty.peekFirst());
    }

    @Test
    public void testShouldReturnNullWhenDeletingLastInAList2(){
        list1.deleteLast();
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.peekLast());
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
        list.append(new DequeNode<>(5, null, null));
        list.append(new DequeNode<>(3, null, null));

        int expectedValue = 2;
        int obtainedValue = list.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testReturnSizeBiggerThanThePreviousOne(){
        list.append(new DequeNode<>(3, null, null));
        int previousValue = list.size();
        list.append(new DequeNode<>(6, null, null));
        int actualValue = list.size();

        assertTrue(previousValue < actualValue);
    }

    @Test
    public void testReturnSizeEqualsToZeroWhenDeletingLastElement(){
        list.append(new DequeNode<>(9, null, null));
        list.deleteFirst();
        int expectedValue = 0;
        int obtainedValue = list.size();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testDeleteFirstEqualsToLastAfterDeletingOneNodeFromAListWithTwoElements(){
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));
        list.deleteFirst();
        assertEquals(list.peekFirst(), list.peekLast());
    }

    @Test
    public void testPreviousFromLastBecomeLastAfterDeletingLast(){
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        DequeNode x = list.peekLast();
        DequeNode prev = x.getPrevious();

        list.deleteLast();
        assertEquals(prev, list.peekLast());
    }

    @Test
    public void testDeleteFirstReturnNextFromFirstBecomeFirstAfterDeletingHim(){
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        DequeNode x = list.peekFirst();
        DequeNode next = x.getNext();

        list.deleteFirst();
        assertEquals(next, list.peekFirst());
    }

    @Test
    public void testAppendLeftReturnNodeIsTheFirstWhenWeAddedIt(){
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        DequeNode x = list.peekFirst();

        list.appendLeft(new DequeNode<>(3, null, null));

        assertEquals(x.getPrevious(),list.peekFirst());
    }

    @Test
    public void testPeekLastReturnNullWhenCallingNextFromLastNode(){
        //Devuelve null cuando llamamos al next del ultimo nodo
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        assertEquals(list.peekLast().getNext(), null);
    }

    @Test
    public void testPeekFirstReturnNullWhenCallingPreviousFromFirstNode(){
        list.append(new DequeNode<>(6, null, null));
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        assertEquals(list.peekFirst().getPrevious(), null);
    }

    @Test
    public void testSizeReturnValueDifferentFromZeroToAListNotEmpty(){
        list.append(new DequeNode<>(8, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(5, null, null));

        int obtainedValue = list.size();
        int notExpectedValue = 0;
        assertNotEquals(0, obtainedValue);
    }

    @Test
    public void testSizeReturnValueOneWhenFirstEqualsLast(){
        list.append(new DequeNode<>(1, null, null));
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
        assertEquals(null, list1.getAt(1).getItem());
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
        assertEquals(30, list1.getAt(0).getItem());
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
    public void shouldReturnCorrectNode() {
        var Node = list1.find(30);
        // Comprobamos que el elemento es el mismo
        assertEquals(30, Node.getItem());
        // Comprobamos que el next y el prev son null
        assertTrue(Node.getNext() == null && Node.getPrevious() == null);

        var Node2 = list2.find(6);
        //Comprobamos que el elemento es el mismo
        assertEquals(6,Node2.getItem());
        //Comprobamos que next y prev no son nulos
        assertTrue(Node2.getNext() != null && Node2.getPrevious() != null);
    }

    /*
        Scenario: find de un elemento repetido en la lista
     */
    @Test
    public void shouldReturnOneNodeIfElementIfDuplicated() {
        //Si tenemos 2 nodos con el mismo elemento, devolvemos el primero que encontramos
        duplicated.append(new DequeNode<>(2,null,null));
        duplicated.append(new DequeNode<>(2,null,null));

        var Node = duplicated.find(2);
        assertTrue(Node.isFirstNode());
    }
    /*
        Eliminar un elemento de una lista vacia
    */

    @Test
    public void testDeleteReturnExceptionWhenDeletingElementFromEmptyList() {
        assertThrows(DoubleLinkedListQueueException.class, () -> empty.delete(new DequeNode<Object>(5, null, null)));
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
        DequeNode aux = list2.find(8);
        list2.delete(aux);
        int obtainedValue = list2.size();

        assertEquals(expectedValue, obtainedValue);

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
    /*
        Salta una excepcion cuando despues de eliminar el unico elemento, intento llamar a peekFirst (no se podría, porque no hay)
    */

    @Test
    public void testDeleteShouldReturnExceptionWhenTryingToPeekFirstInEmptyListAfterDeleting(){
        list1.delete(list1.peekFirst());
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.peekFirst());
    }

    @Test
    public void testDeleteLastInAList() {
        DequeNode prev = list2.peekLast().getPrevious();
        list2.delete(list2.peekLast());

        assertTrue(prev.equals(list2.peekLast()));
    }
    /*
        Salta una excepcion cuando despues de eliminar el unico elemento, intento llamar a peekFirst (no se podría, porque no hay)
    */

    @Test
    public void testDeleteShouldReturnExceptionWhenTryingToPeekLastInEmptyListAfterDeleting(){
        list1.delete(list1.peekLast());
        assertThrows(DoubleLinkedListQueueException.class, () -> list1.peekLast());
    }

    /*
            Correcta ejecucion del sort
     */

    @Test
    public void testSortShouldReturnAListSorted(){

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        list2.sort(comparator);
        int i = 0;
        while(i < list2.size() && list2.getAt(i).getNext()!= null){
            assertTrue((Integer) list2.getAt(i).getItem() < (Integer) list2.getAt(i).getNext().getItem() );
            i++;
        }

    }

}