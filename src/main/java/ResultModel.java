public class ResultModel {
    private int serverId;
    private int nodeId;

    public ResultModel(int serverId, int nodeId){
        this.nodeId = nodeId;
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "Server "+serverId+"\tNode "+nodeId;
    }
}
