package client;

import factory.Fabrica;
import factory.FabricaCiencia;
import factory.FabricaModa;
import factory.FactoryVideo;
import model.Publicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Biblioteca extends JFrame {
    private Fabrica factory;
    private ArrayList<Publicacion> publicaciones;
    private JTextArea publicacionesArea;
    private JComboBox<String> fabricaComboBox;
    private JButton buscarLibroBtn;
    private JButton buscarRevistaBtn;
    private JButton mostrarPublicacionesBtn;
    private Publicacion publicacionSeleccionada;

    /**
     * Constructor de la clase Biblioteca
     */
    public Biblioteca() {
        setTitle("Biblioteca");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        publicaciones = new ArrayList<>();

        // Panel de selección de fábrica
        JPanel fabricaPanel = new JPanel();
        fabricaPanel.setLayout(new FlowLayout());
        fabricaPanel.add(new JLabel("Selecciona una fábrica:"));

        String[] opcionesFabrica = {"Moda", "Ciencia", "Video"};
        fabricaComboBox = new JComboBox<>(opcionesFabrica);
        fabricaPanel.add(fabricaComboBox);

        JButton cambiarFabricaBtn = new JButton("Cambiar Fábrica");
        cambiarFabricaBtn.addActionListener(new CambiarFabricaListener());
        fabricaPanel.add(cambiarFabricaBtn);

        // Panel de búsqueda de publicaciones
        JPanel buscarPanel = new JPanel();
        buscarPanel.setLayout(new FlowLayout());

        buscarLibroBtn = new JButton("Buscar Libro");
        buscarLibroBtn.addActionListener(new BuscarPublicacionListener("libro"));
        buscarPanel.add(buscarLibroBtn);

        buscarRevistaBtn = new JButton("Buscar Revista");
        buscarRevistaBtn.addActionListener(new BuscarPublicacionListener("revista"));
        buscarPanel.add(buscarRevistaBtn);

        // Área para mostrar las publicaciones
        publicacionesArea = new JTextArea(15, 40);
        publicacionesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(publicacionesArea);

        mostrarPublicacionesBtn = new JButton("Mostrar Publicaciones");
        mostrarPublicacionesBtn.addActionListener(new MostrarPublicacionesListener());

        // Agregar componentes a la ventana principal
        add(fabricaPanel, BorderLayout.NORTH);
        add(buscarPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(mostrarPublicacionesBtn, BorderLayout.WEST);
    }

    /**
     * Listener para cambiar la fábrica de publicaciones
     */
    private class CambiarFabricaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int seleccion = fabricaComboBox.getSelectedIndex();
            switch (seleccion) {
                case 0:
                    factory = new FabricaModa();
                    break;
                case 1:
                    factory = new FabricaCiencia();
                    break;
                case 2:
                    factory = new FactoryVideo();
                    break;
            }
            JOptionPane.showMessageDialog(null, "Fábrica cambiada a: " + fabricaComboBox.getSelectedItem());
        }
    }

    /**
     * Listener para buscar una publicación
     */
    private class BuscarPublicacionListener implements ActionListener {
        private String tipoPublicacion;

        public BuscarPublicacionListener(String tipoPublicacion) {
            this.tipoPublicacion = tipoPublicacion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (factory == null) {
                JOptionPane.showMessageDialog(null, "Primero selecciona una fábrica.");
                return;
            }

            JFrame frameSecundario = new JFrame(); // Aquí creamos el JFrame secundario

            // Aquí, se simula la creación de un libro o una revista
            if (tipoPublicacion.equals("libro")) {
                publicacionSeleccionada = factory.crearLibro(); // Crear un libro
            } else if (tipoPublicacion.equals("revista")) {
                publicacionSeleccionada = factory.crearRevista(); // Crear una revista
            }

            if (publicacionSeleccionada != null) {
                // Cerrar el JFrame secundario cuando la publicación esté lista
                frameSecundario.dispose();  // Cerramos el JFrame secundario

                // Mostrar el cuadro de confirmación para agregar la publicación
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas agregar la publicación a la biblioteca?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    publicaciones.add(publicacionSeleccionada);  // Agregar la publicación a la lista
                    JOptionPane.showMessageDialog(null, "Publicación agregada.");
                }
            }
        }
    }

    /**
     * Listener para mostrar las publicaciones en el área de texto
     */
    private class MostrarPublicacionesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (publicaciones.isEmpty()) {
                publicacionesArea.setText("No hay publicaciones en la biblioteca.");
            } else {
                publicacionesArea.setText("");  // Limpiar el área de texto antes de mostrar
                for (Publicacion publicacion : publicaciones) {
                    publicacionesArea.append(publicacion.toString() + "\n" + "-------------------\n");
                }
            }
        }
    }
}
