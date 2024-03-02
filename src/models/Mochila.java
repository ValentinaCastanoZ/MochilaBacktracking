package models;

public class Mochila {
    private int pesoMaximo;
    private Elemento[] elementos;

    private int peso;
    private int beneficio;

    public Mochila(int pesoMaximo, int numElementos) {
        // Constructor de la clase Mochila
        this.pesoMaximo = pesoMaximo;
        this.elementos = new Elemento[numElementos];
        this.beneficio = 0;
        this.peso = 0;
    }

    public Elemento[] getElementos() {
        // Retorna la lista de elementos actual en la mochila
        return elementos;
    }

    public int getPeso() {
        // Retorna el peso total actual de la mochila
        return peso;
    }

    public void setPeso(int peso) {
        // Establece el peso total actual de la mochila
        this.peso = peso;
    }

    public int getBeneficio() {
        // Retorna el beneficio total actual de la mochila
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        // Establece el beneficio total actual de la mochila
        this.beneficio = beneficio;
    }

    public int getPesoMaximo() {
        // Retorna la capacidad máxima de peso de la mochila
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        // Establece la capacidad máxima de peso de la mochila
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Añade un elemento a la mochila
     * 
     * @param e Elemento que se añade
     */
    public void aniadirElemento(Elemento e) {
        // Itera a través de los elementos para encontrar una posición nula y añadir el
        // elemento
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e; // Añade el elemento
                this.beneficio += e.getBeneficio(); // Aumenta el beneficio
                this.peso += e.getPeso(); // Aumenta el peso
                break;
            }
        }
    }

    /**
     * Vacía la mochila
     */
    public void clear() {
        // Reinicia el peso y beneficio, y elimina todos los elementos
        this.peso = 0;
        this.beneficio = 0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }

    /**
     * Elimina un elemento de la mochila
     * 
     * @param e Elemento que se elimina
     */
    public void eliminarElemento(Elemento e) {
        // Itera a través de los elementos para encontrar y eliminar el elemento
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                this.elementos[i] = null; // Elimina el elemento
                this.peso -= e.getPeso(); // Reduce el peso
                this.beneficio -= e.getBeneficio(); // Reduce el beneficio
                break;
            }
        }
    }

    /**
     * Comprueba si un elemento existe en la mochila
     * 
     * @param e Elemento que se verifica
     * @return Verdadero si el elemento existe en la mochila, falso de lo contrario
     */
    public boolean existeElemento(Elemento e) {
        // Itera a través de los elementos para verificar si el elemento existe
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve una representación en cadena de la mochila
     * 
     * @return Cadena que representa la mochila y sus elementos
     */
    public String toString() {
        String cadena = "";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena += elementos[i] + " - ";
            }
        }
        cadena += "\n";
        cadena += "Peso: " + getPeso() + "\n";
        cadena += "Beneficio: " + getBeneficio() + "\n";
        return cadena;
    }
}
