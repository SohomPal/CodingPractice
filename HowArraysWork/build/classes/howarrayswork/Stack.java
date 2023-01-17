package howarrayswork;

public class Stack{

    Vectors stack;
    int maxSize = Integer.MAX_VALUE;
    public Stack(){
        stack = new Vectors();
    }

    public Stack(int maxSize){
        stack = new Vectors();
        this.maxSize = maxSize;
    }

    public void push(Object obj){
        if(stack.size >= maxSize){
            return;
        }
        stack.AddElement(obj);
    }

    public void pop(){
        stack.RemoveElementAtIndex(stack.size -1);
    }

    public Object peek(){
        return stack.ElementAtIndex(stack.size -1);
    }

    public boolean empty(){
        if(stack.size == 0){
            return true;
        }
        return false;
    }

    public int search(Object obj){
        return stack.IndexOf(obj);

    }

    public String toString(){
        return stack.toString();
    }

}
