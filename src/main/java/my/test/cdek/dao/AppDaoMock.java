package my.test.cdek.dao;

import my.test.cdek.model.App;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class AppDaoMock implements AppDao {
    private static List<App> appList = new ArrayList<>();

    private int getId() {
        int i = appList.stream().mapToInt(App::getId).max().orElse(0);
        return ++i;
    }

    @Override
    public void create(App app) {
        app.setCreated(new Date());
        app.setId(getId());
        appList.add(app);
    }

    @Override
    public App read(int id) {
        return appList.stream().filter(app -> app.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(App app) {
        App read = read(app.getId());
        read.setCreated(app.getCreated());
        read.setPhone(app.getPhone());
    }

    @Override
    public void delete(int id) {
        appList.removeIf(x -> x.getId() == id);
    }

    @Override
    public boolean isExist(int id) {
        return appList.stream().anyMatch(app -> app.getId() == id);
    }

    @Override
    public List<App> getAll(int limit, int offset) {
        return appList;
    }

    @Override
    public List<App> getAll(int statusId, int limit, int offset) {
        return appList.stream().filter(app -> app.getStatusId() == statusId).collect(Collectors.toList());
    }
}
