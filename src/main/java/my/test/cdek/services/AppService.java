package my.test.cdek.services;

import my.test.cdek.dao.AppDao;
import my.test.cdek.model.App;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    private final AppDao appDao;

    public AppService(AppDao appDao) {
        this.appDao = appDao;
    }

    public App get(int id) {
        return appDao.read(id);
    }

    public List<App> getList(int limit, int offset) {
        return appDao.getAll(limit, offset);
    }

    public List<App> getListByStatusId(int statusId, int limit, int offset) {
        return appDao.getAll(statusId, limit, offset);
    }

    public void save(App app) {
        if (isExist(app.getId())) {
            appDao.update(app);
        } else {
            appDao.create(app);
        }
    }

    public boolean isExist(int id) {
        return appDao.isExist(id);
    }

    public void delete(App app) {
        appDao.delete(app.getId());
    }


    public int count() {
        return appDao.count();
    }

}
