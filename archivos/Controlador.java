/**
 * Clase controlador 
 * 
 * @author:
 * Grupo 01-A
 * 
 * Javier Padilla
 * Hanzel Calderon
 * Tatiana Briones
 * Carlos Bogarin
 * 
 * @version 004: Domingo 28 de agosto de 2016
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
       *
        */    
       
    public void iniciar()
    {
        this.mensajeBienvenida();
        
        String direccion = interfaz.showInputDialog(null,"Escriba su dirección");

        String distritoPlaceholder = interfaz.showInputDialog(null, "Digite el número de distrito en que vive");
        int distrito = Integer.parseInt(distritoPlaceholder);

        String cantonPlaceholder = interfaz.showInputDialog(null, "Digite el número de cantón en que vive");
        int canton = Integer.parseInt(cantonPlaceholder);

        String provincia = this.obtenerProvincia();

        String casaPropia = this.preguntarCasa();

        interfaz.showMessageDialog(null, "Dirección: " + direccion + "\n" + "Distrito: " + distrito + "\n" + "Cantón: " + canton + "\n" + "Provincia: " + provincia + "\n" + "Casa propia: " + casaPropia, "GRUPO 1A", interfaz.INFORMATION_MESSAGE, logo);
    }
    
    /**
       *
        */

    public String obtenerProvincia()
    {
        String provinciaSeleccionada;
        String[] provinciasCostaRica = {"Alajuela", "San José", "Guanacaste", "Puntarenas", "Cartago", "Heredia", "Limón"};
        int choice = interfaz.showOptionDialog(null, "Seleccione su provincia", "Provincia", interfaz.YES_NO_OPTION, interfaz.QUESTION_MESSAGE, null, provinciasCostaRica, null);
        provinciaSeleccionada = provinciasCostaRica[choice];
        return provinciaSeleccionada;
    }
    
    /**
       *
        */
       
    public String preguntarCasa()
    {
        String eleccionUsuario;
        int userAnswer = interfaz.showConfirmDialog(null, "Es su casa propia?", "Casa", interfaz.YES_NO_OPTION, interfaz.QUESTION_MESSAGE);
        if(userAnswer == 0)
        {
            eleccionUsuario = "Sí";
        }
        else
        {
            eleccionUsuario = "No";
        }
        return eleccionUsuario;
    }

    /**
       *
        */
    public void mensajeBienvenida()
    {
        interfaz.showMessageDialog(null,
            "Bienvenido al sistema de General Services, Inc.",  //  Mensaje principal.
                "Hola!",    //  Titulo de la ventana.
                    JOptionPane.INFORMATION_MESSAGE,    //  Tipo de mensaje.
                        logo);  //  Objeto que contiene el logo de la empresa.
    }
}
