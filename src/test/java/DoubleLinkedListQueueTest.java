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
    public void testComputeReturnSizeBiggerThanPreviousSizeWhenAppend(){
        list.append(new DequeNode(5, null, null));
        list.append(new DequeNode(3, null, null));


    }
}