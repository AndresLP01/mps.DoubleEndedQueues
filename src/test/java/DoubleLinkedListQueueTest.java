import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    public void testReturnExceptionWhenPeekFirstInEmptyList(){
        assertThrows(DoubleLinkedListQueueException.class, () -> list.peekFirst());
    }

    @Test
    public void testReturnSizeEqualsToZeroWhenDeletingLastElement(){
        list.append(new DequeNode(9, null, null));

        list.deleteFirst();
        int expectedValue = 0;
        int obtainedValue = list.size();

        assertEquals(expectedValue, obtainedValue);
    }
}