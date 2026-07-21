package zzu.lsp.www.scpcontainner.mapper;

import org.apache.ibatis.annotations.*;
import zzu.lsp.www.scpcontainner.javabean.Researcher;

import java.util.ArrayList;

@Mapper
public interface ResearcherMapper {
    @Select("SELECT * FROM researcher_object WHERE foudation = #{foundationID}")
    ArrayList<Researcher> getFoudationResearchers(String foundationID);

    @Select("SELECT * FROM researcher_object WHERE id = #{id}")
    Researcher getResearcherById(String id);

    @Insert("INSERT INTO researcher_object(id, name, clearance, specialization, foudation, status) " +
            "VALUES(#{id}, #{name}, #{clearance}, #{specialization}, #{foudation}, #{status})")
    int insertResearcher(Researcher researcher);

    @Update("UPDATE researcher_object SET name=#{name}, clearance=#{clearance}, specialization=#{specialization}, " +
            "foudation=#{foudation}, status=#{status} WHERE id=#{id}")
    int updateResearcher(Researcher researcher);

    @Delete("DELETE FROM researcher_object WHERE id = #{id}")
    int deleteResearcher(String id);
}
