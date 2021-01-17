package ada.java;

public class Main {
/*
    Crear un sistema que permita controlar el stock de productos en una tienda.

        ETAPA 1:
        Condiciones: El nro. máximo de productos es 30.
        El sistema debe poder mostrar la cantidad total de artículos, el stock de un producto determinado,
        los detalles de un producto elegido, el precio. Además, debe permitir ingresar nuevos productos (máximo 30)
        y actualizar el stock de productos existentes. Debe existir un menú que ofrezca las distintas opciones
        del programa.

        ETAPA 2:
        Consignas opcionales
            a) controlar ingreso de usuario (si pone precio cero o stock negativo, si vende mas productos
            de los que tiene disponibles).
            b) agregar opciones de venta ( mostrar precio y descontar de una unidad)
            c) modificar esta ligado al sistema ventas
            d) listar los productos sin stock
            e) listar los 3 productos más caros
            f) listar los 3 productos más económicos
            g) incorporar la categoria de los alimentos (ingresadas previamente) y listar por ella.
*/
    public static void main(String[] args) {
	    MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarBienvenida();
        menu.mostrarMenuPrincipal();
        menu.mostrarDespedida();
    }
}
