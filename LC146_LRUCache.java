package leetcode_study;

import java.util.HashMap;

/**
 * Design a LRU Cache. with 2 methods (get, put).
 * 
 * [Approach] using DLL + HashMap
 * nested class: DLNode => prev, next, key, val
 * field: head, prev, HashMap.
 * 
 * @author Sunny Park
 *
 */
public class LC146_LRUCache {
   private static class DLNode {
       int key;
       int val;
       DLNode prev;
       DLNode next;
       
       DLNode() {
           this.key = -1;
           this.val = -1;
       }
       
       DLNode(int key, int val) {
           this.key = key;
           this.val = val;
       }
       
       @Override
       public String toString() {
           return String.valueOf(key + "/" + val);
       }
   }
   
   HashMap<Integer, DLNode> map;
   DLNode head;
   DLNode tail;
   int capacity;
   int size;
   
   LC146_LRUCache(int capacity) {
       map = new HashMap<>();
       head = new DLNode();
       tail = new DLNode();
       head.next = tail;
       tail.prev = head;
       this.capacity = capacity;
       this.size = 0;
   }
   
   public void put(int key, int val) {
       DLNode curr = map.get(key);
       if (curr == null) {
           DLNode newNode = new DLNode(key, val);
           map.put(key, newNode);
           addNode(newNode);
           size++;
           if (size > capacity) {
               DLNode tail = popTail();
               map.remove(tail.key);
               size--;
           }
       } else {
           curr.val = val;
           map.put(key, curr);
           moveToHead(curr);
       }
   }
   
   public int get(int key) {
       if (!map.containsKey(key)) return -1;
       DLNode target = map.get(key);
       moveToHead(target);
       map.entrySet().stream().forEach(e -> System.out.println(e));
       return target.val;
   }
   
   private void addNode(DLNode node) {
       node.prev = head;
       node.next = head.next;
       
       head.next.prev = node;
       head.next = node;
   }
   private void moveToHead(DLNode node) {
       removeNode(node);
       addNode(node);
   }
   
   private DLNode popTail() {
       DLNode toPop = tail.prev;
       removeNode(toPop);
       return toPop;
   }
   
   private void removeNode(DLNode node) {
       DLNode prev = node.prev;
       DLNode next = node.next;
       prev.next = next;
       next.prev= prev;
   }
   
   public static void main(String[] args) {
       LC146_LRUCache cache = new LC146_LRUCache(2);
       cache.put(1, 1);
       cache.put(2, 2);
       System.out.println(cache.get(1));
       cache.put(3, 3);    // evicts key 2
       System.out.println(cache.get(2));  // returns -1 (not found)
       cache.put(4, 4);    // evicts key 1
       System.out.println(cache.get(1));       // returns -1 (not found)
       cache.get(3);       // returns 3
       cache.get(4);       // returns 4
   }
   
}