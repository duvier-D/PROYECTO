package modelo;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class HashMapManager {
    private HashMap<String, Elemento> map;
    private Gson gson;
    private  String FILENAME = "data.json";

    public HashMapManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        map = new HashMap<>();
        cargarjson();
    }

    public void crear(Elemento elemento) {
        map.put(elemento.getCodigo(), elemento);
        actualizarjson();
    }

    public void modificar(Elemento elemento) {
        map.put(elemento.getCodigo(), elemento);
        actualizarjson();
    }

    public void eliminar(String codigo) {
        map.remove(codigo);
        actualizarjson();
    }

    public Elemento buscar(String codigo) {
        return map.get(codigo);
    }

    public void mostrartodo() {
        map.values().forEach(System.out::println);
    }

    private void cargarjson() {
        try (FileReader reader = new FileReader(FILENAME)) {

            Type type = new com.google.gson.reflect.TypeToken<HashMap<String, Elemento>>() {}.getType();
            map = gson.fromJson(reader, type);
            if (map == null) {
                map = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarjson() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            gson.toJson(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
