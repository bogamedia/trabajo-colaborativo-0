/**
 * Clase controlador 
 * 
 * @author
 * Grupo 01-A
 * 
 * Javier Padilla
 * Hanzel Calderon
 * Tatiana Briones
 * Carlos Bogarin
 * 
 * @version 004: Lunes 29 de agosto de 2016
 */

/**
   *    Importación de paquetes estándar de la clase javax
   *    para el mamejo de ventanas de diálogo.
   */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
       *        [Otra cosa] por:
       *            @author
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
       *        @author Carlos Bogarin
       *   
       *    [Otra cosa] por:
       *        @author
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
       *    El método obtenerProvincia [COMPLETAR...]
       *
       *    Comentarios por:
       *        @author
       *
       *    [Otra cosa] por:
       *        @author
        */

    public String obtenerProvincia()
    {
        // [DOCUMENTAR]
        String provinciaSeleccionada;
        
        // [DOCUMENTAR]
        String[] provinciasCostaRica = {"Alajuela", "San José", "Guanacaste", "Puntarenas", "Cartago", "Heredia", "Limón"};
        
        // [DOCUMENTAR] Y poner nombres de variables en Spanish, por consistencia.
        int eleccion = interfaz.showOptionDialog(null, "Seleccione su provincia", "Provincia", interfaz.YES_NO_OPTION, interfaz.QUESTION_MESSAGE, null, provinciasCostaRica, null);
        
        // [DOCUMENTAR]
        provinciaSeleccionada = provinciasCostaRica[eleccion];
        
        // [DOCUMENTAR]
        return provinciaSeleccionada;
    }
    
    /**
       *    El método preguntarCasa [COMPLETAR...]
       *    
       *    Comentarios por:
       *        @author
       *
       *    [Otra cosa] por:
       *        @author
        */
       
    public String preguntarCasa()
    {
        // [DOCUMENTAR]
        String eleccionUsuarioHilera;
        int eleccionUsuarioEntero;
        
        // [DOCUMENTAR]
        eleccionUsuarioEntero = interfaz.showConfirmDialog(null, "Es su casa propia?", "Casa", interfaz.YES_NO_OPTION, interfaz.QUESTION_MESSAGE);
        
        // [DOCUMENTAR]
        if(eleccionUsuarioEntero == 0)
        {
            // [DOCUMENTAR]
            eleccionUsuarioHilera = "Sí";
        }
        else
        {
            // [DOCUMENTAR]
            eleccionUsuarioHilera = "No";
        }
        // [DOCUMENTAR]
        return eleccionUsuarioHilera;
    }
    
    /**
       *    El método mensajeBienvenida despliega el mensaje inicial de
       *    bienvenida al usuario con el logo de la empresa al lado.
       *    
       *    @author Carlos Bogarin
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
       *    @author Carlos Bogarin
       *    @return La dirección del usuario,
        */
    
    public String obtenerDireccion()
    {
        // [DOCUMENTAR]
        String direccion;
        direccion = "";
        
        // [DOCUMENTAR]
        direccion = interfaz.showInputDialog(null,
                                "Escriba su dirección");
        
        // [DOCUMENTAR]
        return direccion;
    }
    
    /**
       *    El método obtenerDistritoCanton recibe como parámetro
       *    lo que va a pedir (distrito o cantón) el programa al usuario.
       *    Devuelve el número de distrito o cantón.
       *
       *    @author Carlos Bogarin
       *    @param Enteros: 1 para distrito, 2 para cantón
       *    @return El número de distrito o cantón
        */
       
    public int obtenerDistritoCanton(int opcion)
    {
        // [DOCUMENTAR]
        String mensaje;
        String distritoCantonHilera;
        int distritoCantonEntero;
        
        // [DOCUMENTAR]
        mensaje = "";
        distritoCantonHilera = "";
        distritoCantonEntero = 0;
        
        // [DOCUMENTAR]
        switch (opcion)
        {
            // [DOCUMENTAR]
            case 1: 
                    mensaje = "Digite el número de distrito en que vive";
                    break;
            
            // [DOCUMENTAR]
            case 2:
                    mensaje = "Digite el número de cantón en que vive";
                    break;
                    
            // [DOCUMENTAR]
            default:
                    mensaje = "ERROR!";
                    break;
        }
        
        // [DOCUMENTAR]
        distritoCantonHilera = this.interfaz.showInputDialog(null, 
                                        mensaje);
        
        // [DOCUMENTAR]
        distritoCantonEntero = Integer.parseInt(distritoCantonHilera);
        
        // [DOCUMENTAR]
        return distritoCantonEntero;
    }
}
