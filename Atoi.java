public class Atoi {

    public static void main(String[] args) {

        String input = " -042";
        System.out.println(myAtoi(input));
    }

    private static int myAtoi(String s) {

        s = s.strip();
        
        if(s.isEmpty()) return 0;

        int flag = s.charAt(0) == '-' ? -1 : 1;

        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1);
        }

        long num = 0;
        for(char ch : s.toCharArray()){
            
            if(!Character.isDigit(ch)) break;
            num = num*10 + (ch - '0');

            if(flag*num >= Integer.MAX_VALUE)  return Integer.MAX_VALUE;
            if(flag*num <= Integer.MIN_VALUE)  return Integer.MIN_VALUE;   
        }
        return (int)num*flag;
    }
}
