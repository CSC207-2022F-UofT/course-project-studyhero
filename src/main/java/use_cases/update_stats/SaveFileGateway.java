package use_cases.update_stats;

import java.util.Map;

public interface SaveFileGateway {
    void save(Map<String, Integer> statsMap);
}
