public class main {
    public static void main(String[] args) {
        var testing = new DoubleLinkedListQueue();
        var node = new DequeNode<>(3,null,null);
        testing.append(node);
        var node1 = new DequeNode<>(5,null,null);
        testing.append(node);
        testing.appendLeft(node1);
        System.out.println(testing.peekFirst().getItem());
    }
}
