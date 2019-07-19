public class BinarySearch {

   static ResultModel searchServer(Fallible fallible, int start, int finish){
        if(start==finish) return new ResultModel(start,searchNode(fallible,start,0, fallible.getCountOfNodes(start)));
        int half = (start+finish)/2;
        int nodeId = 0;
        if(!fallible.isFail(half,nodeId)){
            return searchServer(fallible,half,finish);
        }else
            return searchServer(fallible, start,half);
    }

   static int searchNode(Fallible fallible, int serverId, int start, int finish){
        if(start==finish) return start;
        int half = (start+finish)/2;
        if(fallible.isFail(serverId, half)){
            return searchNode(fallible,serverId, half,finish);
        }else
            return searchNode(fallible, serverId, start,half);
    }
}
