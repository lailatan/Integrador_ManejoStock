package ada.java;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;
    private Integer topeProductos;

    public Inventario(){
        productos = new ArrayList<>();
        topeProductos=30;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Integer agregarProducto(Producto producto){
        if (productos.size() == topeProductos)
            return 0;
        else {
            productos.add(producto);
            return productos.size();
        }
    }

    public Integer consultarCantidadTotalProductos(){
        return productos.size();
    }

    public Producto consultarProducto(Integer numero){
        if (productos.isEmpty())
            return null;
        else {
            if (existeElProducto(numero))
                return productos.get(numero - 1);
            else
                return null;
        }
    }

    public Producto modificarStockProducto (Integer numero, Integer cantidad){
        Producto producto = consultarProducto(numero);
        if (!(productos==null))
            producto.setCantidad(cantidad);
        return producto;
    }

    private Boolean existeElProducto(Integer numero){
        return (numero>0 && numero<=topeProductos);
    }
}
