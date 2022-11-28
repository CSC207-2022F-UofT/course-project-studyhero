package Timer;

import Timer.TimerEntities.TimerEntity;
import Timer.TimerUseCases.TimerInteractor;
import Timer.TimerUI.TimerScreen;
import Timer.TimerUI.MainFrame;

public class Main {
    public static void main(String[] args) {
        new TimerScreen().timerScreen();
        new MainFrame().TimerScreen();
    }
}
