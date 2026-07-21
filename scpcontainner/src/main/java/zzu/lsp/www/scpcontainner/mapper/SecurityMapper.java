package zzu.lsp.www.scpcontainner.mapper;

import org.apache.ibatis.annotations.*;
import zzu.lsp.www.scpcontainner.javabean.Security;

import java.util.ArrayList;

@Mapper
public interface SecurityMapper {
    @Select("SELECT * FROM security_object WHERE foudation = #{foundationID}")
    ArrayList<Security> getFoudationSecurities(String foundationID);

    @Select("SELECT * FROM security_object WHERE id = #{id}")
    Security getSecurityById(String id);

    @Insert("INSERT INTO security_object(id, name, age, foudation, status) " +
            "VALUES(#{id}, #{name}, #{age}, #{foudation}, #{status})")
    int insertSecurity(Security security);

    @Update("UPDATE security_object SET name=#{name}, age=#{age}, foudation=#{foudation}, " +
            "status=#{status} WHERE id=#{id}")
    int updateSecurity(Security security);

    @Delete("DELETE FROM security_object WHERE id = #{id}")
    int deleteSecurity(String id);
}
