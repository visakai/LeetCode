import java.util.Stack;

/**
 * Created by sikpeng on 7/25/2017.
 */
public class ValidParentheses {
  public static void main(String[] args){
    System.out.println(new ValidParentheses().isValid("()[()]}"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    char[] chars = s.toCharArray();
    for(char c : chars){
      if(stack.empty()){
        stack.push(c);
      } else if(c==')' && stack.peek()=='('){
        stack.pop();
      } else if(c==']' && stack.peek()=='['){
        stack.pop();
      } else if(c=='}' && stack.peek()=='{'){
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.empty();
  }
}
