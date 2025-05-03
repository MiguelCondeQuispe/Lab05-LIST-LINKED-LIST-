public class concaternar_Listas {
    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        Node<T> actual = l1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = l2;
        return l1;
    }
}
