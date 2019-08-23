
public class Node implements Failable{

    private Boolean failed;
    private int number;

    public Node(int number){
        setFailed(false);
        this.setNumber(number);
    }

    public Node(){}

    @Override
    public boolean isFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    @Override
    public String toString(){
        String s = new String();
        s = getNumber() + " " + isFailed();
        return s;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
