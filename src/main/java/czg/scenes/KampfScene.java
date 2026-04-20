package czg.scenes;
import czg.objects.BackdropObject;
import czg.objects.Department;
import czg.objects.LehrerObject;
import czg.objects.PlayerObject;
import czg.util.Images;

/**
 * @author Sophie
 */
public class KampfScene extends BaseScene{

    private int LehrerLeben;
    private int PlayerLeben;


    public KampfScene(String FACHSCHAFT){
        super();

        //Einfügen des Hintergrunds
        objects.add(new BackdropObject(Images.get("/assets/background/Kampfgang.png")));
        
        SceneStack.INSTANCE.push(new InventarScene());

        LehrerLeben = 10;
        PlayerLeben = 10;

        LehrerObject Lehrer = new LehrerObject(10, 10, FACHSCHAFT, LehrerLeben, 2);

        while (LehrerLeben > 0 && PlayerLeben > 0) {
            // Zuerst der Schüler
            int SchadenPlayer = PlayerObject.angriff();
            int SchadenGesamt = LehrerObject.verteidigung(SchadenPlayer);

            LehrerLeben -= SchadenGesamt;

            // Dann der Lehrer
            int SchadenLehrer = LehrerObject.angriff();
            SchadenGesamt = PlayerObject.verteidigung(SchadenPlayer);

            PlayerLeben -= SchadenGesamt;
        }
    }

}


