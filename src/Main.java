import java.util.List;

public class Main {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    public static Node merge(List<Node> heads) {
        // array[i] 作为下标，标识遍历到了heads[i]的那个节点
        Node[] array = new Node[heads.size()];
        Node result = new Node(-1);

        // 将每个链表的头节点复制给数组
        for (int i = 0; i < array.length; i++) {
            array[i] = heads.get(i);
        }

        // 找到数组中最小的array[i]中最小的一个的

        // 退出循环的条件是，每个array[i]都是null
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    continue;
                }
                if (array[i].val < minValue) {
                    minValue = array[i].val;
                    index = i;
                }
            }
            if (minValue == Integer.MAX_VALUE) {
                // minValue值没有改变说明每个array[i]都是空
                break;
            }
            result.next = array[index];
            array[index] = array[index].next;
        }

        return result.next;
    }


    public static void main(String[] args) {

    }
}
