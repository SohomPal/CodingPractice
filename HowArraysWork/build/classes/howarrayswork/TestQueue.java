package howarrayswork;

public class TestQueue {
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        System.out.println(q.element() + " Is the queue empty: " + q.empty());
        q.remove();
        q.remove();
        System.out.println(q);
    }
}
