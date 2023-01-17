package howarrayswork;

public class Vectors {
    private Object[] vector;
    int size = 0;
    public Vectors(){
        vector = new Object[10];
    }

    public void AddElement(Object element){
        if(size == vector.length){
            vector = IncreaseArraySize(vector);
        }
        vector[size] = element;
        size++;
    }

    private Object[] IncreaseArraySize(Object[] arr){
        Object[] newArray = new Object[arr.length + 10];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }
        return newArray;
    }

    public void RemoveElementAtIndex(int index){

        for(int i = index; i < size; i++){
            vector[i] = vector[i+1];
        }

        vector[size] = null;
        size --;
    }

    public Object ElementAtIndex(int index){
        return vector[index];
    }

    public int IndexOf(Object obj){
        for(int i = 0; i < size; i++){
            if(obj == vector[i]){
                return i;
            }
        }
        return -1;
    }

    public void RemoveElement(Object obj){
        int index = IndexOf(obj);
        if(index != -1){
            RemoveElementAtIndex(index);
        }
    }

    public String toString(){
        String answer = "[";
        for(int i = 0; i < size-1; i++){
            answer = answer + vector[i] + ", ";
        }
        answer = answer + vector[size - 1];
        answer = answer + "]";
        return answer;
    }

}
