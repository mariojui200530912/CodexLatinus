package errores;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ManejadorErrores extends BaseErrorListener {
    public GestorErrores gestor;
    public String tipoFase;

    public ManejadorErrores(GestorErrores gestor, String tipoFase) {
        this.gestor = gestor;
        this.tipoFase = tipoFase;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {

        gestor.agregarError(this.tipoFase, msg, line, charPositionInLine);
    }
}
