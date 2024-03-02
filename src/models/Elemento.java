package models;

public class Elemento {
    private int peso;
    private int beneficio;
    private String nombre;

    // Constructor de Elemento con peso, beneficio y nombre
    public Elemento(int peso, int beneficio, String nombre) {
        this.peso = peso;
        this.beneficio = beneficio;
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    // Método equals para comparar elementos por peso y beneficio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (this.peso != other.peso) {
            return false;
        }
        if (this.beneficio != other.beneficio) {
            return false;
        }
        return true;
    }

    // Método toString para representar un elemento como una cadena
    @Override
    public String toString() {
        return " nombre: " + nombre + " beneficio:" + beneficio + " Peso:" + peso + ",\n";
    }
}
