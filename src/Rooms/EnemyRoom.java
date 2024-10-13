package Rooms;

import Interfaces.GameObject;
import Interfaces.Room;

public class EnemyRoom implements Room, GameObject {
    // Crea una clase EnemyRoom que represente una sala con un enemigo.

    private String nameEnemy;
    private Integer enemyDamage;


    // Constructores
    public EnemyRoom() {
    }

    public EnemyRoom(String nameEnemy, Integer enemyDamage) {
        this.nameEnemy = nameEnemy;
        this.enemyDamage = enemyDamage;
    }

    // Getters and Setters
    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public Integer getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(Integer enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    // toString
    @Override
    public String toString() {
        return "EnemyRoom{" +
                "nameEnemy='" + nameEnemy + '\'' +
                ", enemyDamage=" + enemyDamage +
                '}';
    }

    // Interface Room
    @Override
    public String typeRoom() {
        return "¡No puede ser! Te encontraste con un gato viejito enemigo :o";
    }

    // Interface GameObject
    @Override
    public String objects() {
        return "sobre de churu";
    }

}
