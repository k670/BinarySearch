import java.util.Random;

public class Cluster extends Fallible {
    private int nodeId;
    private int serverId;

    public Cluster(Server[] servers){
        this.servers = servers;
    }

    public Cluster(){
        Random random = new Random();
        int countOfServers = random.nextInt(90)+10;
        servers = new Server[countOfServers];
        for (int i = 0; i<countOfServers; i++) {
            servers[i] = new Server(i);
        }
    }

    @Override
    public boolean isFail(int serverId, int nodeId) {
        if((servers.length<=serverId)||(servers[serverId].Nodes.length<=nodeId)) throw new NullPointerException();

        return (this.serverId < serverId)||((this.serverId == serverId)&&(this.nodeId <= nodeId));
    }


    public int getCountOfNodes(int serverId) {
        return servers[serverId].Nodes.length;
    }

    public void sendData(){
        Random random = new Random();
        serverId = random.nextInt(servers.length);
        nodeId = random.nextInt(servers[serverId].Nodes.length);
        System.out.println("Cluster failed on "+serverId+" server "+nodeId+" node");
    }

    @Override
    public String toString() {
        String rez = "Cluster: ";
        for (int i = 0; i < servers.length; i++) {
            rez+="\n"+i+".\t"+servers[i];
        }
        return rez;
    }
}
