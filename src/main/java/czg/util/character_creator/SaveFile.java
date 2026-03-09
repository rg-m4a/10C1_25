package czg.util.character_creator;

import czg.objects.PlayerObject;

import java.awt.*;
import java.io.Serializable;

/**
 * Spielfigur-Einstellungs-Datei
 *
 * @param haare  Haarfarbe
 * @param haut   Hautfarbe
 * @param hoodie Hoodiefarbe
 * @param hose   Hosenfarbe
 */
public record SaveFile(Color haare, Color haut, Color hoodie, Color hose) implements Serializable {

    /**
     * Eine Speicherdatei mit den aktuellen Farben aus {@link PlayerObject} erstellen
     */
    SaveFile() {
        this(
                PlayerObject.INSTANCE.haare.get(), PlayerObject.INSTANCE.haut.get(),
                PlayerObject.INSTANCE.hoodie.get(), PlayerObject.INSTANCE.hose.get()
        );
    }

    /**
     * Wendet eine gespeicherte Farbpalette an:
     * <br> - Die Farbvorschau im Character-Creator-Fenster werden angepasst
     * <br> - Die entsprechenden Variablen in {@link PlayerObject} werden angepasst
     */
    void apply() {
        // Vorschau aktualisieren
        CharacterCreator.INSTANCE.ifPresent(cc -> {
            ((ColorPickerPanel) cc.colorPickerPanel.getComponent(0)).previewPanel.setBackground(haare);
            ((ColorPickerPanel) cc.colorPickerPanel.getComponent(1)).previewPanel.setBackground(haut);
            ((ColorPickerPanel) cc.colorPickerPanel.getComponent(2)).previewPanel.setBackground(hoodie);
            ((ColorPickerPanel) cc.colorPickerPanel.getComponent(3)).previewPanel.setBackground(hose);
        });

        // Farben in der PlayerObjekt-Klasse aktualisieren
        PlayerObject.INSTANCE.haare.set(haare);
        PlayerObject.INSTANCE.haut.set(haut);
        PlayerObject.INSTANCE.hoodie.set(hoodie);
        PlayerObject.INSTANCE.hose.set(hose);

        // Spielfigur und Vorschau-Spielfigur aktualisieren
        PlayerObject.INSTANCE.updateSprite();
        CharacterCreator.INSTANCE.get().updatePreview();
    }
}
