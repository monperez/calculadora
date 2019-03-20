
package precalc;

import Stacks.ArrayStack;

/**
 *
 * @author estructuras00
 */
public class InfixToPostfix {

    public InfixToPostfix(){
        
         
    }


    public String[] toPostfix (String[] orig){
        String[] y = new String [orig.length];
        
        ArrayStack <String> signP= new ArrayStack<String>();
        ArrayStack <String> postFix= new ArrayStack<String>();
        
        int i=0;
        int j=0;
        int k=0;
        
        while(i<orig.length){
            switch(orig[i]){
                case"(": 
                    signP.push(orig[i]);
                    k++;
                    break;
                case")": 
                    while(!signP.isEmpty() && !signP.peek().equals("(")){          
                        postFix.push(signP.pop());  
                    }
                    signP.pop();
                    k++; 
                    break;
                case"^":
                    signP.push(orig[i]);
                    j++;
                    break;
                case"*":
                    resuelveJerarquia(postFix,signP,"*");
                    signP.push(orig[i]);
                    break;
                case"/":
                    resuelveJerarquia(postFix,signP,"/");
                    signP.push(orig[i]);
                    break;
                case"+":
                    resuelveJerarquia(postFix,signP,"+");
                    signP.push(orig[i]);
                    break;
                case"-":
                    resuelveJerarquia(postFix,signP,"-");
                    signP.push(orig[i]);
                    break;
                default:
                    postFix.push(orig[i]);
                    if(j!=0){
                        postFix.push(signP.pop());
                        j--;
                       
                    }
                    
                    break;
          
        }
            i++;
     
                    
        }
        
        while(!signP.isEmpty())
            postFix.push(signP.pop());
        
        
        while(!postFix.isEmpty())
            signP.push(postFix.pop());
        
        
  
        for(int w = 0; !signP.isEmpty(); w++){
            y[w]=signP.pop(); 
        }
        int p = y.length-k; 
        String [] res = new String[p]; 
        for(int t =0; t < p; t++){
            res[t]=y[t]; 
        }
        return res;  
    }
    private boolean isOperator (String st) {
          boolean b;
          b = (st == "+") || (st == "-") ||
                  (st == "*") || (st == "/");          
    return b;
  }
    
    public void resuelveJerarquia(ArrayStack<String> orig,ArrayStack<String> oc,String signo){
            ArrayStack<String> aux=new ArrayStack();

            if(!oc.isEmpty())

                switch(signo){
                    case"*": 
                        if(oc.peek().equals("*") || oc.peek().equals("/"))
                            while(!oc.isEmpty() &&(oc.peek().equals("*") || oc.peek().equals("/")) && !oc.peek().equals("(") )
                                orig.push(oc.pop());

                        break;
                    case"/":
                        if(oc.peek().equals("*") || oc.peek().equals("/") && !oc.peek().equals("("))
                            while(!oc.isEmpty())
                                orig.push(oc.pop());

                        break;
                    default:
                        while(!oc.isEmpty() && !oc.peek().equals("("))
                            orig.push(oc.pop());

                        break; 
                } 
        }
     
    
}
