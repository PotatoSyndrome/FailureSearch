import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    private Node tested = new Node(1);

    @Test
    public void WhenFailedSetByConstructor(){
        assertFalse(tested.isFailed());
    }

    @Test
    public void WhenFailedSetBySetter(){
        tested.setFailed(true);
        assertTrue(tested.isFailed());
    }

    @Test
    public void NumberSetterAndGetterReview(){
        tested.setNumber(5);
        assertTrue(tested.getNumber() == 5);
    }
}