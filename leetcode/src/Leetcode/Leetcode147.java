package Leetcode;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:

滑动窗口的位置 最大值

[1 3 -1] -3 5 3 6 7 3
1 [3 -1 -3] 5 3 6 7 3
1 3 [-1 -3 5] 3 6 7 5
1 3 -1 [-3 5 3] 6 7 5
1 3 -1 -3 [5 3 6] 7 6
1 3 -1 -3 5 [3 6 7] 7

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

进阶：

你能在线性时间复杂度内解决此题吗？

来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class Leetcode147 {

	private static class Node {
		public Node next;
		public int data;

		public Node(Node next, int data) {
			this.next = next;
			this.data = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node p = this;
			while (p != null) {
				sb.append(p.data + "->");
				p = p.next;
			}
			String string = sb.toString();
			return string.substring(0, string.length() - 2);
		}

	}

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test2() {
		Node head = new Node(new Node(new Node(new Node(null, 3), 1), 2), 4);
		Node sorted = sort(head);
		System.out.println(sorted);
	}

	private static void test1() {
		Node head = new Node(new Node(new Node(new Node(new Node(null, 0), 4), 3), 5), -1);
		Node sorted = sort(head);
		System.out.println(sorted);
	}

	private static Node sort(Node head) {
		Node sortedL, sortedR;
		sortedL = head;
		sortedR = head;
		Node current = head;
		while (sortedR.next != null) {
			current = sortedR.next;
			if (current.data < sortedL.data) {
				sortedR.next = current.next;
				current.next = sortedL;
				sortedL = current;
			} else if (sortedL.data <= current.data && current.data < sortedR.data) {
				Node p = sortedL;
				while (p != sortedR) {
					if (p.data <= current.data && current.data < p.next.data) {
						sortedR.next = current.next;
						current.next = p.next;
						p.next = current;
						break;
					}
					p = p.next;
				}
			} else {
				sortedR = current;
			}

		}
		return sortedL;
	}
}
