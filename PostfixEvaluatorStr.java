
package precalc;
import Stacks.*;
import java.util.Scanner;

/**
 * @author EDg1
 */
public class PostfixEvaluatorStr {
    
    // Pila o Stack de evaluacion
    private ArrayStack<Double> stack;
  
    //Constructor.
    public PostfixEvaluatorStr() {
        stack = new ArrayStack<Double>();
    }

    /**
    * Evalua la operacion sufija especificada. Si se encuentra un operando,
    * se guarda en la pila. Si se encuentra un operador, se obtienen
    * los dos operandos del tope, se evalua la operacion y el resultado
    * se vuelve a guardar en la pila.
    * Regresa el valor (real) de la expresion (que es el unico que esta¡ 
    * en la pila).
    */
    public double evaluate (String expre[]) {
        double op1, op2, result = 0;
        int ex;
        String token;
        char sch;

        // Parsing
        ex = expre.length;
        for(int i = 0; i < ex; i++) {
            token = expre[i];
            sch = token.charAt(0);
            if (isOperator(sch)) {
                op2 = stack.pop();
                op1 = stack.pop();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(result);
            }
            else {
                stack.push(Double.parseDouble(token));
            }
            //stack.push(new Double(String.valueOf(car)));
        }
        result= stack.pop();
        while(!stack.isEmpty()) {
            stack.pop();
            result = 0.0;    //Error si quedo algo más
        }
        return result;
    }
  
    /**
    * Determina si el caracter especificado es un operador.
    * Regresa verdadero, si lo es; falso, en caso contrario.
    */
    private boolean isOperator (char ch) {
          boolean b;
          b = (ch == '+') || (ch == '-') ||
                  (ch == '*') || (ch == '/');          
    return b;
  }

  /**
   * Realiza una evaluacion sobre una expresion simple consistente
   * del operador especificado y dos operandos.
   * op1 es el primer operando y op2 el segundo.
   * Regresa el valor (real) de la expresion.
   */
  private double evaluateSingleOperator (char operation, double op1, double op2) {
    double result = 0;

    switch (operation) {
      case '+':
        result = op1 + op2;
        break;
      case '-':
        result = op1 - op2;
        break;
      case '*':
        result = op1 * op2;
        break;
      case '/':
        if(op2 == 0)
            result = -0.0;
        else
            result = op1 / op2;
        break;
    }
    return result;    
  }
    
}
