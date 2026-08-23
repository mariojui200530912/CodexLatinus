package gui;

import pila.EstadoPila;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

public class VentanaPila extends JFrame {
    private List<EstadoPila> historial;
    private int indiceActual = 0;

    private DefaultListModel<String> modeloPila;
    private JTextPane areaLog;
    private JLabel lblPaso;
    private JButton btnAtras;
    private JButton btnSiguiente;
    private Style estiloShift, estiloReduce, estiloGoto, estiloAccept, estiloNormal;

    public VentanaPila(List<EstadoPila> historial) {
        this.historial = historial;

        setTitle("Pila de Llamadas del Analizador");
        setSize(700, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 245));

        // PANEL SUPERIOR (Botones de control)
        JPanel panelControl = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        panelControl.setBackground(new Color(40, 44, 52));

        btnAtras = new JButton("◀ Atrás");
        btnSiguiente = new JButton("Siguiente ▶");
        formatearBoton(btnAtras);
        formatearBoton(btnSiguiente);

        lblPaso = new JLabel("Paso: 0 / 0");
        lblPaso.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblPaso.setForeground(Color.WHITE);

        panelControl.add(btnAtras);
        panelControl.add(lblPaso);
        panelControl.add(btnSiguiente);
        add(panelControl, BorderLayout.NORTH);

        // --- PANEL IZQUIERDO (Visualización de la Pila) ---
        modeloPila = new DefaultListModel<>();
        JList<String> listaPila = new JList<>(modeloPila);
        listaPila.setBackground(new Color(230, 235, 240));

        // Renderizador personalizado para dibujar "Bloques" separados
        listaPila.setCellRenderer(new PilaCellRenderer());

        JPanel panelPila = new JPanel(new BorderLayout());
        panelPila.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Tope de la Pila", 0, 0, new Font("SansSerif", Font.BOLD, 12)));
        panelPila.add(new JScrollPane(listaPila), BorderLayout.CENTER);

        // --- PANEL DERECHO (Log de operaciones a color) ---
        areaLog = new JTextPane();
        areaLog.setEditable(false);
        areaLog.setBackground(new Color(30, 30, 30));

        crearEstilosLog();

        JPanel panelLog = new JPanel(new BorderLayout());
        panelLog.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "LOG de Procesos", 0, 0, new Font("SansSerif", Font.BOLD, 12)));
        JScrollPane scrollLog = new JScrollPane(areaLog);
        scrollLog.setPreferredSize(new Dimension(350, 0));
        panelLog.add(scrollLog, BorderLayout.CENTER);

        // Dividimos la pantalla
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelPila, panelLog);
        split.setResizeWeight(0.4);
        split.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(split, BorderLayout.CENTER);

        // Lógica de botones
        btnAtras.addActionListener(e -> {
            if (indiceActual > 0) {
                indiceActual--;
                actualizarVista();
            }
        });

        btnSiguiente.addActionListener(e -> {
            if (indiceActual < historial.size() - 1) {
                indiceActual++;
                actualizarVista();
            }
        });

        actualizarVista();
    }

    private void actualizarVista() {
        EstadoPila estado = historial.get(indiceActual);

        // 1. Actualizar la Pila Visual
        modeloPila.clear();
        for (int i = estado.elementosPila.size() - 1; i >= 0; i--) {
            modeloPila.addElement(estado.elementosPila.get(i));
        }

        // 2. Actualizar el Log de Texto con colores y separadores
        areaLog.setText("");
        StyledDocument doc = areaLog.getStyledDocument();
        try {
            String ultimaAccion = "";
            for (int i = 0; i <= indiceActual; i++) {
                String lineaOriginal = historial.get(i).logOperacion;
                String linea = lineaOriginal + "\n";
                Style estiloAsignado = estiloNormal;

                // INYECCIÓN DEL SEPARADOR:
                // Si la acción anterior fue un 'reduce' y la nueva no lo es, dibujamos la línea
                if (ultimaAccion.contains("reduce") && (lineaOriginal.contains("shift") || lineaOriginal.contains("goto"))) {
                    doc.insertString(doc.getLength(), "------------------------\n", estiloNormal);
                }

                // Asignación de colores
                if (linea.contains("shift")) estiloAsignado = estiloShift;
                else if (linea.contains("reduce")) estiloAsignado = estiloReduce;
                else if (linea.contains("goto") || linea.contains("ENTER")) estiloAsignado = estiloGoto;
                else if (linea.contains("accept")) estiloAsignado = estiloAccept;

                doc.insertString(doc.getLength(), linea, estiloAsignado);
                ultimaAccion = lineaOriginal; // Guardamos registro para la siguiente iteración
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Auto-scroll al final del log
        areaLog.setCaretPosition(doc.getLength());

        // 3. Actualizar controles
        lblPaso.setText("Paso: " + (indiceActual + 1) + " / " + historial.size());
        btnAtras.setEnabled(indiceActual > 0);
        btnSiguiente.setEnabled(indiceActual < historial.size() - 1);
    }

    // --- MÉTODOS DE DISEÑO Y UTILIDAD ---

    private void formatearBoton(JButton btn) {
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(new Color(70, 75, 85));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void crearEstilosLog() {
        StyleContext context = StyleContext.getDefaultStyleContext();

        estiloNormal = context.addStyle("Normal", null);
        StyleConstants.setForeground(estiloNormal, Color.WHITE);
        StyleConstants.setFontFamily(estiloNormal, "Monospaced");
        StyleConstants.setFontSize(estiloNormal, 14);

        estiloShift = context.addStyle("Shift", estiloNormal);
        StyleConstants.setForeground(estiloShift, new Color(86, 182, 194)); // Cian

        estiloReduce = context.addStyle("Reduce", estiloNormal);
        StyleConstants.setForeground(estiloReduce, new Color(229, 192, 123)); // Amarillo/Naranja

        estiloGoto = context.addStyle("Goto", estiloNormal);
        StyleConstants.setForeground(estiloGoto, new Color(198, 120, 221)); // Morado

        estiloAccept = context.addStyle("Accept", estiloNormal);
        StyleConstants.setForeground(estiloAccept, new Color(152, 195, 121)); // Verde
        StyleConstants.setBold(estiloAccept, true);
    }

    // --- RENDERIZADOR PARA LOS BLOQUES DE LA PILA ---
    private class PilaCellRenderer implements ListCellRenderer<String> {
        private JPanel panelBase;
        private JLabel lblTexto;

        public PilaCellRenderer() {
            panelBase = new JPanel(new BorderLayout());
            panelBase.setBorder(BorderFactory.createEmptyBorder(4, 15, 4, 15)); // Espaciado exterior entre bloques
            panelBase.setOpaque(false); // Fondo transparente para ver el fondo del JList

            lblTexto = new JLabel();
            lblTexto.setOpaque(true);
            lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
            lblTexto.setFont(new Font("Monospaced", Font.BOLD, 15));
            panelBase.add(lblTexto, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            lblTexto.setText(value);

            // Si es el tope de la pila (índice 0), lo destacamos
            if (index == 0) {
                lblTexto.setBackground(new Color(255, 87, 34)); // Naranja "Resistencia"
                lblTexto.setForeground(Color.WHITE);
                lblTexto.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(191, 54, 12), 2),
                        BorderFactory.createEmptyBorder(8, 5, 8, 5) // Espaciado interior (padding)
                ));
            } else {
                // Bloques inactivos debajo del tope
                lblTexto.setBackground(new Color(250, 250, 250));
                lblTexto.setForeground(Color.DARK_GRAY);
                lblTexto.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 1),
                        BorderFactory.createEmptyBorder(8, 5, 8, 5)
                ));
            }
            return panelBase;
        }
    }
}
