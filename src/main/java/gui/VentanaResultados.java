package gui;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class VentanaResultados extends JFrame {
    private mxGraphComponent componenteGraficaAST;
    private JLabel lblGraficaSimbolos;

    public VentanaResultados() {
        setTitle("Resultados del Análisis - Codex Latinus");
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnPigLatin = new JButton("Traducir a PigLatin");
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

        lblGraficaSimbolos = new JLabel("Esperando generación de la Tabla de Símbolos...", SwingConstants.CENTER);
        panelPestanas.addTab("Tabla de Símbolos", new JScrollPane(lblGraficaSimbolos));

        add(panelPestanas, BorderLayout.CENTER);

    }

    public void dibujarAST() {
        mxGraph graph = componenteGraficaAST.getGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Object nodo1 = graph.insertVertex(parent, null, "Programa", 400, 20, 80, 30);
            Object nodo2 = graph.insertVertex(parent, null, "Asignacion", 200, 100, 80, 30);
            Object nodo3 = graph.insertVertex(parent, null, "Llamada a Funcion", 600, 100, 120, 30);

            graph.insertEdge(parent, null, "", nodo1, nodo2);
            graph.insertEdge(parent, null, "", nodo1, nodo3);

        } finally {
            graph.getModel().endUpdate();
        }
    }
}
