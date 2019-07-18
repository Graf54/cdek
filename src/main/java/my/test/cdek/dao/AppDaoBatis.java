package my.test.cdek.dao;

import my.test.cdek.mapper.AppMapper;
import my.test.cdek.model.App;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppDaoBatis implements AppDao {

    private final AppMapper mapper;

    public AppDaoBatis(AppMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public void create(App app) {
        mapper.insertApp(app);
    }

    @Override
    public App read(int id) {
        return mapper.getAppCustom(id);
    }

    @Override
    public void update(App app) {
        mapper.updateApp(app);
    }

    @Override
    public void delete(int id) {
        mapper.deleteApp(id);
    }

    @Override
    public boolean isExist(int id) {
        return mapper.countById(id) > 0;
    }

    @Override
    public List<App> getAll(int limit, int offset) {
        return mapper.getAppCustomLimit(limit, offset);
    }

    @Override
    public List<App> getAll(int statusId, int limit, int offset) {
        return mapper.getAppCustomByStatus(statusId, limit, offset);
    }
}
