package ada.java;

public class Producto {
    private String nombre;
    private String marca;
    private String categoria;
    private Integer cantidad;
    private Double precio;

    public Producto(String nombre, String marca, String categoria, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String mostrarDatos(){
        return  "Nombre: " + nombre + " - " +
                "Marca: " + marca + " - "  +
                "Categoria: " + categoria + " - "  +
                "Cantidad: " + cantidad + " - " +
                "Precio: " + precio + "$";
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
