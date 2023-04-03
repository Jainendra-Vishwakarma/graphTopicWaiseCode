import java.util.*;
public class Minimum_Depth_of_BinaryTree {
    static class Node {
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int minDepth(Node root){
        if(root == null){
            return 0;
        }

        int minDepth = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);


        while(!q.isEmpty()){
            Node current = q.poll();

            if(current != null){
                if(current.left == null && current.right == null)
                    return minDepth;

                if(current.left != null)
                    q.add(current.left);

                if(current.right != null)
                    q.add(current.right);
            }
            else{
                if(!q.isEmpty()){
                    minDepth++;
                    q.add(null);
                }
            }
        }
        return minDepth;

        //OR


//        if (root== null){
//            return 0;
//        }
//        if (root.left == null && root.right == null){
//            return 1;
//        }
//        if (root.left == null || root.right == null){
//            return 1+Math.max(minDepth(root.left),minDepth(root.right));
//        }
//        return 1 + Math.min(minDepth(root.left),minDepth(root.right));

        //OR


//        if (root ==  null){
//            return 0;
//        }
//        Queue<qItem> q = new LinkedList<>();
//        qItem qi = new qItem(root, 1);
//        q.add(qi);
//        while (!q.isEmpty()){
//            qi = q.peek();
//            q.remove();
//            Node node = qi.node;
//            int depth = qi.depth;
//            if (node.left == null && node.right == null){
//                return depth;
//            }
//            if (node.left != null){
//                qi.node = node.left;
//                qi.depth = depth+1;
//                q.add(qi);
//            }
//            if (node.right != null){
//                qi.node = node.right;
//                qi.depth = depth + 1;
//                q.add(qi);
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(minDepth(root));

    }

}
