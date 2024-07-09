package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BD_Peso {
    private HashMap<Integer, ModeloP> registros;
    private String filePath;
    private int nextId;

    public BD_Peso() {
        registros = new HashMap<>();
        cargarDatos();
    }

    public void cargarDatos() {
        Gson gson = new Gson();
        filePath = "registros.json";
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<HashMap<Integer, ModeloP>>() {}.getType();
            registros = gson.fromJson(reader, type);
            if (registros == null) {
                registros = new HashMap<>();
            }
            if (registros.isEmpty()) {
                nextId = 1;
            } else {
                nextId = registros.keySet().stream().max(Integer::compare).orElse(0) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            registros = new HashMap<>();
            nextId = 1;
        }
    }

    public void guardarDatos() {
        filePath = "registros.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(registros, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarRegistro(ModeloP registro) {
        registros.put(nextId++, registro);
        guardarDatos();
    }

    public boolean modificarRegistro(int id, float nuevoPeso) {
        if (nuevoPeso < 20 || nuevoPeso > 150) {
            return false;
        }
        ModeloP registro = registros.get(id);
        if (registro != null) {
            registro.setPeso(nuevoPeso);
            registro.setFechaHora(new Date());
            guardarDatos();
            return true;
        }
        return false;
    }

    public void eliminarRegistro(int id) {
        registros.remove(id);
        guardarDatos();
    }

    public HashMap<Integer, ModeloP> obtenerRegistros() {
        return registros;
    }

    public String mostrarRegistros() {
        StringBuilder mensaje = new StringBuilder();
        for (Map.Entry<Integer, ModeloP> entry : registros.entrySet()) {
            mensaje.append(entry.getKey()).append(". ").append(entry.getValue().toString());
        }
        return mensaje.toString();
    }
}
