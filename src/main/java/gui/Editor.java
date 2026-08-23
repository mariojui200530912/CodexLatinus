package gui;

import analyzer.CodexLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import javax.swing.event.*;

public class Editor {

    private JTextPane areaCodigo;
    private JTextArea areaNumerosLinea;
    private JLabel lblPosicionCursor;
    private JTextArea areaConsola;

    private Style estiloNormal;
    private Style estiloReservada;
    private Style estiloNumero;
    private Style estiloCadena;
    private Style estiloOperador;
    private Style estiloComment;

    public Editor() {
        areaCodigo = new JTextPane();
        areaCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));

        areaNumerosLinea = new JTextArea("1");
        areaNumerosLinea.setBackground(new Color(230, 230, 230));
        areaNumerosLinea.setForeground(Color.GRAY);
        areaNumerosLinea.setEditable(false);
        areaNumerosLinea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaNumerosLinea.setMargin(new Insets(0, 5, 0, 5));

        lblPosicionCursor = new JLabel("Línea: 1, Columna: 1");
        areaConsola = new JTextArea();
        areaConsola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaConsola.setEditable(false);
        areaConsola.setBackground(new Color(40, 44, 52));
        areaConsola.setForeground(Color.WHITE);

        crearEstilos();

        areaCodigo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizarEditor(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizarEditor(); }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        areaCodigo.addCaretListener(e -> actualizarPosicionCursor());
    }

    public JTextPane getAreaCodigo() { return areaCodigo; }
    public JTextArea getAreaNumerosLinea() { return areaNumerosLinea; }
    public JLabel getLblPosicionCursor() { return lblPosicionCursor; }
    public JTextArea getAreaConsola() { return areaConsola; }

    public JScrollPane getScrollPaneConNumeros() {
        JPanel noWrapPanel = new JPanel(new BorderLayout());
        noWrapPanel.add(areaCodigo);
        JScrollPane scrollCodigo = new JScrollPane(noWrapPanel);
        scrollCodigo.setRowHeaderView(areaNumerosLinea);
        return scrollCodigo;
    }

    public void imprimirEnConsola(String mensaje) {
        areaConsola.append(mensaje + "\n");
        areaConsola.setCaretPosition(areaConsola.getDocument().getLength());
    }

    public void limpiarConsola() {
        areaConsola.setText("");
    }

    public String getTexto() {
        try {
            return areaCodigo.getDocument().getText(0, areaCodigo.getDocument().getLength());
        } catch (BadLocationException e) {
            return "";
        }
    }

    public void setTexto(String texto) {
        areaCodigo.setText(texto);
        actualizarEditor();
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
        int fila = root.getElementIndex(posicion) + 1;
        int inicioFila = root.getElement(fila - 1).getStartOffset();
        int columna = posicion - inicioFila + 1;
        lblPosicionCursor.setText("Línea: " + fila + ", Columna: " + columna);
    }

    private void crearEstilos() {
        StyleContext context = StyleContext.getDefaultStyleContext();

        estiloNormal = context.addStyle("Normal", null);
        StyleConstants.setForeground(estiloNormal, Color.BLACK);

        estiloReservada = context.addStyle("Reservada", null);
        StyleConstants.setForeground(estiloReservada, new Color(0, 0, 255));
        StyleConstants.setBold(estiloReservada, true);

        estiloNumero = context.addStyle("Numero", null);
        StyleConstants.setForeground(estiloNumero, new Color(200, 100, 0));

        estiloCadena = context.addStyle("Cadena", null);
        StyleConstants.setForeground(estiloCadena, new Color(0, 128, 0));

        estiloOperador = context.addStyle("Operador", null);
        StyleConstants.setForeground(estiloOperador, new Color(150, 0, 150));

        estiloComment = context.addStyle("Comment", null);
        StyleConstants.setForeground(estiloComment, new Color(128, 128, 128));
    }

    private void colorearTexto() {
        SwingUtilities.invokeLater(() -> {
            try {
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
                ex.printStackTrace();
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
