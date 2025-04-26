class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start=0;
    private int end=0;
    private int count=0;
    public CircularBuffer(int size) {
        this.size=size;
        buffer=new int[size];
    }
    public void add(int value) {
        buffer[end]=value;
        end=(end+1)%size;
        if (count==size) {
            start=(start+1)%size;
        } else {
            count++;
        }
    }
    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(start+i)%size]);
            if (i!=count-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer cb=new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.printBuffer();
        cb.add(4);;
        cb.printBuffer();
        cb.add(5);
        cb.printBuffer();
    }
}