import java.util.Stack;


public class DuplicateParentheses {
   
    public static boolean duplicateParentheses(String str){
         Stack<Character> s = new Stack<Character>();
    
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            //Closing
            int count = 0;
            if(ch == ')'){
                while(s.peek() != '('){
                    s.pop(); //popping extra elms
                    count++;  //and counting them
                }
                if(count < 1){
                    return true; //duplicate
                }
                else{
                    s.pop(); //Opening pair match so pop
                }
            }
            else{
                //opening 
                s.push(ch);
            }
        }
        return false;
    }


    public static void main(String args[]){
            String str = "(a+b + c+d)";
            String str2 = "((a+b))";
            System.out.println(duplicateParentheses(str));
            System.out.println(duplicateParentheses(str2));
    }
}
