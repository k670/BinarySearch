public class FailSearchEngine {

    private Fallible cluster;

    public  FailSearchEngine(Fallible cluster){
        this.cluster = cluster;

    }

    public ResultModel search(){
        int server = searchServer(0,cluster.servers.length);
        int countNode = cluster.servers[server].Nodes.length;
        return new ResultModel(server,searchNode(server,0,countNode));
    }

    private int searchServer( int start, int finish){

        if(start == finish) return start;
        if((finish-start)<2){
            int countOfNodes = cluster.servers[start].Nodes.length-1;
            return cluster.isFail(start,countOfNodes)?start:finish;
        }

        int half = (start + finish)/2;

        if(cluster.isFail(half,0)){
            return searchServer(start,half);
        }else {
            return searchServer(half,finish);
        }
    }

    private int searchNode( int serverId, int start, int finish){
        if(start == finish) return start;

        if((finish-start)<2) return cluster.isFail(serverId,start)?start:finish;

        int half = (start+finish)/2;

        if(cluster.isFail(serverId, half)){
            return searchNode(serverId,start,half);
        }else {
            return searchNode(serverId,half,finish);
        }
    }
}
