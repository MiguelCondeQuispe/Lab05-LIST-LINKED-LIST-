import java.util.*;

public class GestorDeTareas<T> {
    private Node<T> head;
    private List<T> tareasCompletadas = new ArrayList<>();

    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = nuevo;
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> actual = head;
        while (actual.next != null && !actual.next.data.equals(tarea))
            actual = actual.next;

        if (actual.next != null) {
            actual.next = actual.next.next;
            return true;
        }

        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(tarea)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int contarTareas() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public T obtenerTareaMasPrioritaria() {
        if (head == null || !(head.data instanceof Tarea)) return null;

        Node<T> temp = head;
        Tarea mayor = (Tarea) temp.data;

        while (temp != null) {
            Tarea t = (Tarea) temp.data;
            if (t.getPrioridad() > mayor.getPrioridad())
                mayor = t;
            temp = temp.next;
        }

        return (T) mayor;
    }

    public void invertirTareas() {
        Node<T> prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void transferirATareasCompletadas(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
        }
    }

    public void mostrarTareasCompletadas() {
        System.out.println("Tareas Completadas:");
        for (T tarea : tareasCompletadas)
            System.out.println(tarea);
    }
}
