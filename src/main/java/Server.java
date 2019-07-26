import java.util.Random;

public class Server {
    private int Id;
    Node[] nodes;

    public Server(Node[] nodes) {
        this.nodes = nodes;
    }

     Server(int id) {
        this.Id = id;
        Random random = new Random();
        int countOfNodes = random.nextInt(90) + 10;
        nodes = new Node[countOfNodes];
        for (int i = 0; i < countOfNodes; i++) {
            nodes[i] = new Node(i);
        }
    }

    @Override
    public String toString() {
        String rez = "Server: ";
        for (int i = 0; i < nodes.length; i++) {
            rez += "\n" + i + ".\t" + nodes[i];
        }
        return rez;
    }
}
