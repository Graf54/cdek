package my.test.cdek.dao;

import my.test.cdek.model.AppStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StatusAppDao {
    void create(AppStatus appStatus);

    AppStatus read(int id);

    void update(AppStatus app);

    void delete(int id);

    boolean isExist(int id);

    List<AppStatus> getAll(int limit, int offset);
}
