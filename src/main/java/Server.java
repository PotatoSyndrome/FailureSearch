

import java.util.ArrayList;
import java.util.Random;

public class Server implements Failable{

    private ArrayList<Optional<Node>> nodes;
    private int Number;
    private boolean failed;

    public Server(int NumberOfNodes,int Number){
        Random r = new Random();
        setNodes(new ArrayList<Optional<Node>>(NumberOfNodes));
        for (int i = 0; i < NumberOfNodes; ++i) {
            if(r.nextBoolean())
                getNodes().add(new Optional<Node>(new Node(i+1)));
            else getNodes().add(null);
        }
        this.setNumber(Number);
        try {
            this.setFailed(getNodes().get(getNodes().size()-1).value.isFailed());
        }
        catch (NullPointerException e){
            int counter = getNodes().size()-1;
            while (counter != 0){
                if(getNodes().get(getNodes().size()-1) != null)
                    this.setFailed(getNodes().get(counter).value.isFailed());
                counter--;
            }
            this.setFailed(false);
        }
    }

    public Server(){}

    public ArrayList<Optional<Node>> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Optional<Node>> nodes) {
        this.nodes = nodes;
    }

    public String toString(){
        String s = new String();
        s = getNumber() + "\n";
        for(Optional<Node> n: getNodes()){
            try {
                s = s + n.toString() + " ";
            }
            catch (NullPointerException E){
                s = s + "NULL ";
            }
        }
        s = s + "\n";
        return s;
    }

    @Override
    public boolean isFailed(){
        try {
            return getNodes().get(getNodes().size()-1).value.isFailed();
        }
        catch (NullPointerException e){
            int counter = getNodes().size()-1;
            while (counter != 0){
                if(getNodes().get(getNodes().size()-1) != null)
                    return getNodes().get(counter).value.isFailed();
                counter--;
            }
            return false;
        }
    }


    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }
}
