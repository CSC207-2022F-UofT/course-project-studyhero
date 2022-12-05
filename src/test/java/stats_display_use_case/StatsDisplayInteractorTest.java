package stats_display_use_case;

import entities.Stats;
import entities.StatsUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screens.StatsDisplayPresenter;
import screens.StatsDisplayViewModel;

class StatsDisplayInteractorTest {
    StatsDisplayInputBoundary statsInteractor;

    @BeforeEach
    void setUp() {
        Stats stats = new StatsUser();
        StatsDisplayOutputBoundary statsPresenter = new StatsDisplayPresenter();
        this.statsInteractor = new StatsDisplayInteractor(stats, statsPresenter);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testStatsDisplayInteractorReturnsViewModel() {
        assert(this.statsInteractor.display() instanceof StatsDisplayViewModel);
    }
    @Test
    void testStatsDisplayInteractorReturns() {}

}