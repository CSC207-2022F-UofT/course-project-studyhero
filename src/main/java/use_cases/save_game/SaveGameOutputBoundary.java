package use_cases.save_game;

public interface SaveGameOutputBoundary {
    /**
     * Output boundary that allows for files to be saved in to the
     * main directory of the program.
     */
    void save(String filepath);
}
