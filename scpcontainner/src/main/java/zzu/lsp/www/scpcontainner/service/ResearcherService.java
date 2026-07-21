package zzu.lsp.www.scpcontainner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lsp.www.scpcontainner.javabean.Researcher;
import zzu.lsp.www.scpcontainner.mapper.ResearcherMapper;

import java.util.ArrayList;

@Service
public class ResearcherService {

    @Autowired
    private  ResearcherMapper researcherMapper;

    public ArrayList<Researcher> getResearcher(String foundationId) {
        try {
            System.out.println("Service层接收到基金会ID: " + foundationId);
            ArrayList<Researcher> result = researcherMapper.getFoudationResearchers(foundationId);
            System.out.println("Researcher查询结果: " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? result : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Service层查询Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Researcher getResearcherById(String id) {
        try {
            return researcherMapper.getResearcherById(id);
        } catch (Exception e) {
            System.err.println("Service层根据ID查询Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertResearcher(Researcher researcher) {
        try {
            int result = researcherMapper.insertResearcher(researcher);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层插入Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateResearcher(Researcher researcher) {
        try {
            int result = researcherMapper.updateResearcher(researcher);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层更新Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteResearcher(String id) {
        try {
            int result = researcherMapper.deleteResearcher(id);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层删除Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
