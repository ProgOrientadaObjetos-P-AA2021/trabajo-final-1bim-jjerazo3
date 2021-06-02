package paqueteuno;

import java.util.Scanner;
import paqueteseis.*;
import paquetedos.*;
import paquetetres.*;
import paquetecuatro.*;
import paquetecinco.*;
import java.util.ArrayList;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        int opcionIngreso;
        int ingresarMostrar;
        do {
            System.out.println("******Inmobiliaria******");
            System.out.printf("ingrese una opcion:"
                    + "\n1.Ingresar registros\n2.Mostrar registros\n0.Salir"
                    + "\n> ");
            ingresarMostrar = sc.nextInt();
            if (ingresarMostrar == 1) {
                System.out.println("Que desea ingresar:");
                System.out.printf("1. Propietario\n"
                        + "2. Ubicacion\n"
                        + "3. Ciudad\n"
                        + "4. Constructora\n"
                        + "5. Casa\n"
                        + "6. Departamento\n> ");
                sc.nextLine();
                opcionIngreso = sc.nextInt();
                switch (opcionIngreso) {
                    case 1:
                        ingresoPropietarios();

                        break;
                    case 2:
                        ingresoUbicaciones();
                        break;
                    case 3:
                        ingresoCiudades();
                        break;
                    case 4:
                        ingresoConstructoras();
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Ingresar identificacion del "
                                + "Propietario:");
                        String idPropi = sc.nextLine();
                        System.out.println("Ingresar numero de casa:");
                        int numCasa = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingresar  nombre de la ciudad:");
                        String nombreCiudad = sc.nextLine();
                        System.out.println("Ingresar ID de la constructora:");
                        String constructoraID = sc.nextLine();
                        //Verificacion principal es para que verifique si sus 
                        //datos estan ingresados en el sistema, caso contrario 
                        //el programa hara que ingrese la informacion faltante
                        verificacionPrincipal(idPropi, numCasa, nombreCiudad,
                                constructoraID);
                        ingresoCasas(idPropi, numCasa, nombreCiudad,
                                constructoraID);
                        break;
                    case 6:
                        sc.nextLine();
                        System.out.println("Ingresar identificacion del "
                                + "Propietario:");
                        String idPropiDepa = sc.nextLine();
                        System.out.println("Ingresar numero de Departamento:");
                        int numDepa = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingresar nombre de la ciudad:");
                        String nombreCiudadDepa = sc.nextLine();
                        System.out.println("Ingresar ID de la constructora:");
                        String idCostructoraDepa = sc.nextLine();
                        //Verificacion principal es para que verifique si sus 
                        //datos estan ingresados en el sistema, caso contrario 
                        //el programa hara que ingrese la informacion faltante
                        verificacionPrincipal(idPropiDepa, numDepa,
                                nombreCiudadDepa, idCostructoraDepa);
                        ingresoDepartamento(idPropiDepa, numDepa,
                                nombreCiudadDepa, idCostructoraDepa);
                        break;
                    default:
                        System.err.println("opcion invalida");
                }
            } else {
                if (ingresarMostrar == 2) {
                    System.out.println("Que lista desea mostrar:");
                    System.out.printf("1. Propietarios\n"
                            + "2. Ubicaciones\n"
                            + "3. Ciudades\n"
                            + "4. Constructoras\n"
                            + "5. Casas\n"
                            + "6. Departamentos\n> ");
                    opcionIngreso = sc.nextInt();
                    switch (opcionIngreso) {
                        case 1:
                            mostrarPropietarios();
                            break;
                        case 2:
                            mostrarUbicaciones();
                            break;
                        case 3:
                            mostrarCiudades();
                            break;
                        case 4:
                            mostrarConstructoras();
                            break;
                        case 5:
                            mostrarCasas();
                            break;
                        case 6:
                            mostrarDepartamentos();
                            break;
                        default:
                            System.err.println("opcion invalida)");
                    }
                }
                if (ingresarMostrar == 0) {
                    salida = false;
                    System.out.println("\u001B[34mRegistro exitoso");
                }
                if (ingresarMostrar != 1 && ingresarMostrar != 2
                        && ingresarMostrar != 3) {
                    System.err.println("opcion invalida");

                }
            }
        } while (salida);
    }

    //Ingreso los datos del propietario
    public static void ingresoPropietarios() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombres:");
        String nombres = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Identificacion");
        String id = sc.nextLine();
        Propietario propi = new Propietario(nombres, apellidos, id);
        //Se escribe el archivo en un archivo propietario.txt
        EscrituraArchivoPropietario archivoPropi
                = new EscrituraArchivoPropietario("propietario.txt");
        //Le envio un objeto propietario para el registro
        archivoPropi.establecerRegistro(propi);
        archivoPropi.establecerSalida();
        //Cierro el archivo
        archivoPropi.cerrarArchivo();
    }

    //Ingreso Ubicaciones:
    public static void ingresoUbicaciones() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barrio: ");
        String nombreBarrio = sc.nextLine();
        System.out.println("Referencia: ");
        String refencia = sc.nextLine();
        System.out.println("Numero de casa");
        int numCasa = sc.nextInt();
        Ubicacion ubi = new Ubicacion(nombreBarrio, refencia, numCasa);
        //Se escribe el archivo en un archivo ubicacion.txt
        EscrituraArchivoUbicacion archivoUbi
                = new EscrituraArchivoUbicacion("ubicacion.txt");
        archivoUbi.establecerRegistro(ubi);
        archivoUbi.establecerSalida();
        //Cierro el archivo
        archivoUbi.cerrarArchivo();
    }

    //Ingreso ciudades:
    public static void ingresoCiudades() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ciudad: ");
        String ciudad = sc.nextLine();
        System.out.println("Provincia: ");
        String provincia = sc.nextLine();
        Ciudad city = new Ciudad(ciudad, provincia);
        //Se escribe el archivo en un archivo ciudad.txt
        EscrituraArchivoCiudad archivoCiu
                = new EscrituraArchivoCiudad("ciudad.txt");
        archivoCiu.establecerRegistro(city);
        archivoCiu.establecerSalida();
        //Cierro el archivo
        archivoCiu.cerrarArchivo();
    }

    public static void ingresoConstructoras() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de la contructora: ");
        String nombreConstructora = sc.nextLine();
        System.out.println("Id de la Constructora: ");
        String idEmpresa = sc.nextLine();
        Constructora constructora
                = new Constructora(nombreConstructora, idEmpresa);
        //Se escribe el archivo en un archivo constructora.txt
        EscrituraArchivoConstructora archivoCons
                = new EscrituraArchivoConstructora("constructora.txt");
        archivoCons.establecerRegistro(constructora);
        archivoCons.establecerSalida();
        //Cierro el archivo
        archivoCons.cerrarArchivo();
    }

    public static void ingresoCasas(String idPropi, int numCasa,
            String nameCiudad, String constructoraID) {
        Scanner sc = new Scanner(System.in);
        //Declaro Araylists de objetos para guardar los objetos
        //que se recuperaran del archivo txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;
        //Ingresa los datos de algunos atributos que contiene casa
        System.out.println("Precio por metro Cuadrado: ");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("cantidad de Metros cuadrados: ");
        double numMetroCuadrado = sc.nextDouble();
        System.out.println("Numero de cuartos de la casa: ");
        int numeroCuartos = sc.nextInt();
        //Lee el archivo de propietario.txt
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        //recupera los objetos de propietarios.txt y los guarda en un arraylist
        //llamado propietarios:
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        String nombrePropi = "";
        String apellidoPropi = "";
        //Se recorre el arraylist de objetos buscando si un atributo de
        //propietario Identificacion es igual al id que ingreso el usuario:
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdPropietario().equals(idPropi)) {
                nombrePropi = propietarios.get(i).obtenerNombrePropietario();
                apellidoPropi = propietarios.get(i).obtenerApellidoPropietario();
            }
        }
        Propietario objPropi = new Propietario(nombrePropi, apellidoPropi,
                idPropi);
        //Ubicacion
        //Lee el archivo de ubicacion.txt
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicaciones();
        //recupera los objetos de ubicacion.txt y los guarda en un arraylist
        //llamado ubicaciones:
        ubicaciones = lecturaUbicacion.obtenerListaUbicaciones();
        String nombreBarri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNCasa();
            if (numC == numCasa) {
                nombreBarri = ubicaciones.get(i).obtenerNombreBarrio();
                referens = ubicaciones.get(i).obtenerReferencia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(nombreBarri, referens, numCasa);
        //Ciudad
        //Lee el archivo de ciudad.txt
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudades();
        //recupera los objetos de ciudad.txt y los guarda en un arraylist
        //llamado citys:
        citys = lecturaCity.obtenerListaCiudades();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCity.obtenerListaCiudades().size(); i++) {
            if ((citys.get(i).obtenerNombreCiudad().toLowerCase()).equals(nameCiudad.toLowerCase())) {
                nombreProvincia = citys.get(i).obtenerNombreCiudad();
            }
        }
        Ciudad objCity = new Ciudad(nameCiudad, nombreProvincia);
        //Constructoras
        //Lee el archivo de constructora.txt
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructoras();
        //recupera los objetos de constructora.txt y los guarda en un arraylist
        //llamado constructoras:
        constructoras = lectruaConstructora.obtenerListaConstructoras();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructoras().
                size(); i++) {
            if (constructoras.get(i).obtenerIdConstructora().equals(constructoraID)) {
                nombreConstructora = constructoras.get(i).
                        obtenerNombreConstructora();
            }
        }
        Constructora objContructora
                = new Constructora(nombreConstructora, constructoraID);
        //creo un objeto casa y le envio los parametros correspondientes
        Casa casa = new Casa(objPropi, precioMetroCuadrado, numMetroCuadrado,
                objUbicacion, objCity, numeroCuartos, objContructora);
        casa.calcularCostoFinal(precioMetroCuadrado);
        //Se escribe el archivo en un archivo casa.txt
        EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa("casa.txt");
        archivoCasa.establecerRegistro(casa);
        archivoCasa.establecerSalida();
        archivoCasa.cerrarArchivo();
    }

    //Ingreso Departamentos
    public static void ingresoDepartamento(String idPropi, int numCasa,
            String nameCiudad, String constructoraID) {
        Scanner sc = new Scanner(System.in);
        //Declaro Araylists de objetos para guardar los objetos
        //que se recuperaran del archivo txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;
        //Ingresa los datos de algunos atributos que contiene casa
        System.out.println("Precio por metro Cuadrado: ");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Cantidad de emtros cuadrados: ");
        int numMetroCuadrado = sc.nextInt();
        System.out.println("Valor de alicouta:");
        double cuotaMensual = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el nombre del edificio:");
        String nameEdificio = sc.nextLine();
        System.out.println("Ingrese la dirección del edificio:");
        String ubicacionEdi = sc.nextLine();
        //Propietarios
        //Lee el archivo de propietario.txt
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        String nombrePropi = "";
        String apellidoPropi = "";
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdPropietario().equals(idPropi)) {
                nombrePropi = propietarios.get(i).obtenerNombrePropietario();
                apellidoPropi = propietarios.get(i).obtenerApellidoPropietario();
            }
        }
        Propietario objPropi = new Propietario(nombrePropi, apellidoPropi,
                idPropi);
        //Ubicacion
        //Lee el archivo de ubicacion.txt
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicaciones();
        ubicaciones = lecturaUbicacion.obtenerListaUbicaciones();
        String nombreBarri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNCasa();
            if (numC == numCasa) {
                nombreBarri = ubicaciones.get(i).obtenerNombreBarrio();
                referens = ubicaciones.get(i).obtenerReferencia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(nombreBarri, referens,numCasa);
        //Ciudad
        //Lee el archivo de ciudad.txt
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudades();
        citys = lecturaCity.obtenerListaCiudades();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCity.obtenerListaCiudades().size(); i++) {
            if (citys.get(i).obtenerNombreCiudad().equals(nameCiudad)) {
                nombreProvincia = citys.get(i).obtenerNombreCiudad();
            }
        }
        Ciudad objCity = new Ciudad(nameCiudad, nombreProvincia);
        //Constructoras
        //Lee el archivo de constructora.txt
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructoras();
        constructoras = lectruaConstructora.obtenerListaConstructoras();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructoras().
                size(); i++) {
            if (constructoras.get(i).obtenerIdConstructora().equals(constructoraID)) {
                nombreConstructora = constructoras.get(i).
                        obtenerNombreConstructora();
            }
        }
        Constructora objContructora = new Constructora(nombreConstructora,
                constructoraID);
        //Departamento
        Departamento d = new Departamento(objPropi, precioMetroCuadrado,
                numMetroCuadrado, cuotaMensual, objUbicacion, objCity,
                nameEdificio, ubicacionEdi, objContructora);
        d.establecerPrecioM2(precioMetroCuadrado);
        d.calcularCostoFinal(precioMetroCuadrado);
        EscrituraArchivoDepartamento archivoDepa
                = new EscrituraArchivoDepartamento("departamento.txt");
        archivoDepa.establecerRegistro(d);
        archivoDepa.establecerSalida();
        archivoDepa.cerrarArchivo();
    }

    public static void mostrarPropietarios() {
        LecturaArchivoPropietario lecturaCasas
                = new LecturaArchivoPropietario("propietario.txt");
        lecturaCasas.establecerListaPropietarios();
        System.out.println(lecturaCasas);
    }

    public static void mostrarUbicaciones() {
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicaciones();
        System.out.println(lecturaUbicacion);
    }

    public static void mostrarCiudades() {
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudades();
        System.out.println(lecturaCity);
    }

    public static void mostrarConstructoras() {
        LecturaArchivoConstructora lecturaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lecturaConstructora.establecerListaConstructoras();
        System.out.println(lecturaConstructora);
    }

    public static void mostrarCasas() {
        LecturaArchivoCasa lecturaCasa
                = new LecturaArchivoCasa("casa.txt");
        lecturaCasa.establecerListaCasas();
        System.out.println(lecturaCasa);
    }

    public static void mostrarDepartamentos() {
        LecturaArchivoDepartamento lecturaDepartamento
                = new LecturaArchivoDepartamento("departamento.txt");
        lecturaDepartamento.establecerListaDepartamentos();
        System.out.println(lecturaDepartamento);
    }

    //En verificacion Principal se reciben los valores que son necesarios para 
    //comprar si constan en el sistema, caso contrario se tendrian que registrar
    public static void verificacionPrincipal(String idPropi, int numCas,
            String nameCiu, String constructoraID) {

        Scanner sc = new Scanner(System.in);
        //En caso de que cualquier verificacion retorne un valor de 0, significa
        //que no esta registrado en el sisteme, por ende el programa llama al 
        //metodo ingreso, con el objetivo que se registren en el sistema
        System.out.println("--- Comprobar Propietario ---");
        if (verificacionPropietarios(idPropi) == 0) {
            ingresoPropietarios();
        }
        System.out.println("--- Comprobar Ubicacion ---");
        if (verificacionUbicacion(numCas) == 0) {
            ingresoUbicaciones();
        }//level in the paper
        sc.nextLine();
        System.out.println("--- Comprobar Ciudad ---");
        if (verificacionCiudad(nameCiu) == 0) {
            ingresoCiudades();
        }
        System.out.println("--- Comprobar Constructora ---");
        if (verificacionConstructora(constructoraID) == 0) {
            ingresoConstructoras();
        }
    }

    public static int verificacionPropietarios(String idPropi) {
        String mensaje = "No hay registro del propietario";
        int ingreso = 0;
        ArrayList<Propietario> propietarios;
        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("propietario.txt");
        lecturPropietarios.establecerListaPropietarios();
        propietarios = lecturPropietarios.obtenerListaPropietarios();
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdPropietario().equals(idPropi)) {
                mensaje = "Propietario registrado";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionUbicacion(int numCasa) {
        String mensaje = "No hay de ubiacaion";
        ArrayList<Ubicacion> ubicaciones;
        int ingreso = 0;
        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("ubicacion.txt");
        lecturaUbicacion.establecerListaUbicaciones();
        ubicaciones = lecturaUbicacion.obtenerListaUbicaciones();
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNCasa();
            if (numC == numCasa) {
                mensaje = "ubicacion registrada";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionCiudad(String nombreCiudad) {
        String mensaje = "No hay registro de la ciudad";
        ArrayList<Ciudad> citys;
        int ingreso = 0;
        LecturaArchivoCiudad lecturaCity
                = new LecturaArchivoCiudad("ciudad.txt");
        lecturaCity.establecerListaCiudades();
        citys = lecturaCity.obtenerListaCiudades();
        for (int i = 0; i < lecturaCity.obtenerListaCiudades().size(); i++) {
            if ((citys.get(i).obtenerNombreCiudad().toLowerCase()).equals(nombreCiudad.toLowerCase())) {
                mensaje = "Ciudad registrada";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }

    public static int verificacionConstructora(String constructoraID) {
        String mensaje = "No hay registro de la Constructora";
        ArrayList<Constructora> constructoras;
        int ingreso = 0;
        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("constructora.txt");
        lectruaConstructora.establecerListaConstructoras();
        constructoras = lectruaConstructora.obtenerListaConstructoras();
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructoras().
                size(); i++) {
            if (constructoras.get(i).obtenerIdConstructora().equals(constructoraID)) {
                mensaje = "Constructora registrada";
                ingreso = 1;
            }
        }
        System.out.println(mensaje);
        return ingreso;
    }
}