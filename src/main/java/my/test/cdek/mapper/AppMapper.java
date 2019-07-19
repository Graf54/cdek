package my.test.cdek.mapper;

import my.test.cdek.model.App;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppMapper {

    @Insert("INSERT into app (phone) values (#{phone}) returning id")
    int insertApp(App app);

    @Select("Select * from app where id = #{id}")
    @Results(value = {
            @Result(property = "statusId", column = "status_id")
    })
    App getAppCustom(int id);

    @Select("Select * from app order by id limit #{limit} offset #{offset} ")
    @Results(value = {
            @Result(property = "statusId", column = "status_id")
    })
    List<App> getAppCustomLimit(int limit, int offset);

    @Select("Select * from app where status_id=#{statusId} order by id limit #{limit} offset #{offset} ")
    @Results(value = {
            @Result(property = "statusId", column = "status_id")
    })
    List<App> getAppCustomByStatus(int statusId, int limit, int offset);

    @Update("UPDATE app set phone = #{phone}, status_id = #{statusId} where id = #{id}")
    void updateApp(App app);

    @Delete("Delete from app where id = #{id}")
    void deleteApp(int id);

    @Select("SELECT count(*) from app where id = #{id}")
    int countById(int id);

    @Select("SELECT count(*) from app")
    int count();

}
