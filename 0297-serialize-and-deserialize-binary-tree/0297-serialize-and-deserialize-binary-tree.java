/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
        ArrayList <String>arr=new ArrayList<String>();
        Queue <TreeNode>queue=new LinkedList<TreeNode>();
        queue.add(root);
        arr.add(String.valueOf(root.val));
        while(!queue.isEmpty()){
            root=queue.poll();
            if(root.left!=null){
                arr.add(String.valueOf(root.left.val));
                queue.add(root.left);
            }
            else{
                arr.add("null");
            }
            if(root.right!=null){
                arr.add(String.valueOf(root.right.val));
                queue.add(root.right);
            }
            else{
                arr.add("null");
            }     
        }
        String ans=String.join(" ",arr);
        System.out.println(ans);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        
        String []dataArr = data.split(" ");
        System.out.println(Arrays.toString(dataArr));

        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        TreeNode head=new TreeNode(Integer.parseInt(dataArr[0]));
        TreeNode root=null;
        queue.add(head);
        int i=1;
        while(!queue.isEmpty()){
            root=queue.poll();
            if(i<dataArr.length && (!dataArr[i].equals("null"))){
                root.left=new TreeNode(Integer.parseInt(dataArr[i]));
                queue.add(root.left);
            }
            i++;  
            if(i<dataArr.length && (!dataArr[i].equals("null"))){
                root.right=new TreeNode(Integer.parseInt(dataArr[i]));
                queue.add(root.right);
            }
            i++;
        }

        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));