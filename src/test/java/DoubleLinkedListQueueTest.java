import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;


class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue list;

    @BeforeEach
    public void setup(){
        list = new DoubleLinkedListQueue();
    }

    @AfterEach
    public void finish(){
        list = null;
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
}