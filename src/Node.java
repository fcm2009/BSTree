
public class Node implements Comparable {

    protected int key;
    protected Node left, right;
    public Node() {
        left = right = null;
    }
    public Node(int el) {
        this(el,null,null);
    }
    public Node(int el, Node lt, Node rt) {
        key = el; left = lt; right = rt;
    }
    public void visit() {
        System.out.print(key + " ");
    }
    public String toString() {
        return "" + key;
    }

    public int compareTo(Object obj) {
        if(obj != null)  {
            if(obj.getClass().getName().equals("Node")) {
                Node node = (Node) obj;
                return key - node.key;
            }
            else throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }


}