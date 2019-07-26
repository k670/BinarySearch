public class Main {

    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        cluster.sendData();

        FailSearchEngine failSearchEngine = new FailSearchEngine(cluster);
        ResultModel resultModel = failSearchEngine.search();
        System.out.println("Result - " + resultModel);
    }
}
