public class Counter {
    private int count;

    public Counter(int initialCount){
        this.count = initialCount;
    }

    public void increment(){
        count++;
    }

    public void reset(){
        count = 0;
    }

    public int getCount(){
        return count;
    }
}
