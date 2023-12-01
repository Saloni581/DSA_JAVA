import java.util.*;

public class HashMapCode {
    
    static class HashMap<K,V> {   //generic (generic parametarized form = can be String, Int, Boolean, Float etc.)

        private class Node {
            K key;
            V val;
            //Constructor
            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        private int n;   //Total no. of Nodes in Buckets[] = n
        private int N;   //Size of the bucket || (bucket.length)
        private LinkedList<Node> buckets[];  // Array of LinkedList = N = buckets.length || HashMap

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
               buckets[i] = new LinkedList<>();
            }
        }


        //⭐ 
        public int hashFun(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        //⭐
        private int searchInLL(K key, int bucketIdx) {
            LinkedList<Node> ll = buckets[bucketIdx];
            int dataIdx = 0;
            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return dataIdx;
                }
                dataIdx++;
            }
            return -1;
        }

        //⭐
        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldSize[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            //Nodes -> add in bucket
            for(int i=0; i<oldSize.length; i++) {
                LinkedList<Node> ll = oldSize[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.val);
                }
            }
        }
        public void put(K key, V val) {
            int bucketIdx = hashFun(key);
            int dataIdx = searchInLL(key, bucketIdx);
            if(dataIdx != -1) { //Node exist - valid Node
                Node node = buckets[bucketIdx].get(dataIdx);
                node.val = val;
            }
            else {
                buckets[bucketIdx].add(new Node(key, val));
                n++;
            }

            //ReHashing 
            double lambda = (double)n / N;
            if(lambda > 2.0) {
                reHash();
            }
        }


        //ContainsKey()
        public boolean containsKey(K key) {
            int bucketIdx = hashFun(key);
            int dataIdx = searchInLL(key, bucketIdx);

            if(dataIdx != -1) {
                return true;
            }
            return false;
        }

        //get()
        public V get(K key) {
            int bucketIdx = hashFun(key);
            int dataIdx = searchInLL(key, bucketIdx);
            if(dataIdx != -1) {
                Node node = buckets[bucketIdx].get(dataIdx);
                return node.val;
            }
            else return null;
        }


        //remove()
        public V remove(K key) {
            int bucketIdx = hashFun(key);
            int dataIdx = searchInLL(key, bucketIdx);

            if(dataIdx != -1) {
                Node node = buckets[bucketIdx].remove(dataIdx);
                n--; //Decreasing the size of LinkedList
                return node.val;
            }
            return null;
        }

        //keySet()
        public ArrayList<K> keySet() {
               ArrayList<K> keys = new ArrayList<>();
               for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                 for (Node node : ll) {
                    keys.add(node.key);
                 }
               }
               return keys;
        }

        //isEmpty()
        public boolean isEmpty() {
           return  n == 0; //if Size is equal to zero Means my HAshMap is Empty
        }
    }
    public static void main(String args[]) {
           HashMap<String, Integer> hm = new HashMap<>();
           hm.put("India", 500);
           hm.put("Canada", 200);
           hm.put("USA", 100);
           hm.put("UK", 300);
           ArrayList<String> keys = hm.keySet();
           for (String key : keys) {
               System.out.println(key);
           }
           System.out.println(hm.get("UK"));
           System.out.println(hm.remove("UK"));
           System.out.println(hm.containsKey("UK"));

    }
}
