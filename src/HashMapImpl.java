public class HashMapImpl {
    class AnEntry{
        String key;
        Integer value;

        public AnEntry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    class AnNode{
        AnEntry value;
        AnEntry next;
    }

    AnNode[] Bucket;
    int size;
    int capacity;
    float loadFactor;
    public static final int INITIAL_CAPACITY = 11;
    public static final float INITIAL_LOAD_FACTOR = 0.75f;

    // need to implement method:
    //constructor
    //size
    //put
    //get


    public HashMapImpl() {
        this(INITIAL_CAPACITY,INITIAL_LOAD_FACTOR);
    }

    public HashMapImpl(int capacity, float loadFactor) {
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        Bucket = new AnNode[capacity];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Integer put(String key, Integer Value){
        //get hashvalue and mod
        AnNode curBucket = Bucket[getBucketNum(key.hashCode())];
        while (curBucket!= null){}

        return 1;
    }
    private int getBucketNum(int origHashCode){
        return Math.abs(origHashCode % capacity);
    }

}
