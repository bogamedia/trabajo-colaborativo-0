/**
 * Clase Controlador 
 * 
 * @author Grupo 01-A
 * 
 * Javier Padilla: métodos para obtener provincia y preguntar casa. 
 *                  Colaboración con la documentación y el método iniciar
 *                  
 * Hanzel Calderon: parte de la documentacion y algunas modificaciones.
 * 
 * Tatiana Briones: Correciones y colaboración con los métodos
 * 
 * Carlos Bogarin: métodos para obtener dirección, mensaje de bienvenida, 
 *                  logo y colaboración con el método iniciar, 
 *                      documentación y correciones de estilo.
 * 
 * @version 005: Lunes 29 de agosto de 2016
 */

/**
 *    Importación de paquetes estándar de la clase javax
 *    para el mamejo de ventanas de diálogo. Además del paquete java.lang
 *    para la interpretación de datos.
 */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.lang.Integer;

public class Controlador
{
    //  Declaración de objetos del paquete javax.

    //  El objeto interfaz se encargará de las interacciones
    //      con el usuario.
    private JOptionPane interfaz;   

    //  El objeto "logo" almacena el logotipo de la empresa
    //      "General Services, Inc."
    private ImageIcon logo;

    /**
     *    Constructor para objetos de tipo
     *        Controlador.
     *        
     *        Comentarios y diseño de logo por:
     *            @author Carlos Bogarín
     *            
     */

    public Controlador()
    {
        //  Inicialización de objetos.

        //  Inicialización del objeto interfaz.
        interfaz = new JOptionPane();  

        //  El objeto logo busca el archivo en la carpeta del proyecto.
        //  El archivo "logo-100x100.png" es una versión de 100x100 pixeles
        //      del logo de la empresa "General Services, Inc." 
        logo = new ImageIcon("logo-100x100.png");

    }

    /**
     *    El método iniciar ejecuta el programa y llama a los métodos
     *        de la clase.
     *    
     *    Modularización, corrrección de estilo y comentarios por 
     *        @author Carlos Bogarin, Javier Padilla
     *   
     */    

    public void iniciar()
    {
        //  El programa inicia con un amigable mensaje de bienvenida
        this.mensajeBienvenida();

        //  Luego pide la dirección del usuario.
        String direccion;   //  Declaración de la variable "direccion".
        String provincia;   //  Declaración de la variable "provincia".
        String casaPropia;  //  Declaración de la variable "casPropia".
        int distrito;   //  Declaración de la variable "distrito".
        int canton;     //  //  Declaración de la variable "canton".

        direccion = this.obtenerDireccion();    //  Inicialización y obtención de la dirección.
        distrito = this.obtenerDistritoCanton(1);   //  Inicialización y obtención del distrito.
        canton = this.obtenerDistritoCanton(2);     //  Inicialización y obtención del cantón.
        provincia = this.obtenerProvincia();    //  Inicialización y obtención de la provincia.
        casaPropia = this.preguntarCasa();      //  Inicialización y obtención de si la casa es propia o no.

        //  Despliegue de la ventana que mostrará al usuario sus datos.
        interfaz.showMessageDialog(null, 
                                    "Dirección: " + direccion + "\n" + "Distrito: " + distrito + "\n" + "Cantón: " + canton + "\n" + "Provincia: " + provincia + "\n" + "Casa propia: " + casaPropia, 
                                        "GRUPO 01-A", 
                                            interfaz.INFORMATION_MESSAGE, 
                                                logo);
    }

    /**
     *    El método obtenerProvincia pregunta al usuario donde vive 
     *    y retorna una string con dicha información
     *
     *    Realizado y comentado por:
     *        @author Javier Padilla 
     *        
     *        Comentario adicional por:
     *          @author Carlos Bogarin
     */

    public String obtenerProvincia()
    {
        // String que se retornará al final con la información
        String provinciaSeleccionada;

        // Array con posibles provincias
        String[] provinciasCostaRica = {"Alajuela", "San José", "Guanacaste", "Puntarenas", "Cartago", "Heredia", "Limón"};

        // instrucción que guarda el index de la provincia elegida por el usuario.
        int eleccion = interfaz.showOptionDialog(null, 
                                                    "Seleccione su provincia", 
                                                        "Provincia", interfaz.YES_NO_OPTION, 
                                                            interfaz.QUESTION_MESSAGE, 
                                                                null, 
                                                                    provinciasCostaRica, 
                                                                        null);

        // Iguala la string al nombre de la provincia
        provinciaSeleccionada = provinciasCostaRica[eleccion];
        
        //Retorno de la provincia seleccionada
        return provinciaSeleccionada;
    }

    /**
     *    El método preguntarCasa obtiene como resultado si la casa es 
     *    propia o no dependiendo de la respuesta del usuario.
     *    
     *    Realizado y comentado por:
     *        @author Javier Padilla 
     *
     *        Comentario adicional por:
     *          @author Carlos Bogarin
     */

    public String preguntarCasa()
    {
        // Variables locales del método
        String eleccionUsuarioHilera;
        int eleccionUsuarioEntero;

        // Obtiene el int con la respuesta del usuario 
        eleccionUsuarioEntero = interfaz.showConfirmDialog(null, 
                                                            "Es su casa propia?", 
                                                                "Casa", 
                                                                    interfaz.YES_NO_OPTION, 
                                                                        interfaz.QUESTION_MESSAGE);

        // Iguala la string al texto necesitado de acuerdo a la respuesta del usuario.
        if(eleccionUsuarioEntero == 0)
        {
            eleccionUsuarioHilera = "Sí";
        }
        else
        {
            eleccionUsuarioHilera = "No";
        }

        //Retorno de la hilera con la elección del usuario.
        return eleccionUsuarioHilera;
    }

    /**
     *    El método mensajeBienvenida despliega el mensaje inicial de
     *    bienvenida al usuario con el logo de la empresa al lado.
     *    
     *    @author Carlos Bogarin comentarios por Hanzel Calderon
     */

    public void mensajeBienvenida()
    {
        //Llamado al objeto interfaz.
        interfaz.showMessageDialog(null,
                                    "Bienvenido al sistema de General Services, Inc.",  //  Mensaje principal.
                                        "Hola!",    //  Titulo de la ventana.
                                            JOptionPane.INFORMATION_MESSAGE,    //  Tipo de mensaje.
                                                logo);  //  Objeto que contiene el logo de la empresa.
    }

    /**
     *    El método obtenerDireccion solicita al usuario su dirección.
     *    Devuelve una hilera con la dirección dada por el usuario.
     *    
     *    @author Carlos Bogarin comentarios por hanzel Calderon
     *    @return La dirección del usuario,
     */

    public String obtenerDireccion()
    {
        // Variable local, en esta se guarda la direccion que ingrese el usuario 
        // y que se retorna al final del metodo
        String direccion;
        direccion = "";

        // Guarda un String que es ingresado por el usuario.
        direccion = interfaz.showInputDialog(null,
                                                "Escriba su dirección");

        // Devuelve el string guardado en la variable local direccion.
        return direccion;
    }

    /**
     *    El método obtenerDistritoCanton recibe como parámetro
     *    lo que va a pedir (distrito o cantón) el programa al usuario.
     *    Devuelve el número de distrito o cantón.
     *
     *    @author Carlos Bogarin comentarios y mejoras Hanzel Calderon
     *    @param Enteros: 1 para distrito, 2 para cantón
     *    @return El número de distrito o cantón
     */

    public int obtenerDistritoCanton(int opcion)
    {
        // variables locales de metodo.
        String mensaje;       // guarda el mensaje que se va a mostrar.
        Integer entero;         // Entero es un objeto de tipo Integer que servirá para interpretar las hileras del usuario a datos enteros.
        int distritoCanton;   // guarda el numero de canton  ingresado por el usuario.

        // inicia las variables locales
        mensaje = "";
        distritoCanton = 0;
        entero = new Integer("0");
        
        // dependiendo el valor del parametro que se le pase al metodo, este switch elige el mensaje a mostrar en el showInputDialog.
        switch (opcion)
        {

            case 1: 
            mensaje = "Digite el número de distrito en que vive";
            break;

            case 2:
            mensaje = "Digite el número de cantón en que vive";
            break;

            default:
            mensaje = "ERROR!";
            break;
        }
        // solicita al usuario que ingrese el numero de canton, tambien lo convierte a int.
        
        //  Interpretación de la hilera a tipo entero.
        distritoCanton = entero.parseInt(interfaz.showInputDialog(null, 
                                                                    mensaje));
        //  Retorno del valor.
        return distritoCanton;
    }
}
