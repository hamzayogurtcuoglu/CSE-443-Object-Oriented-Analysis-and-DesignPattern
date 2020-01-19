import java.util.ArrayList;
import java.util.List;

/**
 * thread unsafe class
 */
public class BestDSEver {

    public List<Object> objList = new ArrayList<Object>();

    public void add(Object obj) {
        objList.add(obj);
    }

    public void remove(Object obj) {
        objList.remove(obj);
    }

    public Object get(int index){
        return objList.get(index);
    }
}