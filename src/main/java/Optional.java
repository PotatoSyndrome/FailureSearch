
public class Optional <T extends Failable> {
    public T value;

    public Optional(T value){
        this.value = value;
    }

    public Optional(){}

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return  value.toString();
    }
}
