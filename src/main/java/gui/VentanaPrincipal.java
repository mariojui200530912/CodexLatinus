package gui;

import analyzer.CodexLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTextPane areaCodigo;
    private JTextArea areaNumerosLinea; // Margen izquierdo
    private JLabel lblPosicionCursor;   // Barra de estado
    private JTextArea areaConsola;
    private JButton btnAnalizar;

    // Estilos de color predefinidos
    private Style estiloNormal;
    private Style estiloReservada;
    private Style estiloNumero;
    private Style estiloCadena;
    private Style estiloOperador;
    private Style estiloComment;

    public VentanaPrincipal() {
        setTitle("IDE Codex Latinus - Resistencia");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        crearEstilos();

        // Panel Superior Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAbrir = new JButton("Abrir .lat");
        JButton btnGuardar = new JButton("Guardar");
        btnAnalizar = new JButton("Analizar Código");
        JButton btnTraducir = new JButton("Traducir a PigLatin");
        JButton btnPila = new JButton("Ver Pila de Llamadas");
        JButton btnGraficas = new JButton("Ver AST y Símbolos");

        panelBotones.add(btnAbrir);
        panelBotones.add(btnGuardar);
        panelBotones.add(new JSeparator(SwingConstants.VERTICAL));
        panelBotones.add(btnAnalizar);
        panelBotones.add(btnPila);
        panelBotones.add(btnGraficas);
        panelBotones.add(btnTraducir);
        add(panelBotones, BorderLayout.NORTH);

        // Editor de codigo
        areaCodigo = new JTextPane();
        areaCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));

        areaNumerosLinea = new JTextArea("1");
        areaNumerosLinea.setBackground(new Color(230, 230, 230)); // Gris claro
        areaNumerosLinea.setForeground(Color.GRAY);
        areaNumerosLinea.setEditable(false);
        areaNumerosLinea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaNumerosLinea.setMargin(new Insets(0, 5, 0, 5));

        JPanel noWrapPanel = new JPanel(new BorderLayout());
        noWrapPanel.add(areaCodigo);
        JScrollPane scrollCodigo = new JScrollPane(noWrapPanel);
        scrollCodigo.setRowHeaderView(areaNumerosLinea);

        // Listener para colorear
        areaCodigo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizarEditor(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizarEditor(); }
            @Override
            public void changedUpdate(DocumentEvent e) {  }
        });

        // Barra de Estado (Linea y Columna)
        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblPosicionCursor = new JLabel("Línea: 1, Columna: 1");
        panelEstado.add(lblPosicionCursor);

        areaCodigo.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                actualizarPosicionCursor();
            }
        });

        JPanel panelEditorCompleto = new JPanel(new BorderLayout());
        panelEditorCompleto.add(scrollCodigo, BorderLayout.CENTER);
        panelEditorCompleto.add(panelEstado, BorderLayout.SOUTH);

        // Consola de Salida
        areaConsola = new JTextArea();
        areaConsola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaConsola.setEditable(false);
        areaConsola.setBackground(new Color(40, 44, 52));
        areaConsola.setForeground(Color.WHITE);
        JScrollPane scrollConsola = new JScrollPane(areaConsola);
        scrollConsola.setPreferredSize(new Dimension(getWidth(), 150));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelEditorCompleto, scrollConsola);
        splitPane.setResizeWeight(0.75);
        add(splitPane, BorderLayout.CENTER);
    }

    private void actualizarEditor() {
        colorearTexto();
        actualizarNumerosDeLinea();
    }

    private void actualizarNumerosDeLinea() {
        int conteoLineas = areaCodigo.getDocument().getDefaultRootElement().getElementCount();
        StringBuilder numeros = new StringBuilder();
        for (int i = 1; i <= conteoLineas; i++) {
            numeros.append(i).append("\n");
        }
        areaNumerosLinea.setText(numeros.toString());
    }

    private void actualizarPosicionCursor() {
        int posicion = areaCodigo.getCaretPosition();
        Element root = areaCodigo.getDocument().getDefaultRootElement();
        int fila = root.getElementIndex(posicion) + 1; // getElementIndex es base 0
        int inicioFila = root.getElement(fila - 1).getStartOffset();
        int columna = posicion - inicioFila + 1;

        lblPosicionCursor.setText("Línea: " + fila + ", Columna: " + columna);
    }

    private void crearEstilos() {
        StyleContext context = StyleContext.getDefaultStyleContext();

        estiloNormal = context.addStyle("Normal", null);
        StyleConstants.setForeground(estiloNormal, Color.BLACK);

        estiloReservada = context.addStyle("Reservada", null);
        StyleConstants.setForeground(estiloReservada, new Color(0, 0, 255)); // Azul
        StyleConstants.setBold(estiloReservada, true);

        estiloNumero = context.addStyle("Numero", null);
        StyleConstants.setForeground(estiloNumero, new Color(200, 100, 0)); // Naranja

        estiloCadena = context.addStyle("Cadena", null);
        StyleConstants.setForeground(estiloCadena, new Color(0, 128, 0)); // Verde

        estiloOperador = context.addStyle("Operador", null);
        StyleConstants.setForeground(estiloOperador, new Color(150, 0, 150)); // Morado

        estiloComment = context.addStyle("Comando", null);
        StyleConstants.setForeground(estiloComment, new Color( 128, 128, 128));
    }

    private void colorearTexto() {
        SwingUtilities.invokeLater(() -> {
        try{
            StyledDocument doc = areaCodigo.getStyledDocument();
            String texto = doc.getText(0, doc.getLength());

            if (texto.isEmpty()) return;

            doc.setCharacterAttributes(0, texto.length(), estiloNormal, true);


                CodexLexer lexer = new CodexLexer(CharStreams.fromString(texto));
                lexer.removeErrorListeners();

                Token token;
                while ((token = lexer.nextToken()).getType() != Token.EOF) {
                    int tipo = token.getType();
                    int inicio = token.getStartIndex();
                    int longitud = token.getText().length();

                    if (esPalabraReservada(tipo)) {
                        doc.setCharacterAttributes(inicio, longitud, estiloReservada, false);
                    } else if (tipo == CodexLexer.ENTERO || tipo == CodexLexer.DECIMAL) {
                        doc.setCharacterAttributes(inicio, longitud, estiloNumero, false);
                    } else if (tipo == CodexLexer.CADENA || tipo == CodexLexer.CARACTER) {
                        doc.setCharacterAttributes(inicio, longitud, estiloCadena, false);
                    } else if (esOperador(tipo)) {
                        doc.setCharacterAttributes(inicio, longitud, estiloOperador, false);
                    } else if (tipo == CodexLexer.COMMENT || tipo == CodexLexer.BLOCK_COMMENT) {
                        doc.setCharacterAttributes(inicio, longitud, estiloComment, false);
                    }
                }
            } catch (Exception ex) {

            }
        });
    }

    private boolean esPalabraReservada(int tipo) {
        return tipo == CodexLexer.NUMERUS || tipo == CodexLexer.TEXTUM ||
                tipo == CodexLexer.DECIMALIS || tipo == CodexLexer.LITTERA ||
                tipo == CodexLexer.BOOL || tipo == CodexLexer.VERUM ||
                tipo == CodexLexer.FALSUS || tipo == CodexLexer.ESTO ||
                tipo == CodexLexer.SERIES || tipo == CodexLexer.STRUCTURA ||
                tipo == CodexLexer.FINIS || tipo == CodexLexer.FINIS_MAIOR ||
                tipo == CodexLexer.SI || tipo == CodexLexer.ALITER ||
                tipo == CodexLexer.DUM || tipo == CodexLexer.FACERE ||
                tipo == CodexLexer.PER || tipo == CodexLexer.PERGE ||
                tipo == CodexLexer.INTERRUMPE || tipo == CodexLexer.ACTIO ||
                tipo == CodexLexer.RATIO || tipo == CodexLexer.REDDERE ||
                tipo == CodexLexer.VARIABILES || tipo == CodexLexer.MUNERA ||
                tipo == CodexLexer.MAIOR || tipo == CodexLexer.NON;
    }

    private boolean esOperador(int tipo) {
        return tipo == CodexLexer.LEER || tipo == CodexLexer.IMPRIMIR ||
                tipo == CodexLexer.MAS_MAS || tipo == CodexLexer.MENOS_MENOS ||
                tipo == CodexLexer.MAS || tipo == CodexLexer.MENOS ||
                tipo == CodexLexer.POR || tipo == CodexLexer.DIV ||
                tipo == CodexLexer.IGUAL_IGUAL || tipo == CodexLexer.DIFERENTE ||
                tipo == CodexLexer.MAYOR_IGUAL || tipo == CodexLexer.MENOR_IGUAL ||
                tipo == CodexLexer.MAYOR || tipo == CodexLexer.MENOR ||
                tipo == CodexLexer.AND || tipo == CodexLexer.OR ||
                tipo == CodexLexer.ASIGNACION;
    }

}
