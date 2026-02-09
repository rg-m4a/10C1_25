/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.objects.minigame_objects;

import czg.objects.BaseObject;
import czg.scenes.BaseScene;
import java.awt.Image;

/**
 *
 * @author guest-4zcdot
 */
public class PhysicsWallObject extends BaseObject {
    public PhysicsWallObject(Image sprite, int x, int y, int width, int height) {
        super(sprite, x, y);
    }
    
    @Override
    public void update(BaseScene scene) {}
}