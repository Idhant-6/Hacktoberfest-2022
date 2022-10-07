import java.util.ArrayList;

public class BinaryTree {
	  Node root;
	    BinaryTree(int key) 
	    { 
	        root = new Node(key); 
	    }
	  
	    BinaryTree() 
	    { 
	        root = null;
	    }
	    //To print right view of binary tree.
	    static void rightview(Node w)
		{
			ArrayList<Node> c=new ArrayList<>();
			newrightView(w,c,0);
			for(Node e:c)
			{
				System.out.println(e.data);
			}
		}
		static void newrightView(Node c,ArrayList n,int l)
		{
			if(c==null)
				return;
			if(n.size()==l)
				n.add(c);
			newrightView(c.right,n,l+1);
			newrightView(c.left,n,l+1);
			
				
		}
	    // TO PRINT LEFT VIEW OF BINARY TREE.
	    static void leftview(Node w)
		{
			ArrayList<Node> c=new ArrayList<>();
			newleftView(w,c,0);
			for(Node e:c)
			{
				System.out.println(e.data);
			}
		}
	    static void newleftView(Node c,ArrayList n,int l)
		{
			if(c==null)
				return;
			if(n.size()==l)
				n.add(c);
			newleftView(c.left,n,l+1);
			newleftView(c.right,n,l+1);
		}
			

	public static void main(String[] args) {
		BinaryTree n = new BinaryTree();
        n.root = new Node(12);
        n.root.left = new Node(45);
        n.root.right = new Node(46);
        n.root.left.left = new Node(27);
        n.root.left.right=new Node(30);
        System.out.println("Left View of BinaryTree");
        leftview(n.root);
        System.out.println("Right view of Binary Tree");
        rightview(n.root);

	}

}
 class Node{
	Node right,left;
	int data;
	Node(int data)
	{
		this.data=data;
		this.left=this.right=null;
	}
}