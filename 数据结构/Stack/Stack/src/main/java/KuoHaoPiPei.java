import java.util.Scanner;

public class KuoHaoPiPei {
    public static boolean isOk(String s) {
        MyStack<Character> brackets = new ArrayStack<Character>(20);
        char c[] = s.toCharArray();
        Character top;
        for (char x : c) {
            switch (x) {
                case '{':
                case '(':
                case '[':
                    brackets.push(x);//o[1]
                    break;
                case '}':
                    top = brackets.pop();//o[1]
                    if (top == null) return false;
                    if (top == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    top = brackets.pop();
                    if (top == null) return false;
                    if (top == '(') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    top = brackets.pop();
                    if (top == null) return false;
                    if (top == '[') {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            System.out.println(isOk(sc.nextLine()));
        }

    }
}
