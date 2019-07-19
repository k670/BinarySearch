public class Main {

    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        cluster.sendData();
        Fallible fallible = cluster;

        System.out.println(BinarySearch.searchServer(fallible,0,fallible.getCountOfServers()));
    }
}
