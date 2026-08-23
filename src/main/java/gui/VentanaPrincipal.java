package gui;

import analyzer.CodexLexer;
import analyzer.CodexParser;
import ast.ConstructorAST;
import ast.stm.NodoPrograma;
import errores.GestorErrores;
import errores.ManejadorErrores;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pila.RastreadorPila;
import simbolos.TablaSimbolos;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends JFrame {

    private Editor editor;
    private JButton btnAnalizar;

    public VentanaPrincipal() {
        setTitle("IDE Codex Latinus - Resistencia");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        editor = new Editor();

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemAbrir = new JMenuItem("Abrir .lat");
        JMenuItem itemGuardar = new JMenuItem("Guardar");

        itemAbrir.addActionListener(e -> abrirArchivo());
        itemGuardar.addActionListener(e -> guardarArchivo());

        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuBar.add(menuArchivo);

        menuBar.add(Box.createHorizontalGlue());
        menuBar.setBorder(BorderFactory.createEmptyBorder());

        btnAnalizar = new JButton("▶ Run Codex");
        btnAnalizar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnAnalizar.setBackground(new Color(40, 167, 69));
        btnAnalizar.setForeground(Color.WHITE);
        btnAnalizar.setFocusPainted(false);
        btnAnalizar.setOpaque(true);
        btnAnalizar.setBorderPainted(false);
        btnAnalizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAnalizar.setMargin(new Insets(2, 15, 2, 15));

        menuBar.add(btnAnalizar);

        setJMenuBar(menuBar);

        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelEstado.add(editor.getLblPosicionCursor());

        JPanel panelEditorCompleto = new JPanel(new BorderLayout());
        panelEditorCompleto.add(editor.getScrollPaneConNumeros(), BorderLayout.CENTER);
        panelEditorCompleto.add(panelEstado, BorderLayout.SOUTH);

        JScrollPane scrollConsola = new JScrollPane(editor.getAreaConsola());
        scrollConsola.setPreferredSize(new Dimension(getWidth(), 150));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                panelEditorCompleto, scrollConsola);
        splitPane.setResizeWeight(0.75);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        add(splitPane, BorderLayout.CENTER);

        btnAnalizar.addActionListener(e -> analizarCodigo());
    }

    private void analizarCodigo() {
        editor.limpiarConsola();
        String codigo = editor.getTexto();

        if (codigo.trim().isEmpty()) {
            editor.imprimirEnConsola("Error: El editor está vacío.");
            return;
        }

        editor.imprimirEnConsola("=== INICIANDO ANÁLISIS ===");
        try{
            GestorErrores gestorErrores = new GestorErrores(100);
            // LEXICO
            CodexLexer lexer =  new CodexLexer(CharStreams.fromString(codigo));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ManejadorErrores(gestorErrores, "Léxico"));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CodexParser parser = new CodexParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ManejadorErrores(gestorErrores, "Sintáctico"));
            RastreadorPila rastreador = new RastreadorPila(CodexParser.ruleNames);
            parser.addParseListener(rastreador);

            ParseTree arbolCST = parser.program();

            if (gestorErrores.hayErrores()) {
                editor.imprimirEnConsola(">>> Análisis detenido: Errores léxicos o sintácticos encontrados.");
                editor.imprimirEnConsola(gestorErrores.obtenerReporte());
                return;
            }

            editor.imprimirEnConsola("-> Análisis Léxico y Sintáctico: OK");

            // Construccion AST
            ConstructorAST constructor = new ConstructorAST();
            NodoPrograma programaAST = (NodoPrograma) constructor.visit(arbolCST);

            // Validacion semantica
            TablaSimbolos tablaGlobal = new TablaSimbolos(500, null, "Global");
            programaAST.validarSemantica(tablaGlobal, gestorErrores);

            if (gestorErrores.hayErrores()) {
                editor.imprimirEnConsola(">>> Análisis detenido: Errores semánticos encontrados.");
                editor.imprimirEnConsola(gestorErrores.obtenerReporte());
                return;
            }

            editor.imprimirEnConsola("=== COMPILACIÓN EXITOSA ===");

                SwingUtilities.invokeLater(() -> {
                    VentanaResultados resultados = new VentanaResultados(programaAST, tablaGlobal, rastreador.historialEstados);
                    resultados.setVisible(true);
                });

        } catch (Exception ex) {
            editor.imprimirEnConsola("Error crítico del sistema durante la compilación: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Abrir código fuente Codex Latinus");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Codex (*.lat)", "lat");
        fileChooser.setFileFilter(filtro);

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }

                editor.setTexto(contenido.toString());
                editor.imprimirEnConsola("Archivo cargado con éxito: " + archivo.getAbsolutePath());

            } catch (Exception ex) {
                editor.imprimirEnConsola("Error al leer el archivo: " + ex.getMessage());
            }
        }
    }

    private void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar código fuente Codex Latinus");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Codex (*.lat)", "lat");
        fileChooser.setFileFilter(filtro);

        fileChooser.setSelectedFile(new File("nuevo_programa.lat"));

        int seleccion = fileChooser.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            if (!archivo.getName().toLowerCase().endsWith(".lat")) {
                archivo = new File(archivo.getParentFile(), archivo.getName() + ".lat");
            }

            try (FileWriter writer = new FileWriter(archivo)) {
                // Extraemos el texto del editor y lo escribimos
                writer.write(editor.getTexto());
                editor.imprimirEnConsola("Archivo guardado con éxito en: " + archivo.getAbsolutePath());

            } catch (Exception ex) {
                editor.imprimirEnConsola("Error al guardar el archivo: " + ex.getMessage());
            }
        }
    }

}
