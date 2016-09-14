import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {
		
		TreeNode f =new TreeNode(3,null,null);
		TreeNode e =new TreeNode(1,null,null);
		TreeNode c =new TreeNode(6,null,null);
		TreeNode d= new TreeNode(2,e,f);
		e.parent=d;f.parent=d;
		TreeNode b= new TreeNode(4,d,null);
		d.parent=b;
		TreeNode a= new TreeNode(5,b,c);
		b.parent=a;c.parent=a;
		
		TreeNode x=new TreeNode(1,null,null);
		System.out.println(isSubTree2(b, d));
		
	}
	
	//T1, with millions of nodes; T2, with hundreds of nodes
	public static boolean isSubtree(TreeNode t1, TreeNode t2){
		if(t2==null)return true;
		
		LinkedList<TreeNode> l=new LinkedList<>();//BFS
		
		if(t1!=null)l.add(t1);
		while(!l.isEmpty()){
			TreeNode t=l.removeFirst();
			if(t.data==t2.data){
				if(isTreeMatch(t, t2))return true;
			}
			if(t.left!=null)l.add(t.left);
			if(t.right!=null)l.add(t.right);
		}		
		return false;
	}
	
	public static boolean isSubTree2(TreeNode t1, TreeNode t2){
		if(t1==null)return false;
		if(t1.data==t2.data){
			if(isTreeMatch(t1,t2))return true;
		}
		return isSubTree2(t1.left,t2) || isSubTree2(t1.right,t2);
	}
	
	public static boolean containsTree(TreeNode t1, TreeNode t2){
		if(t2==null)return true;
		return isSubTree2(t1,t2);
	}
	
	public static boolean isTreeMatch(TreeNode t, TreeNode t2){
		if(t==null && t2==null)return true;
		if(t==null || t2==null)return false;
		if(t.data==t2.data){
			return isTreeMatch(t.left, t2.left) && isTreeMatch(t.right, t2.right);
		}else{
			return false;
		}
	}

}
