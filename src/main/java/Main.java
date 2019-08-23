
public class Main {

    public static void main(String[] args) {
        Cluster cluster = new Cluster(5,5);
        FailSearchEngine FSE = new FailSearchEngine();
//        System.out.print(cluster.toString());
//        FSE.FailSearch(cluster);
        cluster.sendMessage();
        System.out.print(cluster.toString());
        FSE.FailSearch(cluster);
        Saver saver = new Saver();
        saver.save(cluster);
        saver.read();
    }
}
