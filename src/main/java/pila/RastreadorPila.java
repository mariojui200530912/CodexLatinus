package pila;

import analyzer.CodexBaseListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class RastreadorPila extends CodexBaseListener {
    public String[] historialOperaciones;
    public int contadorOperaciones;
    private String[] nombresReglas;

    public RastreadorPila(int capacidadMaxima, String[] nombresReglas) {
        this.historialOperaciones = new String[capacidadMaxima];
        this.nombresReglas = nombresReglas;
        this.contadorOperaciones = 0;
    }

    private void registrarOperacion(String operacion){
        if (contadorOperaciones < this.historialOperaciones.length) {
            this.historialOperaciones[contadorOperaciones++] = operacion;
        }
    }

    @Override
    public void visitTerminal(TerminalNode node){
        if(node.getSymbol().getType() != Token.EOF){
            registrarOperacion("SHIFT: Se lee token '" + node.getText() + "'");
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        String nombreRegla = nombresReglas[ctx.getRuleIndex()];
        registrarOperacion("REDUCE: Regla <" + nombreRegla + "> completada");
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        registrarOperacion("ERROR: Símbolo inesperado '" + node.getText() + "'");
    }

    public void registrarAccept() {
        registrarOperacion("ACCEPT: Análisis finalizado con éxito.");
    }
}
