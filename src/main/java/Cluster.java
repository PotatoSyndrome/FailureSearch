

import java.util.ArrayList;
import java.util.Random;

public class Cluster implements Failable{
    private ArrayList<Optional<Server>> servers;
    private boolean failed;

    public Cluster(int NumberOfServers,int NumberOfNodes){
        Random r = new Random();
        setServers(new ArrayList<Optional<Server>>(NumberOfServers));
        for (int i = 0; i < NumberOfServers;++i) {
            if(r.nextBoolean())
                getServers().add(new Optional<Server>(new Server(NumberOfNodes, i+1)));
            else getServers().add(null);
        }
    }

    public Cluster(){}

    public ArrayList<Optional<Server>> getServers() {
        return servers;
    }

    public void setServers(ArrayList<Optional<Server>> servers) {
        this.servers = servers;
    }

    public String toString(){// для перевірки правильності алгоритму,виводить всі сервери з нодами + номери
        String s = new String();
        for (Optional<Server> S: getServers()) {
            try {
                s = s + S.toString();
            }
            catch (NullPointerException E){
                s = s + "NULL\n";
            }
        }
        return s;
    }

    public void sendMessage(){
        Random r = new Random();
        int failServer = 0;
        int failNode = 0;
        failServer = r.nextInt(getServers().size());
        for (int i = 0;i < getServers().size();++i){
            if(getServers().get(i) != null){
                failNode = r.nextInt(getServers().get(i).value.getNodes().size());
                break;
            }
        }
//        System.out.printf("\n" + failServer + " " + failNode + "\n"); виводило дані рандому для тестування
        Boolean Change = false;
        for(Optional<Server> s : getServers()){
            if(s != null)
            for (Optional<Node> n : s.value.getNodes()){
                if(n != null) {
                    if (s.value.getNumber() > failServer && n.value.getNumber() > failNode)//Визначає чи є ця нода точкою помилки
                        Change = true;
                    n.value.setFailed(Change);  // Якщо після помилки,змінює на true
                }
            }
        }
    }

    public Boolean isFailed(int ServerNumber,int NodeNumber) throws NullPointerException{
        if(getServers().get(ServerNumber-1) == null) {
            throw new NullPointerException();
        }
        else if (getServers().get(ServerNumber-1).value.getNodes().get(NodeNumber-1) == null){
            throw new NullPointerException();
        }
        return getServers().get(ServerNumber-1).value.getNodes().get(NodeNumber-1).value.isFailed();
    }

    @Override
    public boolean isFailed(){
        try {
            return getServers().get(getServers().size() - 1).value.isFailed();
        }
        catch (NullPointerException e){
            int counter = getServers().size()-1;
            while (counter != 0){
                if(getServers().get(getServers().size()-1) != null)
                    return getServers().get(counter).value.isFailed();
                counter--;
            }
            return false;
        }
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }
}
