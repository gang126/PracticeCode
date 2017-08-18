package binarytree;

public class linktest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node link = getNode();
		 //Node relink = getreNode1(link);
		Node relink = reverseList2(link);

		System.out.println(relink.value);
		System.out.println(relink.nextNode.value);
		System.out.println(relink.nextNode.nextNode.value);
		System.out.println(relink.nextNode.nextNode.nextNode.value);
		/*System.out.println(relink.nextNode.nextNode.nextNode.nextNode.value);
		System.out.println(relink.nextNode.nextNode.nextNode.nextNode.nextNode.value);
*/
	}

	public static Node getNode() {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
	/*	Node node5 = new Node(5);
		Node node6 = new Node(6);

		node5.nextNode = node6;
		node4.nextNode = node5;*/
		node3.nextNode = node4;
		node2.nextNode = node3;
		node1.nextNode = node2;

		return node1;
	}

	public static Node getreNode1(Node link) {

		if (link == null || link.nextNode == null) {
			return link;
		}
		Node reHead = getreNode1(link.nextNode);
		link.nextNode.nextNode = link;
		//link.nextNode = null;
		return reHead;

	}

	// 2.�½�����,ͷ�ڵ���뷨
	public static Node reverseList2(Node head) {
		Node dummy = new Node(-1);
		Node pCur = head;
		//形成一个新的链表  -1 -> 1 -> null
		while (pCur != null) {
			Node pNex = pCur.nextNode;
			pCur.nextNode = dummy.nextNode;
			dummy.nextNode = pCur;
			//把2当做第一个索引
			pCur = pNex;
		}
		return dummy.nextNode;
	}

	// 1.�͵ط�ת��
	public static Node reverseList3(Node head) {
		if (head == null)
			return head;
		Node dummy = new Node(-1);
		dummy.nextNode = head;
		//Node prev = head;
		Node prev = dummy.nextNode;
		Node pCur = prev.nextNode;
		//2和1进行交换      -1, 2, 1, 3, 4
		while (pCur != null) {
			prev.nextNode = pCur.nextNode;
			pCur.nextNode = dummy.nextNode;
			dummy.nextNode = pCur;
			//3是下一个要交换的数
			pCur = prev.nextNode;
		}
		return dummy.nextNode;
	}
	
	 public static Node reverseList4(Node head) {
	        Node prev = null;
	        while (head != null) {
	            Node temp = head.nextNode;
	            head.nextNode = prev;
	            prev = head;
	            head = temp;
	        }
	        return prev;
	    }

}
