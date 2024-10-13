package Rooms;

import Interfaces.GameObject;
import Interfaces.Room;

public class TreasureRoom implements Room, GameObject {
    // Crea una clase TreasureRoom que represente una sala con un tesoro.
    private String treasureOne;
    private String treasureTwo;
    private String treasureThree;

    // Constructores
    public TreasureRoom() {
    }

    public TreasureRoom(String treasureOne, String treasureTwo, String treasureThree) {
        this.treasureOne = treasureOne;
        this.treasureTwo = treasureTwo;
        this.treasureThree = treasureThree;
    }

    // Getters and Setters
    public String getTreasureOne() {
        return treasureOne;
    }

    public void setTreasureOne(String treasureOne) {
        this.treasureOne = treasureOne;
    }

    public String getTreasureTwo() {
        return treasureTwo;
    }

    public void setTreasureTwo(String treasureTwo) {
        this.treasureTwo = treasureTwo;
    }

    public String getTreasureThree() {
        return treasureThree;
    }

    public void setTreasureThree(String treasureThree) {
        this.treasureThree = treasureThree;
    }

    // toString
    @Override
    public String toString() {
        return "TreasureRoom{" +
                "treasureOne='" + treasureOne + '\'' +
                ", treasureTwo='" + treasureTwo + '\'' +
                ", treasureThree='" + treasureThree + '\'' +
                '}';
    }

    // Interface Room
    @Override
    public String typeRoom() {
        return "Este tesoro está compuesto por 3 elementos: "+ "\n" + treasureOne + ", " + treasureTwo + ", " + treasureThree + ". Además, encontraste otro objeto que es un " + objects();
    }

    // Interface GameObject
    @Override
    public String objects() {
        return "collar con cascabel";
    }

}
