package lime.antlr4;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * An error listener that immediately bails out of the parse (does not recover)
 * and terminate the program immediately .
 */
public class DescriptiveBailErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {

        String entireMessage = String.format("Source: %s, line: %s, index: %s, \nError message: %s %s",
                recognizer.getInputStream().getSourceName(), line, charPositionInLine, msg,
                e == null ? "<null>" : e.getMessage());
        
        throw new RuntimeException(entireMessage);
        //System.err.println(entireMessage);
        //System.exit(0);
    }
}