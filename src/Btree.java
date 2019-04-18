class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
        left= null;
        right = null;
    }
}



public class Btree {

    public static Node insert(Node root, Node newnode)
    {
        if(root == null)
        {
            root = newnode;
            return root;
        }
        if(root.data>newnode.data)
        {
            if(root.left == null)
            {
                root.left = newnode;

            }
            else
            {
                insert(root.left, newnode);
            }
        }

        if(root.data<newnode.data)
        {
            if(root.right == null)
            {
                root.right = newnode;

            }
            else
            {
                insert(root.right, newnode);
            }
        }
        return root;
    }

    public static void inorderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + "--"  );
        inorderTraversal(root.right);
    }

    public static Node delete(Node root, int data)
    {
        if(root == null)
        {
            return null;
        }
        if(data<root.data)
        {
            root.left = delete(root.left, data);
        }
        else if(data>root.data)
        {
            root.right = delete(root.right,data);
        }
        else
        {
            if(root.left == null || root.right == null)
            {
                Node temp= null;
                temp = root.left==null? root.right: root.left;
                if(temp ==null)
                {
                    return null;
                }
                else
                {
                    return temp;
                }
            }
            else
            {
                Node successor = getsuccessor(root);
                root.data = successor.data;
                root.right= delete(root.right, root.data);
                return root;
            }
        }
        return root;
    }


    public static Node getsuccessor(Node node)
    {
        if(node == null)
        {
            return null;
        }

        Node temp = node.right;

        while(temp.left!= null)
        {
            temp = temp.left;
        }
        return temp;
    }
    public static void main(String[] args) {

        Node rootnode = new Node(10);
        insert(null,rootnode);
        insert(rootnode,new Node(20));
        insert(rootnode,new Node(5));
        insert(rootnode,new Node(40));
        insert(rootnode,new Node(7));
        insert(rootnode,new Node(32));
        insert(rootnode,new Node(56));
        inorderTraversal(rootnode);
        delete(rootnode, 40);
        System.out.println();
        inorderTraversal(rootnode);



    }



}
