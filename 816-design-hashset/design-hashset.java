class MyHashSet {
    private static class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
            this.next = null;
        }
    }
    
    private ListNode[] buckets;
    
    public MyHashSet() {
        buckets = new ListNode[10000];
        for (int i = 0; i < 10000; i++) {
            buckets[i] = new ListNode(0);
        }
    }
    
    private int hash(int key) {
        return key % 10000;
    }
    
    public void add(int key) {
        int idx = hash(key);
        ListNode curr = buckets[idx];
        while (curr.next != null) {
            if (curr.next.key == key) return;
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int idx = hash(key);
        ListNode curr = buckets[idx];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int idx = hash(key);
        ListNode curr = buckets[idx];
        while (curr.next != null) {
            if (curr.next.key == key) return true;
            curr = curr.next;
        }
        return false;
    }
}