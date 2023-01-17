package howarrayswork;

public class Queue{

    Vectors queue;
    int maxSize = Integer.MAX_VALUE;
    public Queue(){
        queue = new Vectors();
    }

    public Queue(int maxSize){
        queue = new Vectors();
        this.maxSize = maxSize;
    }

    public void add(Object obj){
        if(queue.size >= maxSize){
            return;
        }
        queue.AddElement(obj);
    }

    public void remove(){
        queue.RemoveElementAtIndex(0);
    }

    public void poll(){
        if(empty()){
            return;
        }
        else{
            remove();
        }
    }

    public Object element(){
        return queue.ElementAtIndex(0);
    }

    public boolean empty(){
        if(queue.size == 0){
            return true;
        }
        return false;
    }

    public int search(Object obj){
        return queue.IndexOf(obj);

    }

    public String toString(){
        return queue.toString();
    }

}
