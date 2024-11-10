package service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.ArrayList;

public class Dataset {
    private ArrayList<String> nombreAtributos_;
    private ArrayList<ArrayList<String>> datos_;

    /**
     * Constructor inicializando las listas
     */
    public Dataset() {
        nombreAtributos_ = new ArrayList<>();
        datos_ = new ArrayList<>();
    }

    /**
     * Metodo para añadir un nombre de atributo
     * @param nombreAtributo
     */
    public void addNombreAtributo(String nombreAtributo) {
        nombreAtributos_.add(nombreAtributo);
    }

    /**
     * Metodo setter para el nombre de los atributos
     * @param nombreAtributos
     */
    public void setNombreAtributos(ArrayList<String> nombreAtributos) {
        nombreAtributos_ = nombreAtributos;
    }

    /**
     * Metodo para añadir una fila de datos
     * @param fila
     */
    public void addFilaDatos(ArrayList<String> fila) {
        datos_.add(fila);
    }

    /**
     * Métodos para obtener los datos y atributos
     * @return ArrayList<String>
     */
    public ArrayList<String> getNombreAtributos() {
        return nombreAtributos_;
    }

    /**
     * Metodo para getter para los datos
     * @return
     */
    public ArrayList<ArrayList<String>> getDatos() {
        return datos_;
    }

    /**
     * Metodo para filtrar los datos basado en una condición
     * @param atributo
     * @param valorFiltrado
     * @return Dataset
     */
    public Dataset filtrarDatos(String atributo, String valorFiltrado) {
        Dataset datasetFiltrado = new Dataset();
        int indiceAtributo = nombreAtributos_.indexOf(atributo);
        if (indiceAtributo == -1) {
            System.out.println("El atributo no existe.");
            return this;
        }
        // Copiar los nombres de los atributos al nuevo dataset filtrado
        datasetFiltrado.nombreAtributos_ = new ArrayList<>(this.nombreAtributos_);
        // Filtrar los datos
        for (ArrayList<String> fila : datos_) {
            if (fila.get(indiceAtributo).equals(valorFiltrado)) {
                datasetFiltrado.addFilaDatos(new ArrayList<>(fila)); // Copiar la fila filtrada
            }
        }

        return datasetFiltrado;
    }

    /**
     * Metodo para comprobar si un atributo es numérico
     * @param indice
     * @return boolean
     */
    public boolean esAtributoNumerico(int indice) {
        for (ArrayList<String> fila : this.datos_) {
            try {
                Double.parseDouble(fila.get(indice));  // Intenta convertir a número
            } catch (NumberFormatException e) {
                return false; // No es numérico si lanza una excepción
            }
        }
        return true; // Todos los valores en esta columna son numéricos
    }

    /**
     * Metodo para imprimir el contenido de Dataset
     */
    public void imprimir() {
        // Imprimir nombres de los atributos
        System.out.println("Atributos:");
        for (String atributo : nombreAtributos_) {
            System.out.print(atributo + "\t");  // Separa con tabulaciones
        }
        System.out.println(); // Nueva línea

        // Imprimir los datos
        System.out.println("Datos:");
        for (ArrayList<String> fila : datos_) {
            for (String dato : fila) {
                System.out.print(dato + "\t"); // Separa con tabulaciones
            }
            System.out.println(); // Nueva línea
        }
    }

    public void show() {
        // Crear el JFrame para mostrar la ventana
        JFrame frame = new JFrame("Datos del Dataset");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear un modelo de tabla con los nombres de los atributos como columnas
        DefaultTableModel tableModel = new DefaultTableModel();

        // Añadir los nombres de los atributos como las columnas de la tabla
        for (String atributo : nombreAtributos_) {
            tableModel.addColumn(atributo);
        }

        // Añadir las filas de datos a la tabla
        for (ArrayList<String> fila : datos_) {
            tableModel.addRow(fila.toArray());
        }

        // Crear el JTable con el modelo de tabla
        JTable table = new JTable(tableModel);

        // Hacer que la tabla sea desplazable en caso de que haya muchos datos
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hacer visible el frame
        frame.setVisible(true);

    }

}
