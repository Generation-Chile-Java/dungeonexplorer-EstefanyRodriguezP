import Interfaces.Room;
import Rooms.EmptyRoom;
import Rooms.EnemyRoom;
import Rooms.TreasureRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Se importa el Scanner y se comienza la historia
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido a esta interesante aventura! Por favor ingresa tu nombre para continuar  (^._.^)ﾉ");

        // Define una clase principal que inicialice el jugador y una serie de salas.
        EmptyRoom emptyRoom = new EmptyRoom();
        TreasureRoom treasureRoom = new TreasureRoom();
        treasureRoom.setTreasureOne("varita mágica");
        treasureRoom.setTreasureTwo("hierba gatuna");
        treasureRoom.setTreasureThree("pelotita saltarina");
        EnemyRoom enemyRoom = new EnemyRoom("Amargurito", 3);
        // Lista de salas
        Room[] rooms ={
                emptyRoom,
                enemyRoom,
                treasureRoom,
        };

        // Se solicita nombre al jugador y se define otra información como vida e inventario
        Player player1 = new Player();
        player1.setName(sc.next());
        player1.setLP(3);
        ArrayList<String> inventory = new ArrayList<>();
        player1.setPlayerObjects(inventory);
        inventory.add("llave");
        inventory.add("awa");

        // Se continua entregando información al jugador sobre la historia y los stacks de su personaje
        System.out.println(player1.getName() + ", en esta historia tendrás que tomar el papel de un gatito hehicero  *ฅ^•ﻌ•^ฅ*  y como el valiente héroe gatuno que eres, \nTe encontrarás en la búsqueda de un mágico tesoro y tendrás que enfrentar inesperadas situaciones en tu camino.");
        System.out.println("Para comenzar esta aventura tendrás que emprender un viaje a una isla muy lejana y con algunos misterios, \nPor lo que debes iniciar el viaje ya mismo en un barco que conseguiste. Confirma que estás listo dejando un mensaje (^•-•^)ﾉ");
        String check = sc.next();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "           ;&:                 \n" +
                "          .&.$;               \n" +
                "          .&..&:              \n" +
                "          .&. &&&.            \n" +
                "         ;.&. X&&&+           \n" +
                "        ;&.&. x&&&&$.         \n" +
                "       X&&.&. x&&&&&&:        \n" +
                "     ;&&&&.&. x&&&&&&&;       \n" +
                "          .&.                 \n" +
                "    .$&&&&&&&&&&&&&&&$;       \n" +
                "       ;$&&&&&&&&&X;:         \n" +
                "         ;$&&&&&X;:           \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Mientras navegas te dedicas a averiguar más sobre esta isla y descubres que es un lugar abandonado, \nPero que anteriormente fue visitada por grandes hechiceros de la historia, quienes escondieron valiosos objetos en ella.\n~ Esta es tu información inicial de personaje al comenzar la aventura ~ " + player1.showStatus() + "\nA lo largo de tu viaje en la isla te encuentras con un camino que llama demasiado tu atención y decides adentrarte en él.\nConfirma para continuar (^•-•^)ﾉ");
        check = sc.next();

        // Implementa un bucle que permita al jugador moverse por las salas.
        // Maneja las interacciones del jugador con las salas y los objetos.
        int currentRoom = 0;
        while (currentRoom <= rooms.length || player1.getLP() > 0) {
            player1.showStatus();
            if (currentRoom == 0 && player1.getLP() > 0) {
                System.out.println("Te das cuenta que has caminado sin prestar atención y te has perdido :c ¡Sopresa! " + emptyRoom.typeRoom());
                inventory.add(emptyRoom.objects());
                System.out.println("~ Tu información de jugador actual luego de este hallazgo es: " + player1.showStatus() + "\nConfirma que esto te da un motivo para continuar (^•-•^)ﾉ");
                check = sc.next();
            } else if (currentRoom == 1 && player1.getLP() > 0) {
                System.out.println("Decides continuar caminando cuando... " + enemyRoom.typeRoom());
                // Información del enemigo
                System.out.println("El nombre de tu enemigo es " + enemyRoom.getNameEnemy() + "Además posee un ataque que te resta " + enemyRoom.getEnemyDamage() + " LP de daño. \nEs un ser sin ternura en su corazón y todo esto es debido a muchas decepciones debido a los muchos visitantes mal intencionados que viajaron antes que tú :c ");
                System.out.println("Ingresa una opción para realizar alguna acción para contrarrestar su amargura (^・u・^)");
                System.out.println("1 - Arañar \n2 - Maullar \n3 - Ronronear");
                int option;
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Decides atacar a Amargurito arañándolo, sin embargo, él es un gatito viejito por lo que es mucho más poderoso que tú :c\nPor lo que recibes daño y tu vida actual es " + player1.damageReceived(enemyRoom.getEnemyDamage()) + " LP");
                        break;
                    case 2:
                        System.out.println("¡Oh! Has maullado y cautivado a Amargurito por lo que decide dejar su amargura y volver a ser tierno como era antes *ฅ^•ﻌ•^ฅ* \nAhora eres amigo de Amargurito y te regaló un objeto que tenía escondido" + enemyRoom.objects() + "♥");
                        break;
                    case 3:
                        System.out.println("¡Oh! Has ronroneado y has convencido a Amargurito de dejar su amargura *ฅ^•ﻌ•^ฅ* \nAhora eres amigo de Amargurito y te regaló un objeto que tenía escondido" + enemyRoom.objects() + "♥");
                        //player1.setLP(6);
                        break;
                    default:
                        System.out.println("No realizaste ninguna acción contra Amargurito, quien decide atarcarte con su amargura :c");
                        System.out.println("Recibiste daño, tu vida actual es " + player1.damageReceived(enemyRoom.getEnemyDamage()) + " LP");
                        break;
                }
                //Recibe daño de enemigo
                if (option > 3 || option == 1) {
                    player1.damageReceived(enemyRoom.getEnemyDamage());
                    System.out.println("Has perdido todos tus puntos de vida, se terminó el juego  /ᐠ｡ꞈ｡ᐟ\\\\");
                    break;
                } else {
                    System.out.println("Confirma para continuar con tu aventura en esta isla (^•-•^)ﾉ");
                    check = sc.next();
                }
            } else if (currentRoom == 2 && player1.getLP() > 0) {
                System.out.println("Decidido a continuar con tu viaje en esta isla sigues caminando y... ¡Encuentras un cofre en este sendero c:! Sin embargo, este cuenta con una cerradura\nPor lo que decides utilizar la llave que tienes en tu inventario");
                inventory.remove(0);
                System.out.println(treasureRoom.typeRoom() + "\nDecides guardarlos como recompensa por esta aventura c:");
                inventory.add(treasureRoom.getTreasureOne());
                inventory.add(treasureRoom.getTreasureTwo());
                inventory.add(treasureRoom.getTreasureThree());
                inventory.add(treasureRoom.objects());
                System.out.println("~ Tu información de jugador actual luego de este hallazgo es: " + player1.showStatus());
            } else {
                System.out.println("Has terminado el juego c: No sabes cómo pero lograste regresar al punto de inicio antes de tomar el barco hacia la isla y esta historia solo vive en tu recuerdo\nEste juego se despide de tí con una imagen del gatito hechicero c:");
                System.out.println("    .∧＿∧.\n" +
                        "　    (=•ﻌ•=)   "+ "\n" +
                        "   ⊂/　 /つ━━☆・*。\n" +
                        " 　 しーＪ　　　  ゜・°。+ * 。　\n");
                break;
            }
            currentRoom++;
        }

    }
}