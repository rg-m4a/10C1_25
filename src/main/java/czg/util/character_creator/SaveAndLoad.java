package czg.util.character_creator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Speichern und Laden von Spielfigur-Einstellungen
 */
public final class SaveAndLoad {

    /**
     * Dateiwahl-Dialog, welcher nur einzelne {@code .czgame_chr}-Dateien akzeptiert
     */
    private static final JFileChooser fileChooser = new JFileChooser();
    static {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Charakter-Dateien", "czgame_chr"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    /**
     * Die aktuellen Farben speichern
     * @param a Damit diese Methode schön als Methoden-Referenz an {@link JButton#addActionListener(ActionListener)} übergeben werden kann
     */
    static void save(ActionEvent a) {
        // Datei wählen
        if(fileChooser.showSaveDialog(CharacterCreator.INSTANCE.get()) != JFileChooser.APPROVE_OPTION)
            return;

        // Ggf. .czgame_chr-Erweiterung hinzufügen
        File selection = fileChooser.getSelectedFile();
        if(! selection.getName().endsWith(".czgame_chr"))
            selection = new File(selection.getParent(), selection.getName()+".czgame_chr");

        // Ggf. bestätigen, dass die Datei überschrieben wird
        if(selection.exists() && JOptionPane.showConfirmDialog(
                        fileChooser, "Datei überschreiben?",
                "Speichern", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;


        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selection))) {
            // Datei schreiben
            oos.writeObject(new SaveFile());
            // Erfolg verkünden
            JOptionPane.showMessageDialog(CharacterCreator.INSTANCE.get(), selection+" gespeichert", "Erfolgreich gespeichert", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            // Fehlernachricht übermitteln
            JOptionPane.showMessageDialog(CharacterCreator.INSTANCE.get(), e, "Fehler beim Speichern", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Die Farben für die Spielfigur aus einer mit {@link #save(ActionEvent)} gespeicherten Datei laden
     * @param a Siehe {@link #save(ActionEvent)}
     */
    static void load(ActionEvent a) {
        // Speicherort wählen
        if(fileChooser.showOpenDialog(CharacterCreator.INSTANCE.get()) != JFileChooser.APPROVE_OPTION)
            return;

        File selection = fileChooser.getSelectedFile();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selection))) {
            // Datei laden
            SaveFile saveFile = (SaveFile) ois.readObject();
            // Geladene Farben übernehmen
            saveFile.apply();
            // Erfolg verkünden
            JOptionPane.showMessageDialog(CharacterCreator.INSTANCE.get(), selection+" geladen", "Erfolgreich geladen", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // Fehlernachricht übermitteln
            JOptionPane.showMessageDialog(CharacterCreator.INSTANCE.get(), e, "Fehler beim Laden", JOptionPane.ERROR_MESSAGE);
        }
    }

}
