package medium;

public class ComputeRightSiblingTreeForPerfectBT_116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input [-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]
		//Output [-1,#,0,1,#,2,3,4,5,#,6,7,8,9,10,11,12,13,#]
		Node root = new Node(-1);
		root.left=new Node(0);
		root.right=new Node(1);
		root.left.left=new Node(2);
		root.left.right=new Node(3);
		root.right.left=new Node(4);
		root.right.right=new Node(5);
		root.left.left.left=new Node(6);
		root.left.left.right=new Node(7);
		root.left.right.left=new Node(8);
		root.left.right.right=new Node(9);
		root.right.left.left=new Node(10);
		root.right.left.right=new Node(11);
		root.right.right.left=new Node(12);
		root.right.right.right=new Node(13);
		Node res = connect(root);
		System.out.println(res.val);
	}

	    public static Node connect(Node root) {
	        if(root == null)
	            return null;
	        root.next= null;
	        Node cur = root;
	        Node levelStart = root;
	        while(cur!=null){
	            //if left child -> next = right child
	            if(cur.left!=null)
	                cur.left.next = cur.right;
	            if(cur.right!= null && cur.next!=null){
	                cur.right.next = cur.next.left;
	            }
	            if(cur.next != null){
	                cur = cur.next;
	            }else{
	                cur = levelStart.left;
	                levelStart =levelStart.left ;
	            }
	        }
	        return root;
	        
	    }
	    
		static class Node {
		    public int val;
		    public Node left;
		    public Node right;
		    public Node next;

		    public Node() {}
		    
		    public Node(int _val) {
		        val = _val;
		    }

		    public Node(int _val, Node _left, Node _right, Node _next) {
		        val = _val;
		        left = _left;
		        right = _right;
		        next = _next;
		    }
		};
		
		

}
