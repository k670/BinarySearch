public class Node {
    private int Id;

    public Node(int Id){
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Node: Id = "+Id;
    }
}
