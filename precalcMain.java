
package precalc;

/**
 *
 * @author EDg1
 */
public class precalcMain {
    public static void main( String args[]) {
        
        // Separar en Tokens
        String expre = "((7+(10+12)*(40+508/2)+4)*5)-20";
        String delim = "()+-*/";
        
        SplitTokens stk = new SplitTokens();        
        System.out.println("\nPRUEBA 1: expresion: " + expre);
        String exprearr[] = stk.splitsarr(expre, delim);
        for( String a: exprearr) {  // foreach
            System.out.print("," + a);
        }
        System.out.println("");
        
        // Revisar Parentesis bien balanceados y que no se repitan operadores
        RevisorParentesis2oper rp1;
        boolean b;
        String sinoStr;
        System.out.println("\n---- PRUEBA 2 ----");
        rp1 = new RevisorParentesis2oper(exprearr);
        b = rp1.revisarTodo();
        sinoStr = (b) ? "SI" : "NO";
        System.out.println("La expresion string: " + expre +
                ", " + sinoStr + " tiene los Parentesis Balanceados u Operadores");

        // 4to Infix to Postfix
        System.out.println("\n---- PRUEBA 4 ----");
        System.out.print("  Infix");
        for( String a: exprearr) {  // foreach
            System.out.print(" " + a);
        }
        System.out.println("");        

        InfixToPostfix inpo = new InfixToPostfix();
        String[] Postfix = inpo.toPostfix(exprearr);
        System.out.print("Postfix");
        for( String a: Postfix) {  // foreach
            System.out.print(" " + a);
        }
        System.out.println("\n");
        
        // Postfix Evaluator
        System.out.println("\n---- PRUEBA 5 ----");
        for( String a: Postfix) {  // foreach
            System.out.print(" " + a);
        }
        System.out.println("\n");        
        PostfixEvaluatorStr pfexpre = new PostfixEvaluatorStr();
        double eval = pfexpre.evaluate(Postfix);
        System.out.println("Resultado: " + eval +"\n");
        
        String abc="-1";
        System.out.println(Double.parseDouble(abc));
        
         
        
    }

}
