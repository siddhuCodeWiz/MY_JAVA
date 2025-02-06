package DAA.Trees;

import java.util.*;


public class AverageOfLevels
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) 
		{
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		AverageOfLevels ln=new AverageOfLevels();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.averageOfLevels(root));
	}
}

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution 
{
	public List<Integer> averageOfLevels(BinaryTreeNode root) 
	{
		Queue<BinaryTreeNode> q = new LinkedList<>();
        List<Integer> avgs = new ArrayList<>();
        
		q.add(root);
		Integer largest;
		while(!q.isEmpty()){
		    int siz = q.size();
		    largest = -1;
		    for(int i=0; i<siz; i++){
		        BinaryTreeNode rem = q.poll();
		        if(largest<rem.data) largest = rem.data;
		        if(rem.left!=null){
		            if(rem.left.data != -1)
		                q.add(rem.left);
		        } if(rem.right!=null){
		            if(rem.right.data!=-1)
		                q.add(rem.right);
		        }
		    }
		    avgs.add(largest);
		}
		return avgs;
	}
}


