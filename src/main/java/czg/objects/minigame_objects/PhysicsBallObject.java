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
public class PhysicsBallObject extends BaseObject {
    int forceNorth;
    int forceSouth;
    int forceWest;
    int forceEast;
    boolean applyForces;
    
    
    public PhysicsBallObject(Image sprite, int x, int y, int forceNorth, int forceSouth, int forceWest, int forceEast) {
        super(sprite, x, y);
        this.forceNorth = forceNorth;
        this.forceSouth = forceSouth;
        this.forceWest = forceWest;
        this.forceEast = forceEast;
        this.applyForces = false;
    }
    
    @Override
    public void update(BaseScene scene) {
        if(applyForces) {
            x += forceEast;
            x -= forceWest;
            y += forceSouth;
            y -= forceNorth;
        }
    }
    
    
}
