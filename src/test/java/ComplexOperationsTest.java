import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
}
