import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by usna on 26/10/2017.
 * 定容栈&泛型
 */
public class AP20171026 {

    public static void main(String arg[]){
        FixedCapacityStacKOfStrings s = new FixedCapacityStacKOfStrings(100);
        //FixedCapacityStacK<String> f=new FixedCapacityStacK<String>(100);
        while (!StdIn.isEmpty()){
            String item=StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
                // p.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop()+"");
        }
        StdOut.println(s.size());



    }
}
class FixedCapacityStacKOfStrings{
    private String[] a;
    private int N;
    public FixedCapacityStacKOfStrings(int cap){
        a=new String[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }
}
class FixedCapacityStacK<Item>{
    private Item[] a;
    private int N;
    public FixedCapacityStacK(int cap){
        a=(Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        a[N++] = item;
    }
    public Item pop(){
        return a[--N];
    }
}
//下压栈，动态调整数组大小
abstract class ResizingArrayStack<Item> implements  Iterator<Item>{
    private Item[] a=(Item[])new Object[1];
    private int N=0;
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    private  void resize(int max){
        Item[] temp=(Item[]) new Object[max];
        for (int i=0; i<N;i++)
            temp[i]=a[i];
        a=temp;
    }
    public void push(Item item){
        if(N==a.length) resize(2*a.length);
        a[N++]=item;
    }
    public Item pop(){
        Item item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4) resize(a.length/2);
        return item;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        public boolean hasNext() {
            return i>0;
        }
        public  Item next(){
            return a[--i];
        }
        public  void remove(){}
    }

}