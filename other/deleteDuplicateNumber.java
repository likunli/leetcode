import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    static ListNode deleteDuplicate(ListNode head) {
        Set<Integer> st = new HashSet<>();

        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (!st.contains(cur.val)) {
                st.add(cur.val);
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    // delete the duplicate number in a linkedlist
    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 5, 7, 8, 8, 8, 9, 9, 10 }; 
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            pre.next = node;
            pre = node;
        }

        head = deleteDuplicate(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


// singleton model 
class Service {

    private static Service instance = new Service();

    private Service() {

    }

    public static getInstance() {
        return instance;
    };
}

// factory model
public interface Shape {
    void draw();
}

public class Rectangle implements Shape {
    @Override 
    public void draw() {
        System.out.println("I am a Rectangle");
    }
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am a Circle");
    }
}

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.isEmpty()) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle") {
            return new Rectangle();
        } else {
            return null;
        }
    }
}