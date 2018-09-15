package recursion;

public class Eval {
    static long eval(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        long value = 0;
        char operator = ' ';
        while(i<chars.length){
            if(chars[i]=='+')
                operator = '+';
            else
            if(chars[i]=='*')
                operator = '*';
            else{
                long operand = Long.parseLong(""+chars[i]);
                if(operator == ' ')
                    value = Long.parseLong(value+""+operand);
                if(operator=='*')
                    value = value*operand;
                if(operator=='+')
                    value = value+operand;
                operator = ' ';
            }
            i++;
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(eval("12+3*3"));
    }
}
