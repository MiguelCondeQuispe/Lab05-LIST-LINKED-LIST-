import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opción;
        do {
            System.out.println("\n=== MENÚ DE EJERCICIOS ===");
            System.out.println("1. Buscar Elemento");
            System.out.println("2. Invertir Lista");
            System.out.println("3. Insertar Nodo al Final ");
            System.out.println("4. Contar Nodos ");
            System.out.println("5. Comparar dos Nodos");
            System.out.println("6. Concatenar dos Nodos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opción = Integer.parseInt(sc.nextLine());

            switch (opción) {
                case 1: ejercicio1(); break;
                case 2: ejercicio2(); break;
                case 3: ejercicio3(); break;
                case 4: ejercicio4(); break;
                case 5: ejercicio5(); break;
                case 6: ejercicio6(); break;
                case 0: System.out.println("Adios!"); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opción != 0);
    }

    // EJERCICIO 1
    private static void ejercicio1() {
        System.out.println("\n--- Ejercicio 1: buscarElemento(List<String>, String) ---");
        List<String> lista = leerListaStrings();
        System.out.print("¿Qué valor buscas? ");
        String valor = sc.nextLine();
        boolean encontrado = buscar_Elemento.buscarElemento(lista, valor);
        System.out.println(encontrado
            ? "El valor está en la lista."
            : "El valor NO está en la lista.");
    }

    // EJERCICIO 2
    private static void ejercicio2() {
        System.out.println("\n--- Ejercicio 2: invertirLista(List<String>) ---");
        List<String> lista = leerListaStrings();
        List<String> inv = invertir_Lista.invertirLista(lista);
        System.out.println("Original: " + lista);
        System.out.println("Invertida: " + inv);
    }

    // EJERCICIO 3
    private static void ejercicio3() {
        System.out.println("\n--- Ejercicio 3: insertarAlFinal(Node<String>, String) ---");
        Node<String> head = null;
        System.out.println("Primero, ingresa una lista de valores para crear la lista enlazada:");
        List<String> valores = leerListaStrings();
        for (String v : valores) {
            head = insertar_al_Final.insertarAlFinal(head, v);
        }
        System.out.print("¿Qué valor quieres insertar al final? ");
        String nuevo = sc.nextLine();
        head = insertar_al_Final.insertarAlFinal(head, nuevo);
        System.out.print("Lista resultante: ");
        imprimirListaEnlazada(head);
    }

    // EJERCICIO 4
    private static void ejercicio4() {
        System.out.println("\n--- Ejercicio 4: contarNodos(Node<String>) ---");
        System.out.println("Ingresa los valores para tu lista enlazada:");
        List<String> valores = leerListaStrings();
        Node<String> head = null;
        for (String v : valores) head = insertar_al_Final.insertarAlFinal(head, v);
        int total = contar_Nodos.contarNodos(head);
        System.out.println("Total de nodos: " + total);
    }

    // EJERCICIO 5
    private static void ejercicio5() {
        System.out.println("\n--- Ejercicio 5: sonIguales(Node<String>, Node<String>) ---");
        System.out.println("Ingresa la primera lista de valores:");
        List<String> v1 = leerListaStrings();
        System.out.println("Ingresa la segunda lista de valores:");
        List<String> v2 = leerListaStrings();
        Node<String> l1 = null, l2 = null;
        for (String v : v1) l1 = insertar_al_Final.insertarAlFinal(l1, v);
        for (String v : v2) l2 = insertar_al_Final.insertarAlFinal(l2, v);
        boolean eq = son_Iguales.sonIguales(l1, l2);
        System.out.println(eq 
            ? "Ambas listas SON iguales." 
            : "Las listas NO son iguales.");
    }

    // EJERCICIO 6
    private static void ejercicio6() {
        System.out.println("\n--- Ejercicio 6: concatenarListas(Node<String>, Node<String>) ---");
        System.out.println("Ingresa la primera lista de valores:");
        List<String> v1 = leerListaStrings();
        System.out.println("Ingresa la segunda lista de valores:");
        List<String> v2 = leerListaStrings();
        Node<String> l1 = null, l2 = null;
        for (String v : v1) l1 = insertar_al_Final.insertarAlFinal(l1, v);
        for (String v : v2) l2 = insertar_al_Final.insertarAlFinal(l2, v);
        Node<String> conc = concaternar_Listas.concatenarListas(l1, l2);
        System.out.print("Lista concatenada: ");
        imprimirListaEnlazada(conc);
    }

    // Helper: lee una línea con valores separados por comas y devuelve List<String>
    private static List<String> leerListaStrings() {
        System.out.print("Ingresa valores separados por comas (ej: a,b,c): ");
        String línea = sc.nextLine().trim();
        List<String> lst = new ArrayList<>();
        if (!línea.isEmpty()) {
            for (String s : línea.split("\\s*,\\s*")) {
                lst.add(s);
            }
        }
        return lst;
    }

    // Helper: imprime Node<T> en consola
    private static <T> void imprimirListaEnlazada(Node<T> head) {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
