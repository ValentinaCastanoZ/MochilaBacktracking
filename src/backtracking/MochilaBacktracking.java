package backtracking;

import models.Elemento;
import models.Mochila;

public class MochilaBacktracking {
    public static void main(String[] args) {

        // Crear un array de elementos con sus respectivos pesos, valores y nombres
        Elemento[] elementos = {
                new Elemento(5, 2000, "Calculadora"),
                new Elemento(2, 1000, "Cartuchera"),
                new Elemento(3, 3000, "Cuaderno"),
                new Elemento(1, 6000, "Libro"),
                new Elemento(3, 7000, "Lonchera"),
                new Elemento(2, 300, "Regla"),
                new Elemento(1, 4000, "Sombrilla"),
        };

        // Crear dos instancias de la clase Mochila: m_base para realizar el backtracking, y m_opt para almacenar la solución óptima
        Mochila m_base = new Mochila(8, elementos.length);
        Mochila m_opt = new Mochila(8, elementos.length);

        // Llamar a la función llenarMochila para realizar el backtracking y encontrar la solución óptima
        llenarMochila("", m_base, elementos, false, m_opt);

        // Imprimir la solución óptima encontrada
        System.out.println("Solución óptima:");
        System.out.println(m_opt);
    }

    // Función que realiza el backtracking para llenar la mochila
    public static void llenarMochila(String ident, Mochila m_base, Elemento[] elementos, boolean llena, Mochila m_opt) {
        ident += "  "; // Identación para seguimiento en la consola

        // Si la mochila está llena
        if (llena) {
            System.out.println(ident + "Se llenó");

            // Comprobar si tiene más beneficio que otra mochila óptima conocida
            if (m_base.getBeneficio() > m_opt.getBeneficio()) {
                System.out.println(ident + "Asignó nueva óptima");
                Elemento[] elementosMochBase = m_base.getElementos();
                m_opt.clear();

                // Copiar los elementos a la mochila óptima
                for (Elemento e : elementosMochBase) {
                    if (e != null) {
                        m_opt.aniadirElemento(e);
                    }
                }
            }
        } else {
            // Recorrer los elementos disponibles
            for (int i = 0; i < elementos.length; i++) {
                String aux = m_base.existeElemento(elementos[i]) == true ? " ya existe " : " no existe";

                // Si el elemento no está en la mochila
                if (!m_base.existeElemento(elementos[i])) {
                    // Si agregar el elemento no excede el peso máximo de la mochila
                    if (m_base.getPesoMaximo() >= m_base.getPeso() + elementos[i].getPeso()) {
                        System.out.println(ident + "i=" + i + " agregó elemento de la posición: " + i + " (" + elementos[i].toString() + ")");
                        m_base.aniadirElemento(elementos[i]); // Añadir el elemento
                        llenarMochila(ident, m_base, elementos, false, m_opt); // Llamada recursiva

                        System.out.println(ident + "i=" + i + " Eliminó elemento de la posición: " + i + " (" + elementos[i].toString() + ")");
                        m_base.eliminarElemento(elementos[i]); // Eliminar el elemento (backtracking)
                    } else {
                        llenarMochila(ident, m_base, elementos, true, m_opt); // Si se excede el peso, marcar la mochila como llena
                    }
                }
            }
            llenarMochila(ident, m_base, elementos, true, m_opt); // Llamada recursiva marcando la mochila como llena
        }
    }
}
