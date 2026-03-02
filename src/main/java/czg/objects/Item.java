/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.objects;

import czg.scenes.BaseScene;

import java.awt.*;

public class Item{
    // Stelle 0: Name des items, Stelle 1: Level
    static String[][] testitemliste =   {{"Test0", "1"},
                                         {"Test1", "2"},
                                         {"Test2", "3"}};

    public Item(String[][] itemliste) {
        this.testitemliste = testitemliste;
    }

}
