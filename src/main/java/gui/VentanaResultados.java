package gui;

import ast.stm.NodoPrograma;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import simbolos.TablaSimbolos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.*;

public class VentanaResultados extends JFrame {
    private mxGraphComponent componenteGraficaAST;
    private JLabel lblGraficaSimbolos;

    private NodoPrograma raizAST;
    private TablaSimbolos tablaSimbolos;

    public VentanaResultados(NodoPrograma raizAST, TablaSimbolos tablaSimbolos) {
        this.raizAST = raizAST;
        this.tablaSimbolos = tablaSimbolos;

        setTitle("Resultados del Análisis - Codex Latinus");
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnPigLatin = new JButton("Traducir a PigLatin");
        btnPigLatin.addActionListener(e -> mostrarVentanaTraduccion());
        JButton btnPilaLlamadas = new JButton("Ver Pila de Llamadas");
        panelBotones.add(btnPilaLlamadas);
        panelBotones.add(btnPigLatin);
        add(panelBotones, BorderLayout.NORTH);

        // Lienzo para JGraph
        mxGraph grafoAST = new mxGraph();
        // evitar que usuario edite
        grafoAST.setCellsEditable(false);
        grafoAST.setCellsDisconnectable(false);
        grafoAST.setCellsBendable(false);

        componenteGraficaAST = new mxGraphComponent(grafoAST);
        componenteGraficaAST.getViewport().setOpaque(true);
        componenteGraficaAST.getViewport().setBackground(Color.WHITE);

        JTabbedPane panelPestanas = new JTabbedPane();

        panelPestanas.addTab("Árbol de Sintaxis Abstracta (AST)", componenteGraficaAST);

        JScrollPane scrollTablaSimbolos = construirVistaTablaSimbolos(this.tablaSimbolos);
        panelPestanas.addTab("Tabla de Símbolos", scrollTablaSimbolos);

        add(panelPestanas, BorderLayout.CENTER);
        dibujarAST();
    }

    public void dibujarAST() {
        mxGraph graph = componenteGraficaAST.getGraph();
        GraficadorAST graficadorAST = new GraficadorAST();
        Object parent = graph.getDefaultParent();

        graficadorAST.graficar(this.raizAST, graph);
    }

    private JScrollPane construirVistaTablaSimbolos(TablaSimbolos entornoGlobal) {
        String[] columnas = {"ID (Nombre)", "Categoría", "Tipo de Dato", "Entorno"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (entornoGlobal != null) {
            llenarModeloConEntornos(entornoGlobal, modelo);
        }

        JTable tablaVisual = new JTable(modelo);
        tablaVisual.setFillsViewportHeight(true);
        tablaVisual.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tablaVisual.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tablaVisual.getTableHeader().setBackground(new Color(230, 230, 230));
        tablaVisual.setRowHeight(25);

        return new JScrollPane(tablaVisual);
    }

    private void llenarModeloConEntornos(TablaSimbolos entornoActual, DefaultTableModel modelo) {
        if (entornoActual == null) return;

        for (int i = 0; i < entornoActual.cantidadSimbolos; i++) {
            var sim = entornoActual.simbolos[i];
            Object[] fila = {
                    sim.id,
                    sim.categoria,
                    sim.tipo != null ? sim.tipo : "actio",
                    entornoActual.nombreEntorno
            };
            modelo.addRow(fila);
        }

        for (int i = 0; i < entornoActual.cantidadHijos; i++) {
            llenarModeloConEntornos(entornoActual.hijos[i], modelo);
        }
    }

    private void mostrarVentanaTraduccion() {
        if (this.raizAST == null) return;

        String codigoTraducido = this.raizAST.traducirPigLatin();

        JDialog dialogoPig = new JDialog(this, "Código Traducido (Pig Latin)", true);
        dialogoPig.setSize(700, 500);
        dialogoPig.setLocationRelativeTo(this);
        dialogoPig.setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea(codigoTraducido);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 15));
        areaTexto.setEditable(false);
        areaTexto.setBackground(new Color(30, 30, 30));
        areaTexto.setForeground(new Color(152, 195, 121)); // Un verde estilo terminal
        areaTexto.setMargin(new Insets(10, 10, 10, 10));

        dialogoPig.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JButton btnGuardarPig = new JButton("Guardar archivo .pig");
        btnGuardarPig.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnGuardarPig.addActionListener(e -> guardarArchivoPig(codigoTraducido));

        JPanel panelSur = new JPanel();
        panelSur.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelSur.add(btnGuardarPig);
        dialogoPig.add(panelSur, BorderLayout.SOUTH);

        dialogoPig.setVisible(true);
    }

    private void guardarArchivoPig(String codigo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Exportar como código Pig Latin");
        javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Archivos PigLatin (*.pig)", "pig");
        fileChooser.setFileFilter(filtro);

        fileChooser.setSelectedFile(new java.io.File("traduccion.pig"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = fileChooser.getSelectedFile();

            if (!archivo.getName().toLowerCase().endsWith(".pig")) {
                archivo = new java.io.File(archivo.getParentFile(), archivo.getName() + ".pig");
            }

            try (java.io.FileWriter writer = new java.io.FileWriter(archivo)) {
                writer.write(codigo);
                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente en:\n" + archivo.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + ex.getMessage(), "Error Fatal", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
