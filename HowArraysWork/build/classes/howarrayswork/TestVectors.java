package howarrayswork;

public class TestVectors {

    public static void main(String[] args){

        Vectors v = new Vectors();
        v.AddElement(445.0);
        v.AddElement(45);
        v.AddElement("Hello World");
        v.AddElement(true);
        v.AddElement(Integer.hashCode(445));

        System.out.println(v);

        v.RemoveElementAtIndex(4);
        v.RemoveElement(45);
        System.out.println(v);

        Vectors vec = new Vectors();

        for(int i = 0; i < 100; i++){
            vec.AddElement(i);
        }

        for(int i = 0; i < 100; i++){
            vec.AddElement(100+ i * 5 + Math.random());
        }

        System.out.println(vec.size + " " + vec);

    }
}
