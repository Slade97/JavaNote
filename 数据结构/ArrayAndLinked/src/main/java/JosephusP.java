import java.util.Scanner;


/**
 * @author : jeasion
 * @name
 * @comment
 * @return
 */
public class JosephusP {
    public static void main(String[] args) {
        int N = 0;
        int M = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("N:");
        N = s.nextInt();
        System.out.print("M:");
        M = s.nextInt();
        Josephus josephus = new Josephus();
        josephus.dead(M, N);
    }

}

class Josephus {
    int person;
    Josephus next;
    Josephus pointer;//用于出队第M人

    public void dead(int m, int n) {
        int M = m;
        int N = n;
        Josephus josephus = new Josephus();
        pointer = josephus;

        //构建循环链表
        for (int i = 0; i < N; i++) {
            josephus.person = i;
            josephus.next = new Josephus();
            josephus = josephus.next;
        }
        josephus = pointer;
        while (josephus.next.next != null) {
            josephus = josephus.next;
        }
        josephus.next = pointer;

        int count = m - 1;
        System.out.print("死亡名单：");
        while(!pointer.next.equals(pointer)) {
            count--;
            Josephus before = pointer; //记录出队前的人，便于以后使其指向M+1的人
            pointer = pointer.next;
            if (count == 0) {
                System.out.print(pointer.person + "  ");
                before.next = pointer.next;
                pointer.next = null;
                pointer = before.next;
                count = m - 1;
            }
        }
        System.out.println("\n幸存者："+pointer.person);
    }

}