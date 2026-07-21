package zzu.lsp.www.scpcontainner.mapper;

import org.apache.ibatis.annotations.*;
import zzu.lsp.www.scpcontainner.javabean.Scp;

import java.util.ArrayList;

@Mapper
public interface ScpMapper {
    @Select("SELECT * FROM scp_object WHERE foudation = #{foundationID}")
    ArrayList<Scp> getFoudationScps(String foundationID);

    @Select("SELECT * FROM scp_object WHERE id = #{id}")
    Scp getScpById(String id);

    @Insert("INSERT INTO scp_object(id, name, scpclass, description, foudation, alearance, controlltime, controllspace, clearance, status, assignment, age, specialization, num) " +
            "VALUES(#{id}, #{name}, #{scpclass}, #{description}, #{foudation}, #{alearance}, #{controlltime}, #{controllspace}, #{clearance}, #{status}, #{assignment}, #{age}, #{specialization}, #{num})")
    int insertScp(Scp scp);

    @Update("UPDATE scp_object SET name=#{name}, scpclass=#{scpclass}, description=#{description}, foudation=#{foudation}, " +
            "alearance=#{alearance}, controlltime=#{controlltime}, controllspace=#{controllspace}, clearance=#{clearance}, " +
            "status=#{status}, assignment=#{assignment}, age=#{age}, specialization=#{specialization}, num=#{num} " +
            "WHERE id=#{id}")
    int updateScp(Scp scp);

    @Delete("DELETE FROM scp_object WHERE id = #{id}")
    int deleteScp(String id);
}
