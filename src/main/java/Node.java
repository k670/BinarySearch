public class Node {
    private int id;
    private boolean failed;

     Node(int id) {
        this.id = id;
        this.failed = false;
    }

    @Override
    public String toString() {

        return "Node: Id = " + id+(failed?" true":" false");
    }

     boolean isFailed() {
        return failed;
    }

     void setFailed() {
        this.failed = true;
    }
}
