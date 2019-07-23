public interface Fallible {
    public Server[] servers = new Server[0];
    boolean isFail(int serverId, int nodeId);
}
