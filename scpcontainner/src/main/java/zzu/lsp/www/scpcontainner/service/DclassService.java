package zzu.lsp.www.scpcontainner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lsp.www.scpcontainner.javabean.Dclass;
import zzu.lsp.www.scpcontainner.mapper.DclassMapper;

import java.util.ArrayList;

@Service
public class DclassService {

    @Autowired
    private DclassMapper dclassMapper;

    public ArrayList<Dclass> getDclass(String foundationId) {
        try {
            System.out.println("Service层接收到基金会ID: " + foundationId);
            ArrayList<Dclass> result = dclassMapper.getFoudationDclasses(foundationId);
            System.out.println("Dclass查询结果: " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? result : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Service层查询Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Dclass getDclassById(String id) {
        try {
            return dclassMapper.getDclassById(id);
        } catch (Exception e) {
            System.err.println("Service层根据ID查询Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertDclass(Dclass dclass) {
        try {
            int result = dclassMapper.insertDclass(dclass);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层插入Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDclass(Dclass dclass) {
        try {
            int result = dclassMapper.updateDclass(dclass);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层更新Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDclass(String id) {
        try {
            int result = dclassMapper.deleteDclass(id);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层删除Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
