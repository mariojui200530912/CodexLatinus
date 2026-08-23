package pila;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RastreadorPila implements ParseTreeListener {
    public List<EstadoPila> historialEstados;
    private Stack<String> pilaActual;
    private String[] nombresReglas;

    public RastreadorPila(String[] nombresReglas) {
        this.historialEstados = new ArrayList<>();
        this.pilaActual = new Stack<>();
        this.nombresReglas = nombresReglas;
        historialEstados.add(new EstadoPila(pilaActual, "INICIO DEL ANÁLISIS"));
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        String nombreRegla = nombresReglas[ctx.getRuleIndex()];
        pilaActual.push(nombreRegla);
        historialEstados.add(new EstadoPila(pilaActual, "goto --> " + nombreRegla));
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        String nombreRegla = nombresReglas[ctx.getRuleIndex()];
        if (!pilaActual.isEmpty()) {
            pilaActual.pop();
        }
        historialEstados.add(new EstadoPila(pilaActual, "reduce a <-- " + nombreRegla));
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        String token = node.getText();
        if (token.equals("<EOF>")) {
            historialEstados.add(new EstadoPila(pilaActual, "accept --"));
        } else {
            historialEstados.add(new EstadoPila(pilaActual, "shift -->" + token));
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        historialEstados.add(new EstadoPila(pilaActual, "error " + node.getText()));
    }
}
