import java.util.*;
public class Cal{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String input=sc.nextLine();
            char[]chars=input.toCharArray();
            //中缀转后缀
            Stack<Character>stack=new Stack<Character>();
            Stack<Character>bk=new Stack<Character>();
            for(char c:chars){
                if(Character.isDigit(c)){
                    bk.push(c);
                }else {
                    if(stack.size()!=0){
                        if(c==')'){
                            while (stack.peek()!='('){
                                bk.push(stack.pop());
                            }
                            stack.pop();
                        }
                        if(c=='+'||c=='-'){
                            while (!stack.empty()&&stack.peek()!='('){
                                bk.push(stack.pop());
                            }
                            stack.push(c);
                        }
                        if(c=='*'||c=='/'){
                            while (!stack.empty()&&(stack.peek()=='*'||stack.peek()=='/')){
                                bk.push(stack.pop());
                            }
                            stack.push(c);
                        }
                        if(c=='('){
                            stack.push(c);
                        }
                    }else {
                        stack.push(c);
                    }
                }

            }
            while (stack.size()!=0){
                bk.push(stack.pop());
            }

            Stack<Integer>cal=new Stack<>();
            for (char c : bk) {
                if(Character.isDigit(c)){
                    cal.push(Integer.parseInt(String.valueOf(c)));
                }else {
                    if(c=='+'){
                        int a =cal.pop();
                        int b=cal.pop();
                        cal.push(a+b);
                    }
                    if(c=='-'){
                        int a =cal.pop();
                        int b=cal.pop();
                        cal.push(b-a);
                    }
                    if(c=='*'){
                        int a =cal.pop();
                        int b=cal.pop();
                        cal.push(b*a);
                    }
                    if(c=='/'){
                        int a =cal.pop();
                        int b=cal.pop();
                        cal.push(b/a);
                    }
                }
            }
            System.out.println(cal.toString());
        }

    }
}
