package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatosAdmin {

    private Map<Integer, Admin> baseDatosAdmin;

    public DatosAdmin() {
        baseDatosAdmin = new HashMap<>();
        leerJson();
    }

    public void escribirJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(baseDatosAdmin);
        try (FileWriter writer = new FileWriter("JsonAdmin.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerJson() {
        try (JsonReader reader = new JsonReader(new FileReader("JsonAdmin.json"))) {
            reader.setLenient(true);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            baseDatosAdmin = gson.fromJson(reader, new TypeToken<HashMap<Integer, Admin>>() {}.getType());
            System.out.println("Contenido de baseDatosAdmin después de leer JSON:");
            for (Map.Entry<Integer, Admin> entry : baseDatosAdmin.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Usuario: " + entry.getValue().getUsuario());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("Error en la sintaxis del JSON: " + e.getMessage());
        }
    }

    public void crearUsu(String Usuario, String contra, String tipo) {
        int conta = contra.length();
        boolean validar = false;

        if (conta >= 8) {
            int nuevaClave = baseDatosAdmin.size() + 1;

            // Verificar si la nueva clave ya existe como clave en baseDatosAdmin
            for (Integer key : baseDatosAdmin.keySet()) {
                if (key == nuevaClave) {
                    validar = true;
                    break; // Si encuentra la clave, salir del bucle
                }
            }

            if (!validar) {
                boolean validar2 = false;

                // Verificar si el nombre de usuario ya existe entre los usuarios existentes
                for (Admin nom : baseDatosAdmin.values()) {
                    if (nom.getUsuario() != null && nom.getUsuario().equals(Usuario)) {
                        validar2 = true;
                        break; // Si encuentra el usuario, salir del bucle
                    }
                }

                if (!validar2) {

                    if (tipo.equals("ADMIN") || tipo.equals("TRABAJADOR")) {
                        baseDatosAdmin.put(nuevaClave, new Admin(Usuario, contra, tipo));
                        JOptionPane.showMessageDialog(null, "Usuario Agregado");
                        escribirJson();
                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo no identificado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ya existente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de usuario existente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "La contraseña no tiene los caracteres suficientes");
        }
    }

    public String veriExis(String Usuario) {
        boolean validar = false;
        for (int i : baseDatosAdmin.keySet()) {
            String nombre = baseDatosAdmin.get(i).getUsuario();
            if (nombre.equals(Usuario)) {
                validar = true;
                break;
            }
        }

        if (validar) {
            JOptionPane.showMessageDialog(null, "El usuario está en la base de datos");

            return "si";
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no está en la base de datos");
            return "no";
        }
    }

    public void modiUsu( String busnom, String Usuario1, String contra1, String tipo1) {
        int con = contra1.length();

        for (Map.Entry<Integer, Admin> entry : baseDatosAdmin.entrySet()) {
            Admin admin = entry.getValue();


                if (admin.getUsuario().equals(busnom) && (tipo1.equals("ADMIN")||tipo1.equals("TRABAJADOR"))&& con>=6) {
                    admin.setContrasena(contra1);
                    admin.setTipo(tipo1);
                    admin.setUsuario(Usuario1);
                    JOptionPane.showMessageDialog(null,"guardado exitosamente");
                    escribirJson();
                    break;
                }

        }
        if(con<6){
            JOptionPane.showMessageDialog(null,"Error");
        }


    }



    public void eliminar(String nom_elim) {
        leerJson();
        boolean validar = false;

        List<Integer> keysToRemove = new ArrayList<>();

        for (int i : baseDatosAdmin.keySet()) {
            String nombre = baseDatosAdmin.get(i).getUsuario();

            if (nombre != null && nombre.equals(nom_elim)) {
                keysToRemove.add(i);
                validar = true;
            }
        }

        for (int key : keysToRemove) {
            baseDatosAdmin.remove(key);
        }

        if (validar) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }

        escribirJson();
    }

    public void bus_nom(String nombre_buscar){
        boolean validar = false;
        leerJson();

        for (int i : baseDatosAdmin.keySet()) {
            String nombre = baseDatosAdmin.get(i).getUsuario();

            String usuario = baseDatosAdmin.get(i).toString();
            if (nombre != null && nombre.equals(nombre_buscar)) {
                JOptionPane.showMessageDialog(null, "El usuario es \n" + usuario);
                validar = true;
            }
        }
        if (!validar) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    }


}