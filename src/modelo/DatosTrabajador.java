package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatosTrabajador {

    private Map<Integer, Trabajador> baseDatosTrabajador = new HashMap<>();

    public void escribirJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(baseDatosTrabajador);
        try (FileWriter writer = new FileWriter("JsonTrabajador.json")){
            writer.write(jsonString);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void leerJson(){
        String jsonString = "";

        try (FileReader reader = new FileReader("JsonTrabajador.json")){
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1){
                builder.append((char) ch);
            }
            jsonString = builder.toString();

        }catch (IOException e){
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        baseDatosTrabajador = gson.fromJson(jsonString, new TypeToken<HashMap<Integer,Trabajador>>() {}.getType());
    }


}
