import java.util.Random;

public class Cluster implements Fallible {

    private Server[] servers;

    public Cluster(Server[] servers) {
        this.servers = servers;
    }

     Cluster() {
        Random random = new Random();
        int countOfServers = random.nextInt(90) + 10;
        servers = new Server[countOfServers];
        for (int i = 0; i < countOfServers; i++) {
            servers[i] = new Server(i);
        }
    }

    public boolean isFail(int serverId, int nodeId) {

        return servers[serverId].nodes[nodeId].isFailed();
    }

    public int getCountOfServers() {
        return servers.length;
    }


    public int getCountOfNodes(int serverId) {
        return servers[serverId].nodes.length;
    }

    void sendData() {
        Random random = new Random();
        int serverId = random.nextInt(servers.length);
        int nodeId = random.nextInt(servers[serverId].nodes.length);

        for (int i = serverId + 1; i < servers.length; i++) {
            for (Node node : servers[i].nodes) {
                node.setFailed();
            }
        }
        for (int i = nodeId; i < servers[serverId].nodes.length; i++) {
            servers[serverId].nodes[i].setFailed();
        }
        System.out.println("Cluster failed on " + serverId + " server " + nodeId + " node");
    }


    public String toString() {
        String rez = "Cluster: ";
        for (int i = 0; i < servers.length; i++) {
            rez += "\n" + i + ".\t" + servers[i];
        }
        return rez;
    }
}
