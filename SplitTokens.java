
package precalc;
import java.util.StringTokenizer;

/**
 *
 * @author EDg1
 */
public class SplitTokens {

    public SplitTokens() {
    }
    
    public String[] splitsarr(String anystr, String delim) {
        StringTokenizer strtokens;
        strtokens = new StringTokenizer(anystr, delim, true);
        
        int numtok = strtokens.countTokens();
        String tokens[] = new String[numtok];
        
        for( int i = 0; i < numtok; i++) {
            tokens[i] = strtokens.nextToken();
        }
        return tokens;
    }
    
}
