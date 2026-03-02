package czg.objects;

import czg.scenes.BaseScene;

import java.awt.*;
import java.util.Random;

public class Lehrer extends BaseObject{

    public final int level, hp;
    public final String fachschaft;
    public static int[] lehrer_items = new int[4];

    public Lehrer(Image sprite, int x, int y, String fachschaft, int hp, int level, int[] lehrer_items) {
        super(sprite, x, y);
        this.level = level;
        this.hp = hp;
        this.fachschaft = fachschaft;
        this.lehrer_items = lehrer_items;
    }

    public static void verteidigung(int level) {
        // Es wird random ausgewählt, ob ein Item gewählt wird (und welches), oder ob de Lehrer nichts macht.
        Random rand = new Random();
        int move = rand.nextInt(5);

        if (move == 0) {
            int schaden = level;
            int item_lehrer = -1;
        }
        else {
            int item_lehrer = lehrer_items[move - 1];
            int schaden = level - Integer.parseInt(Item.testitemliste[item_lehrer][1]);
            if (schaden <= 0) {
                schaden = 0;
            }

        }
    }

    @Override
    public void update(BaseScene scene) {
    }
}
