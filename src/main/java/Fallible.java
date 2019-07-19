public interface Fallible {
    boolean isFail(int serverId, int nodeId);
    int getCountOfServers();
    int getCountOfNodes(int serverId);
}
