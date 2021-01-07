package no.uio.ifi.asp.parser;
import no.uio.ifi.asp.scanner.*;
import no.uio.ifi.asp.runtime.*;
import static no.uio.ifi.asp.scanner.TokenKind.*;

public class AspExprStmt extends AspSmallStmt{
  AspExpr ae;
  AspExprStmt (int n){
    super(n);
  }

  static AspExprStmt parse(Scanner s){
    enterParser("expr stmt");
    AspExprStmt aes = new AspExprStmt(s.curLineNum());
    aes.ae = AspExpr.parse(s);

    leaveParser("expr stmt");
    return aes;
  }

  @Override
  public void prettyPrint() {
     ae.prettyPrint();
     }

  @Override
  public RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
     RuntimeValue v = ae.eval(curScope);
     return v;
  }
}
