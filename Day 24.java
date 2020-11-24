/*
 Basic Calculator II
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/
class Solution {
    public int calculate(String s) {
        Stack <Integer> operands = new Stack<>();
        Stack <Character> operators = new Stack<>();
        int i = 0;
        for (;i < s.length();i++){
            char ch = s.charAt(i);
          
            if(ch == ' ')
                continue;
            System.out.print(operands);
            if(ch == '+' || ch == '-'){
                while(!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/')){
                    int secondOperand = operands.pop();
                    int firstOperand = operands.pop();
                    operands.push(evaluate(operators.pop(),firstOperand,secondOperand));
                }
                operators.push(ch);
            }
            
             else if(ch == '*' || ch == '/'){
                while(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')){
                    int secondOperand = operands.pop();
                    int firstOperand = operands.pop();
                    operands.push(evaluate(operators.pop(),firstOperand,secondOperand));
                }
                operators.push(ch); 
            }
            else{
                StringBuilder num = new StringBuilder();;
                char c = ch;
                while(c >= '0' && c <= '9'){
                    num.append(c);
                    if(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                        c = s.charAt(++i);
                    }
                    else break;
                }
                operands.push(Integer.parseInt(num.toString()));
            }             
        }
         while(!operators.isEmpty()){
                    int secondOperand = operands.pop();
                    int firstOperand = operands.pop();
                    operands.push(evaluate(operators.pop(),firstOperand,secondOperand));
                }
        return operands.pop();
    }
    private int evaluate(char operator,int firstOperand,int secondOperand){
        switch(operator){
            case '+': return firstOperand + secondOperand;  
               
            case '-': return firstOperand - secondOperand; 
               
            case '*': return firstOperand * secondOperand;  
               
            case '/': return firstOperand / secondOperand; 
                
        }
        return -1;
    }
}