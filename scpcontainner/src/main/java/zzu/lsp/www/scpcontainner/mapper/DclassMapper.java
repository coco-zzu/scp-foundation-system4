package zzu.lsp.www.scpcontainner.mapper;

import org.apache.ibatis.annotations.*;
import zzu.lsp.www.scpcontainner.javabean.Dclass;

import java.util.ArrayList;

@Mapper
public interface DclassMapper {
    @Select("SELECT * FROM dclass_object WHERE foudation = #{foundationID}")
    ArrayList<Dclass> getFoudationDclasses(String foundationID);

    @Select("SELECT * FROM dclass_object WHERE id = #{id}")
    Dclass getDclassById(String id);

    @Insert("INSERT INTO dclass_object(id, name, status, assignment, foudation) " +
            "VALUES(#{id}, #{name}, #{status}, #{assignment}, #{foudation})")
    int insertDclass(Dclass dclass);

    @Update("UPDATE dclass_object SET name=#{name}, status=#{status}, assignment=#{assignment}, " +
            "foudation=#{foudation} WHERE id=#{id}")
    int updateDclass(Dclass dclass);

    @Delete("DELETE FROM dclass_object WHERE id = #{id}")
    int deleteDclass(String id);
}
