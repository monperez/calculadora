/*
 * Clase con metodos para revisar un String expresionStr aritmetica con
 * Parentesis Balanceados, izquierdos ( y derchos ).
 */
package precalc;

import Stacks.*;

/**
 * Clase RevisorParentesis2oper del ejercicio 12 E.g. (10+12)*(40+50/2)
 *
 * @author EDg1
 */
public class RevisorParentesis2oper {

    // String donde va la cadena de la expresion
    String[] expresionStr = null;
    String error;

    // Constructor
    public RevisorParentesis2oper(String[] expresion) {
        expresionStr = expresion;
    }

    //Determina si la expresionStr tiene losparéntesis balanceados.
    public boolean revisarTodo() {
        ArrayStack<Character> stackChar = new ArrayStack<Character>(40);
        boolean resp;
        char c;
        int i, t, ant;
        resp = true;
        i = 0;
        t = expresionStr.length;       //Tamaño de la expresionStr.
        ant = -11;  // Para operadores dobles

        //Recorrido de la expresionStr.
        while ((i < t) && resp) {

            c = expresionStr[i].charAt(0);
            if (i == 0 && (c == '*' || c == '/' || c == ')')) {
                resp = false;
                error = "INICIO INVÁLIDO";
            } else {
                if (isOperator(expresionStr[t - 1].charAt(0)) || expresionStr[t - 1].equals('(') || expresionStr[t - 1].equals('.')) {
                    resp = false;
                    error = "FINAL INVÁLIDO";
                } else {
                    if (c == '(') {  //Guarda en la pila el '('.
                        stackChar.push(c);
                    } else if (c == ')') {   //Verifica que en el tope haya '('.
                        if (!stackChar.isEmpty() && (stackChar.peek() == '(')) {
                            stackChar.pop();
                        } else {
                            resp = false;
                            error = "PARÉNTESIS DESBALANCEADOS";
                        }
                    } else {
                        if (isOperator(c)) {
                            if (ant == i - 1) {
                                resp = false;
                                error = "ERROR DE OPERADORES";
                            } else {
                                ant = i;
                            }
                        } else {
                            ant = -11;
                        }
                    }
                }
            }
           /* if(i != t){
                if(!isOperator(expresionStr[i+1].charAt(0))&&(c == '-' || c == '+')){
                    expresionStr[i] = expresionStr[i].concat(expresionStr[i+1]);
                    
                    for(int k = i+1; k < t; k++){
                        if(k == t-1){
                            expresionStr[k] = null; 
                        }else
                        expresionStr[k] = expresionStr[k+1]; 
                    }
                    String expresionStrNuevo[] = new String [t-1]; 
                    for(int k = 0; k < t-1; k++){
                        expresionStrNuevo[k] = expresionStr[k]; 
                    }
                    expresionStr = expresionStrNuevo; 
                    expresionStrNuevo = null; 
                }
            }
            */
            // Se desecha cualquier otro caracter
            i++;
        }
        while (!stackChar.isEmpty()) {  // Quita lo restante.
            stackChar.pop();
            resp = false;
            error = "PARÉNTESIS DESBALANCEADOS";
        }

        return resp;
    }

    /**
     * Determina si el caracter especificado es un operador. Regresa verdadero,
     * si lo es; falso, en caso contrario.
     */
    private boolean isOperator(char ch) {
        boolean b;
        b = (ch == '+') || (ch == '-')
                || (ch == '*') || (ch == '/');
        return b;
    }
}
