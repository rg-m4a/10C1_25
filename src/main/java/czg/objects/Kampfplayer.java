package czg.objects;

import czg.scenes.BaseScene;

import java.awt.*;
import java.util.Scanner;

public class Kampfplayer extends BaseObject{

    private final int hp;
    private final int[] items;

    public Kampfplayer(Image sprite, int x, int y, int hp, int[] items) {
        super(sprite, x, y);
        this.hp = hp;
        this.items = items;
    }

    @Override
    public void update(BaseScene scene) {
    }

    public void angriff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib mal ID");
        int ausgewaehlt = Integer.parseInt(scanner.nextLine());
        int level = Integer.parseInt(Item.testitemliste[ausgewaehlt][1]);
        Lehrer.verteidigung(level);
    }


}
