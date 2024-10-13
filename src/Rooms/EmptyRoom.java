package Rooms;

import Interfaces.GameObject;
import Interfaces.Room;

public class EmptyRoom implements Room, GameObject {
    // Crea una clase EmptyRoom que represente una sala vacía.


    // Interface Room
    @Override
    public String typeRoom() {
        return "¡Has seguido por un sendero vacío :c!";
    }

    // Interface GameObject
    @Override
    public String objects() {
        System.out.println("En este sendero vacío solamente has encontrado una piedra con forma de michi ✿ \nañádela a tu inventario para que puedas vivir tu vida de miaucito con una piedrita c:");
        return "piedra miaucito";
    }

}
