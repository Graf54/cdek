package my.test.cdek.dao;

import my.test.cdek.model.App;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppDao {
    void create(App app);

    App read(int id);

    void update(App app);

    void delete(int id);

    boolean isExist(int id);

    List<App> getAll(int limit, int offset);

    List<App> getAll(int statusId, int limit, int offset);
}
