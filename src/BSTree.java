
public class BSTree {
    protected Node root;
    protected void visit(Node p) {
        System.out.print(p.key + " ");
    }
    public BSTree() {
        root = null;
    }
    public Node search(int el) {
        return search(root,el);
    }
    protected Node search(Node p, int el) {
        while (p != null)
            if (el == p.key)
                return p;
            else if (el < p.key)
                p = p.left;
            else p = p.right;
        return null;
    }
    public void breadthFirst() {

    }
    public void preorder() {
        preorder(root);
    }
    protected void preorder(Node p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }
    public void inorder() {
        inorder(root);
    }
    protected void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    public void postorder() {
        postorder(root);
    }
    protected void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }

    public void insert(int el) {
        Node p = root, prev = null;
        while (p != null) {  // find a place for inserting new node;
            prev = p;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        if (root == null)    // tree is empty;
            root = new Node(el);
        else if (prev.key < el)
            prev.right = new Node(el);
        else prev.left  = new Node(el);
    }
    public void deleteByCopying(int el) {
        Node node, p = root, prev = null;
        while (p != null && p.key != el) {       // find the node p
            prev = p;                            // with element el;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null)              // node has no right child;
                node = node.left;
            else if (node.left == null)          // no left child for node;
                node = node.right;
            else {
                Node tmp = node.left;     // node has both children;
                Node previous = node;     // 1.
                while (tmp.right != null) {     // 2. find the rightmost
                    previous = tmp;             //    position in the
                    tmp = tmp.right;            //    left subtree of node;
                }
                node.key = tmp.key;             // 3. overwrite the reference
                if (previous == node)           //    of the key being deleted;
                    previous.left  = tmp.left; // 4.
                else previous.right = tmp.left; // 5.
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    public void deleteByMerging(int el) {
        Node tmp, node, p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p;                      // with element el;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child: its left
                node = node.left;  // child (if any) is attached to its parent;
            else if (node.left == null) // node has no left child: its right
                node = node.right; // child is attached to its parent;
            else {                  // be ready for merging subtrees;
                tmp = node.left;   // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                    tmp = tmp.right;      //    possible;
                tmp.right =        // 3. establish the link between the
                        node.right;    //    the rightmost node of the left
                //    subtree and the right subtree;
                node = node.left;  // 4.
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    public void balance(int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last)/2;
            System.out.print(data[middle]+" ");
            insert(data[middle]);
            balance(data,first,middle-1);
            balance(data,middle+1,last);
        }
    }
    public void clear() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public boolean isInTree(int el) {
        return search(root,el) != null;
    }
}