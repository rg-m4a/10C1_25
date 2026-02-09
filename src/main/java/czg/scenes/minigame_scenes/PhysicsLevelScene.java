/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes.minigame_scenes;

import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.objects.minigame_objects.PhysicsBallObject;
import czg.objects.minigame_objects.PhysicsWallObject;
import czg.scenes.BaseScene;
import czg.util.Images;
import java.awt.Image;
import java.util.List;

/**
 *
 * @author guest-4zcdot
 */
public class PhysicsLevelScene extends BaseScene {
     public PhysicsLevelScene(Image puzzle, List<String> answers) {
        objects.add(new BackdropObject(Images.get("/assets/minigames/physics/Physics_Background.png")));

        objects.add(new PhysicsBallObject(Images.get("/assets/minigames/physics/Physics_Ball.png"), 0, 0, 0, 0, 0, 0));
        objects.add(new PhysicsWallObject(Images.get("/assets/minigames/physics/Physics_Wall.png"), 0, 0, 0, 0));
     }
}
