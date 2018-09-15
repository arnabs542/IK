package recursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressionsTarget {
    static String[] generate_all_expressions(String s, long target, int lastIndex) {
        int num = Integer.parseInt(s);
        return generateExpressions(num, target, new ArrayList<String>());
    }

    static String[] generateExpressions(int num, long target, List<String> results){
        if(num>target)
            return new String[0];

        int firstNum = num%10;
        int restNum = num/10;

        //int sum = generateExpressions()
        return null;
    }
}
