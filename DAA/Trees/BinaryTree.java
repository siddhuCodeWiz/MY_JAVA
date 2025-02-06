package DAA.Trees;

/*In a joint family, every person assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

You will be given the family tree,
your task is to find and print the person ID, who is only child to his/her parent.
i.e, the person with no siblings. Print all such person ID's in ascending order.

NOTE: 
	- If only one person is there in the family, please consider him as a parent.
	- In the given tree, please consider '-1' as null.

Input Format:
-------------
Line-1: Space separated integers, person ID's in the family.

Output Format:
--------------
Line-1: Print the list of person IDs in ascending order.


Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
[5]

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 44 33 -1 -1 22

Sample Output-2:
----------------
[77, 66, 55, 44, 33, 22] */

import java.util.*;
public class BinaryTree {
    public static TreeNode buildTree(int[] list){
        Queue<TreeNode> bt = new LinkedList<>();
        int i=0;
        TreeNode head = new TreeNode(list[i]);
        bt.add(head);
        i++;
        while(!bt.isEmpty()){
            TreeNode curr = bt.poll();
            if(i<list.length){
                // if(curr.left!=null && curr.left.data!=-1){
                //     curr.left = new TreeNode(list[i]);
                // }
                // curr.left = new TreeNode(list[i]!=-1?list[i]:-1);
                // curr.left = new TreeNode(list[i]);
                if(list[i]==-1){
                    curr.left=null;
                } else{
                    curr.left = new TreeNode(list[i]);
                    bt.add(curr.left);
                }
                
                i++;
                // if(curr.right!=null && curr.right.data!=-1){
                //     curr.right = new TreeNode(list[i]);
                // }
                // curr.right = new TreeNode(list[i]!=-1?list[i]:-1);
                // curr.left = new TreeNode(list[i]);
                if(list[i]==-1){
                    curr.right=null;
                } else{
                    curr.right = new TreeNode(list[i]);
                    bt.add(curr.right);
                }    
                i++;
            }
        }
        return head;
    }

    public static void printTree(TreeNode head){
        Queue<TreeNode> bt = new LinkedList<>();
        bt.add(head);

        while(!bt.isEmpty()){
            TreeNode curr = bt.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null) bt.add(curr.left);
            if(curr.right!=null) bt.add(curr.right);
        }
        System.out.println();
    }

    public static void getLonelyNodes(TreeNode head){
        ArrayList<TreeNode> sol = new ArrayList<>();
        Queue<TreeNode> bt = new LinkedList<>();
        bt.add(head);

        while(!bt.isEmpty()){
            TreeNode curr = bt.poll();
            if(curr.left==null || curr.right==null){
                if(curr.left!=null) sol.add(curr.left);
                if(curr.right!=null) sol.add(curr.right);
            }
            if(curr.left!=null) bt.add(curr.left);
            if(curr.right!=null) bt.add(curr.right);
        }

        for(TreeNode t : sol){
            System.out.print(t.data+" ");
        }
    }
    public static void main(String[] args) {
        // 11 99 88 77 -1 -1 66 55 -1 -1 44 33 -1 -1 22
        int[] list = {11, 99, 88, 77, -1, -1, 66, 55, -1, -1, 44, 33, -1, -1, 22};
        TreeNode head = buildTree(list);
        System.out.println(head.data);
        printTree(head);
        getLonelyNodes(head);
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}