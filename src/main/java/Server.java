import java.util.Random;

public class Server {
    public int Id;
    public Node[] Nodes;

    public Server(Node[] Nodes){
        this.Nodes = Nodes;
    }
    public Server(){
        Random random = new Random();
        int countOfNodes = random.nextInt(100);
        Nodes = new Node[countOfNodes];
        for (int i = 0; i < countOfNodes; i++) {
            Nodes[i] = new Node(i);
        }
    }

    @Override
    public String toString() {
        String rez = "Server: ";
        for (int i = 0; i < Nodes.length; i++) {
            rez+="\n"+i+".\t"+Nodes[i];
        }
        return rez;
    }
}
