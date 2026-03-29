package czg.scenes.minigame;

import czg.MainWindow;
import czg.minigame.ComputerSciencePuzzle;
import czg.minigame.LogicGate;
import czg.objects.BaseObject;
import czg.objects.ButtonObject;
import czg.objects.Department;

/**
 * Level des Informatik-Minigames, in welchem Logikgatter in einem
 * Schaltkreis erkannt werden müssen.
 */
public class ComputerScienceLevelScene extends LevelScene {
    public final int LEVEL;
    public final ComputerSciencePuzzle PUZZLE;

    /**
     * Neue Level-Szene erstellen
     * @param level Entweder {@code 0}, {@code 1} oder {@code 2}
     */
    public ComputerScienceLevelScene(int level) {
        super(Department.COMPUTER_SCIENCE, level);

        this.LEVEL = level;

        // Zufällig eines von drei für dieses Level verfügbaren
        // Rätsel auswählen
        this.PUZZLE = ComputerSciencePuzzle.getPuzzle(LEVEL);

        int availableHeight = (int) (MainWindow.HEIGHT * 0.7);
        int gateHeight = availableHeight / PUZZLE.answers.length;

        // ButtonObjects für die Antwortmöglichkeiten
        for (int i = 0; i < PUZZLE.answers.length; i++) {
            int finalI = i;
            objects.add(new ButtonObject(
                PUZZLE.answers[i].sprite,
                (int) (MainWindow.WIDTH * 0.125),
                (MainWindow.HEIGHT - availableHeight) / 2 + i * gateHeight,
                () -> setAnswer(PUZZLE.answers[finalI])
            ));
        }

        // Das eigentliche Rätsel wird durch ein Bild dargestellt
        objects.add(new BaseObject(
                PUZZLE.sprite,
                (int) (MainWindow.WIDTH * 0.3),
                (MainWindow.HEIGHT - availableHeight) / 2,
                (int) (MainWindow.WIDTH * 0.6),
                availableHeight
        ));
    }

    private void setAnswer(LogicGate gate) {
        if (gate == PUZZLE.solution)
            levelWon();
        else
            levelLost();
    }

    /**
     * Generiert eine neue {@link ComputerScienceLevelScene}
     * @return {@code new {@link ComputerScienceLevelScene}}
     */
    @Override
    public LevelScene reset() {
        return new ComputerScienceLevelScene(LEVEL);
    }
}
