/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precalc;

/**
 *
 * @author francescaperrone
 */
public class ClaseConjunta {

    private String expre;

    public ClaseConjunta(String expre) {

        this.expre = expre;

    }

    //Vamos a calcular la expresion, usando todos los metdos anteriores
    public String calcular() {
        String res;
        SplitTokens spltok;

        InfixToPostfix intopos = new InfixToPostfix();
        PostfixEvaluatorStr posEval = new PostfixEvaluatorStr();
        spltok = new SplitTokens();
        spltok.splitsarr(expre, "()+*-/");
        String [] arrExpre = spltok.splitsarr(expre, "()+*-/"); 
        RevisorParentesis2oper revpar = new RevisorParentesis2oper(arrExpre);
        if (revpar.revisarTodo()) {
        res = posEval.evaluate(intopos.toPostfix(arrExpre))+"";
        } else {
            res = revpar.error;
        }
        return res;

    }

}
