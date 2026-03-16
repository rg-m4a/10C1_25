package czg.scenes.minigame_scenes;

import czg.objects.ButtonObject;
import czg.objects.Department;
import czg.objects.DragObject;
import czg.util.Images;

public class MathematicsLevelScene extends LevelScene {
    public MathematicsLevelScene(int level) {
        super(Department.MATHEMATICS, level);

        DragObject pieces = new DragObject(Images.get("/assets/minigames/mathematics/tangram_packed.png"), 100, 100);

        pieces.width *= 0.6;
        pieces.height *= 0.6;

        objects.add(pieces);
        
        ButtonObject test = new ButtonObject(Images.get("/assets/minigames/mathematics/tangram_packed.png"), 200, 200, () -> {});
        
        test.method = () -> test.rotate(90);
        
        objects.add(test);
    }
}
