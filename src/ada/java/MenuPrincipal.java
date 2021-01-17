package ada.java;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    private ArrayList<OpcionMenu> opciones;
    private Inventario inventario;

    public MenuPrincipal() {
        opciones= new ArrayList<>();
        opciones.add(new OpcionMenu("1. Agregar un Producto"));
        opciones.add(new OpcionMenu("2. Modificar Stock de un Producto"));
        opciones.add(new OpcionMenu("3. Consultar un Producto"));
        opciones.add(new OpcionMenu("4. Consultar total de Productos Ingresados."));
        opciones.add(new OpcionMenu("5. Listar Productos."));
        opciones.add(new OpcionMenu("6. Salir"));

        inventario = new Inventario();
    }

    public void mostrarMenuPrincipal(){
        Boolean continuar=true;

        while (continuar) {
            imprimirOpciones();
            Integer opcion = pedirUnaOpcion();
            continuar = ejecutarOpcionMenuYContinuar(opcion);
        }
    }

    private Boolean ejecutarOpcionMenuYContinuar(Integer opcion) {
        Boolean continuar=true;
        Boolean continuarOpcion=true;

        switch (opcion){
            case 1:
                while (continuarOpcion) {
                    ejecutarMenuAgregarProducto();
                    continuarOpcion = imprimirDeseaContinuar();
                }
                break;
            case 2:
                while (continuarOpcion) {
                    ejecutarMenuModificarStockProducto();
                    continuarOpcion = imprimirDeseaContinuar();
                }
                break;
            case 3:
                while (continuarOpcion) {
                    ejecutarMenuConsultarProducto();
                    continuarOpcion = imprimirDeseaContinuar();
                }
                break;
            case 4:
                ejecutarMenuConsultarCantidadTotalProducto();
                imprimirPresioneTecla();
                break;
            case 5:
                ejecutarMenuListarProductos();
                imprimirPresioneTecla();
                break;
            case 6:
                continuar = false;
                break;
            default:
                System.out.println("Opción inválida. Vuelva a elegir.");
                imprimirPresioneTecla();
        }
        return continuar;
    }


    //-----------------------------------------------------------------------
    // Metodos de Ejecución Menú

    private void ejecutarMenuAgregarProducto() {
        imprimirSeparador();
        System.out.println("Alta de Producto:");
        System.out.println("-----------------");
        //Pido datos
        String categoria = pedirCategoria();
        String nombre = pedirString("Nombre");
        String marca = pedirString("Marca");
        Double precio = pedirDouble("Precio ($)");
        Integer cantidad = pedirInteger("Cantidad");
        //Agrego dato
        Producto producto = new Producto(nombre,marca,categoria,cantidad,precio);
        Integer nroProducto=inventario.agregarProducto(producto);
        if (!(nroProducto==0)) {
            System.out.println("Se agregó correctamente el Producto #" + nroProducto);
            System.out.println(producto.mostrarDatos());
        } else
            System.out.println("No se pueden agregar más productos.");
    }

    private void ejecutarMenuModificarStockProducto() {
        imprimirSeparador();
        System.out.println("Modificación de Producto:");
        System.out.println("-------------------------");
        //Pido datos
        Integer nroProducto = pedirInteger("Número de Producto a modificar Stock");
        Integer cantidadNueva = pedirInteger("nueva Cantidad");
        //Modifico dato
        Producto producto = inventario.modificarStockProducto(nroProducto,cantidadNueva);
        if (producto==null)
            System.out.println("Producto inexistente.");
        else
            System.out.println("Se modificó correctamente el Producto #" + nroProducto);
            System.out.println(producto.mostrarDatos());
    }

    private void ejecutarMenuConsultarProducto() {
        imprimirSeparador();
        System.out.println("Consulta de Producto:");
        System.out.println("---------------------");
        //Pido datos
        Integer nroProducto = pedirInteger("Número de Producto a consultar");
        //Consulto dato
        Producto producto = inventario.consultarProducto(nroProducto);
        if (producto==null)
            System.out.println("Producto inexistente.");
        else
            System.out.println(producto.mostrarDatos());
    }

    private void ejecutarMenuConsultarCantidadTotalProducto() {
        imprimirSeparador();
        System.out.println("La cantidad de Productos Ingresados es: " + inventario.consultarCantidadTotalProductos());
    }

    private void ejecutarMenuListarProductos() {
        imprimirSeparador();
        System.out.println("Listado de Productos:");
        System.out.println("---------------------");
        ArrayList<Producto> productos= inventario.getProductos();
        productos.forEach(producto -> System.out.println(producto.mostrarDatos()));
        ejecutarMenuConsultarCantidadTotalProducto();
    }

    //-----------------------------------------------------------------------
    // Metodos de Saludos
    public void mostrarBienvenida(){
        imprimirSeparador();
        System.out.println();
        System.out.println("    ----------------------------------");
        System.out.println("    | Bienvenido al Sistema de Stock |");
        System.out.println("    ----------------------------------");
        System.out.println();
        imprimirPresioneTecla();
    }

    public void mostrarDespedida(){
        imprimirSeparador();
        System.out.println("    ----------------------------------------");
        System.out.println("    | Gracias por utilizar nuestro Sistema |");
        System.out.println("    ----------------------------------------");
        imprimirSeparador();
    }

    //-----------------------------------------------------------------------
    // Metodos de Validacion

    private Boolean numeroValido(Double numero){
        return (numero>0);
    }

    private boolean palabraValido(String palabra) {
        return (!(palabra.trim().equals("")));
    }

    //-----------------------------------------------------------------------
    // Metodos de Pantalla
    private void imprimirOpciones(){
        System.out.println();
        System.out.println("Menú Principal:");
        opciones.forEach((opcion)-> {
            System.out.println(opcion.getTexto());
        });
        System.out.println();
        System.out.println("Seleccione una opción: ");
    }

    private void imprimirSeparador(){
        System.out.println("-----------------------------------------------------------------");
    }

    private Boolean imprimirDeseaContinuar(){
        imprimirSeparador();
        System.out.println("¿ Desea continuar en esta opción de menú ?");
        System.out.println("Presione S para Si ...");
        Scanner scanner = new Scanner((System.in));
        String tecla = scanner.next();
        limpiarPantalla();
        return (tecla.equals("s") || tecla.equals("S"));
    }

    private void imprimirPresioneTecla(){
        imprimirSeparador();
        System.out.println("Presione una tecla para Continuar...");
        String tecla=pedirUnaTecla();
        limpiarPantalla();
    }

    private void limpiarPantalla(){
        System.out.flush();
    }

    //-----------------------------------------------------------------------
    // Metodos de Interaccion con Usuario
    private String pedirUnaTecla() {
        Scanner scanner = new Scanner((System.in));
        return scanner.next();
    }

    private Integer pedirUnaOpcion() {
        Scanner scanner = new Scanner((System.in));
        return scanner.nextInt();
    }
    private String pedirCategoria() {
        Boolean continuar = true;
        String palabra = "";
        while (continuar) {
            System.out.println("Ingrese Categoría:");
            Scanner scanner = new Scanner((System.in));
            palabra = scanner.nextLine();
            if (!palabraValido(palabra))
                System.out.println("Valor inválido.");
            else
                continuar = false;
        }
        return palabra;
    }

    private String pedirString(String mensaje) {
        Boolean continuar = true;
        String palabra = "";
        while (continuar) {
            System.out.println("Ingrese " + mensaje + ":");
            Scanner scanner = new Scanner((System.in));
            palabra = scanner.nextLine();
            if (!palabraValido(palabra))
                System.out.println("Valor inválido.");
            else
                continuar = false;
        }
        return palabra;
    }

    private Double pedirDouble(String mensaje) {
        Boolean continuar = true;
        Double numero = 1.00;
        while (continuar) {
            System.out.println("Ingrese " + mensaje + ":");
            Scanner scanner = new Scanner((System.in));
            numero = scanner.nextDouble();
            if (!numeroValido(numero))
                System.out.println("Valor inválido.");
            else
                continuar = false;
        }
        return numero;
    }

    private Integer pedirInteger(String mensaje) {
        Boolean continuar = true;
        Integer numero = 1;
        while (continuar) {
            System.out.println("Ingrese " + mensaje + ":");
            Scanner scanner = new Scanner((System.in));
            numero = scanner.nextInt();
            if (!numeroValido(numero.doubleValue()))
                System.out.println("Valor inválido.");
            else
                continuar = false;
        }
        return numero;
    }
}