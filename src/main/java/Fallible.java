public abstract class Fallible {

    public Server[] servers;
    abstract boolean isFail(int serverId, int nodeId);
}
