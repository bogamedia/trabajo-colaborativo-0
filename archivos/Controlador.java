import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * Clase controlador grupo 1A
 * 
 * @autores
 * Javier Padilla &...() 
 * Hanzel Calderon
 * Tatiana Briones
 */
public class Controlador
{
    private JOptionPane interfaz;	
    private ImageIcon icono;

    public Controlador()
    {
        interfaz = new JOptionPane();    
        icono = new ImageIcon("java.png");
    }

    public void iniciar()
    {
        String direccion = interfaz.showInputDialog(null,"Escriba su dirección");

        String distritoPlaceholder = interfaz.showInputDialog(null, "Digite el número de distrito en que vive");
        int distrito = Integer.parseInt(distritoPlaceholder);

        String cantonPlaceholder = interfaz.showInputDialog(null, "Digite el número de cantón en que vive");
        int canton = Integer.parseInt(cantonPlaceholder);

        String provincia = this.obtenerProvincia();

        String casaPropia = this.preguntarCasa();

        interfaz.showMessageDialog(null, "Dirección: " + direccion + "\n" + "Distrito: " + distrito + "\n" + "Cantón: " + canton + "\n" + "Provincia: " + provincia + "\n" + "Casa propia: " + casaPropia, "GRUPO 1A", interfaz.INFORMATION_MESSAGE, icono);
    }

    public String obtenerProvincia()
    {
        String provinciaSeleccionada;
        String[] provinciasCostaRica = {"Alajuela", "San José", "Guanacaste", "Puntarenas", "Cartago", "Heredia", "Limón"};
        int choice = interfaz.showOptionDialog(null, "Seleccione su provincia", "Provincia", interfaz.YES_NO_OPTION, interfaz.QUESTION_MESSAGE, null, provinciasCostaRica, null);
        provinciaSeleccionada = provinciasCostaRica[choice];
        return provinciaSeleccionada;
    }

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

}
