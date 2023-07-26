/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversormonedas;
import javax.swing.JOptionPane;
/**
 *
 * @author jesusismaelarroyocastro
 */
public class ConversorMonedas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] opciones = {"Dólares (USD)", "Euros (EUR)", "Libras (GBP)", "Yenes (JPY)", "Wones (KRW)", "Salir"};

        boolean seguirEjecutando = true;
        while (seguirEjecutando) {
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona la moneda a la que deseas convertir:",
                    "Conversor de Moneda",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                // Si el usuario elige "Salir" o cierra el cuadro de diálogo, mostramos "Programa terminado" y salimos del ciclo
                JOptionPane.showMessageDialog(null, "Programa terminado.");
                seguirEjecutando = false;
            } else {
                double cantidadPesos = obtenerCantidadEnPesos();
                double resultado = 0.0;

                switch (seleccion) {
                    case "Dólares (USD)":
                        resultado = cantidadPesos / 20; // Tipo de cambio aproximado
                        break;
                    case "Euros (EUR)":
                        resultado = cantidadPesos / 24; // Tipo de cambio aproximado
                        break;
                    case "Libras (GBP)":
                        resultado = cantidadPesos / 28; // Tipo de cambio aproximado
                        break;
                    case "Yenes (JPY)":
                        resultado = cantidadPesos / 0.18; // Tipo de cambio aproximado
                        break;
                    case "Wones (KRW)":
                        resultado = cantidadPesos / 0.016; // Tipo de cambio aproximado
                        break;
                }

                String mensaje = cantidadPesos + " MXN son aproximadamente " + resultado + " " + seleccion.substring(seleccion.indexOf("(") + 1, seleccion.indexOf(")"));
                JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);

                int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Continuar", JOptionPane.YES_NO_OPTION);

                // Si el usuario elige "No" en el cuadro de diálogo de confirmación, mostramos "Programa terminado" y salimos del ciclo
                if (opcion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa terminado.");
                    seguirEjecutando = false;
                }
            }
        }
    }

    public static double obtenerCantidadEnPesos() {
        String cantidadPesosStr = JOptionPane.showInputDialog("Introduce la cantidad en pesos mexicanos (MXN):");
        try {
            return Double.parseDouble(cantidadPesosStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Debes introducir un número válido.");
            return obtenerCantidadEnPesos();
        }
    }
}
