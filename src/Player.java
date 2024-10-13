import Interfaces.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // Define una clase Player que encapsule los datos y comportamientos del jugador.

    // La clase debe incluir atributos como name, health, e inventory.
    private String name;
    private Integer LP;
    private List<String> playerObjects;

    //Constructores
    public Player() {
    }

    public Player(String nombre, Integer LP, List<String> gameObjects) {
        this.name = name;
        this.LP = LP;
        this.playerObjects = playerObjects;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLP() {
        return LP;
    }

    public void setLP(Integer LP) {
        this.LP = LP;
    }

    public List<String> getPlayerObjects() {
        return playerObjects;
    }

    public void setPlayerObjects(List<String> playerObjects) {
        this.playerObjects = playerObjects;
    }

    // Proporciona métodos para que el jugador pueda recibir daño, recoger objetos y mostrar su estado actual.
    public Integer damageReceived (Integer damage) {
        return LP - damage;
    }

    public void addObjects(List<String> gameObjects) {
        playerObjects.addAll(gameObjects);
    }

    public String showStatus(){
        return ("Nombre: " + name + ", LP: " + LP + ", Inventario: " + playerObjects);
    }

}


