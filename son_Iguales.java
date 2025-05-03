public class son_Iguales {
    public static <T> boolean sonIguales(Node<T> l1, Node<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.data.equals(l2.data)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
