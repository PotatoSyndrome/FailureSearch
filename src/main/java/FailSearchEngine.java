


public class FailSearchEngine {

    public FailSearchEngine(){
    }

    public void FailSearch(Cluster cluster){
        for(int i = cluster.getServers().size();i >= 1; --i){
            boolean broken = false;
            if(cluster.getServers().get(i-1) != null)
            for(int j = cluster.getServers().get(i-1).value.getNodes().size();j>= 1;--j){
                try {
                    if(!cluster.isFailed(i,j)) {
                        System.out.print("All Nodes are OK\n");
                        return;
                    }
                    else {
                        broken = true;
                        break;
                    }
                }
                catch (NullPointerException E){

                }
            }
            if(broken)
                break;
        }
        for(int i = 1;i <= cluster.getServers().size(); ++i){
            if(cluster.getServers().get(i-1) != null)
            for(int j = 1;j<= cluster.getServers().get(i-1).value.getNodes().size();++j){
                try {
                    if(cluster.isFailed(i,j)) {
                        System.out.print("Broken Node is " + i + " " + j + "\n");
                        return;
                    }
                }
                catch (NullPointerException E){
                    continue;
                }
            }
        }
//        лінійний алгоритм пошуку MxN



//        int minS = 1;
//        int maxS = cluster.getServers().size()+1;
//        while (maxS - minS != 1){
//            if(cluster.isFailed((maxS + minS)/2,1))
//                maxS = (maxS + minS)/2;
//            else minS = (maxS + minS)/2;
//        }
//        if(!cluster.isFailed(minS,cluster.getServers().get(minS-1).value.getNodes().size())){
//            System.out.print(minS+1 + " " + 1 + "\n");
//            return;
//        }
//        int minN = 0;
//        int maxN = cluster.getServers().get(minS-1).value.getNodes().size();
//        while (maxN - minN != 1){
//            if(cluster.isFailed( minS ,(maxN + minN)/2))
//                maxN = (maxN + minN)/2;
//            else minN = (maxN + minN)/2;
//        }    Бінарний пошук
//        System.out.print(minS + " " + maxN + "\n");
    }
}
