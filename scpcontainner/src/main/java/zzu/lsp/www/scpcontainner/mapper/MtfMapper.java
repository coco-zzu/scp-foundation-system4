package zzu.lsp.www.scpcontainner.mapper;

import org.apache.ibatis.annotations.*;
import zzu.lsp.www.scpcontainner.javabean.Mtf;

import java.util.ArrayList;

@Mapper
public interface MtfMapper {
    @Select("SELECT * FROM mtf_object WHERE foudation = #{foundationID}")
    ArrayList<Mtf> getFoudationMtfs(String foundationID);

    @Select("SELECT * FROM mtf_object WHERE id = #{id}")
    Mtf getMtfById(String id);

    @Insert("INSERT INTO mtf_object(id, name, description, foudation, status, num) " +
            "VALUES(#{id}, #{name}, #{description}, #{foudation}, #{status}, #{num})")
    int insertMtf(Mtf mtf);

    @Update("UPDATE mtf_object SET name=#{name}, description=#{description}, foudation=#{foudation}, " +
            "status=#{status}, num=#{num} WHERE id=#{id}")
    int updateMtf(Mtf mtf);

    @Delete("DELETE FROM mtf_object WHERE id = #{id}")
    int deleteMtf(String id);
}
