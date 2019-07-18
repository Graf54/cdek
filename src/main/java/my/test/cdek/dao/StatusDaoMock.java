package my.test.cdek.dao;

import my.test.cdek.model.AppStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusDaoMock implements StatusAppDao {
    private static List<AppStatus> appStatuses = new ArrayList<>();

    @Override
    public void create(AppStatus app) {
        appStatuses.add(app);
    }

    @Override
    public AppStatus read(int id) {
        return appStatuses.stream().filter(app -> app.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(AppStatus app) {
        AppStatus read = read(app.getId());
        read.setStatusId(app.getStatusId());
    }

    @Override
    public void delete(int id) {
        appStatuses.removeIf(x -> x.getId() == id);
    }

    @Override
    public boolean isExist(int id) {
        return appStatuses.stream().anyMatch(app -> app.getId() == id);
    }

    @Override
    public List<AppStatus> getAll(int limit, int offset) {
        return appStatuses;
    }
}
