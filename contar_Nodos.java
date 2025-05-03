public class contar_Nodos {
    public static <T> int contarNodos(Node<T> head) {
        int count = 0;
        Node<T> actual = head;
        while (actual != null) {
            count++;
            actual = actual.next;
        }
        return count;
    }
}
