import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Saver {
    private ObjectMapper mapper;
    static final String filepath = System.getProperty("user.dir") + File.separator + "user.json";

    public Saver(){
        mapper = new ObjectMapper();
    }

    public void save(Cluster cluster){
        try {
            // Вывoдиm в json фaйл            
            mapper.writeValue(new FileOutputStream(
                    filepath), cluster);
            // Вывoдиm нa koнcoль            
             System.out.println(mapper.writeValueAsString(cluster));
//            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cluster));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){
        try{
            Cluster cluster =(Cluster) mapper.readValue(new FileInputStream(filepath),Cluster.class);
            System.out.println(cluster.toString());
        }
        catch (JsonMappingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
