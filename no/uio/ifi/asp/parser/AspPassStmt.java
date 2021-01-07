package no.uio.ifi.asp.parser;
import no.uio.ifi.asp.scanner.*;
import no.uio.ifi.asp.runtime.*;
import static no.uio.ifi.asp.scanner.TokenKind.*;
public class AspPassStmt extends AspSmallStmt{

    AspPassStmt(int n){
        super(n);
    }

    static AspPassStmt parse (Scanner s){
        enterParser("pass stmt");

        AspPassStmt aps = new AspPassStmt(s.curLineNum());
        skip(s, passToken);
        test(s, newLineToken); skip(s, newLineToken);

        leaveParser("pass stmt");
        return aps;
    }

    @Override
    public void prettyPrint() {
       prettyWrite("pass");
    }

    @Override
    public RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
       trace("pass");
        return null;
    }
}
