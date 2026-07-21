package zzu.lsp.www.scpcontainner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lsp.www.scpcontainner.javabean.Mtf;
import zzu.lsp.www.scpcontainner.mapper.MtfMapper;

import java.util.ArrayList;

@Service
public class MtfService {

    @Autowired
    private MtfMapper mtfMapper;

    public ArrayList<Mtf> getMtf(String foundationId) {
        try {
            System.out.println("Service层接收到基金会ID: " + foundationId);
            ArrayList<Mtf> result = mtfMapper.getFoudationMtfs(foundationId);
            System.out.println("MTF查询结果: " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? result : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Service层查询MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Mtf getMtfById(String id) {
        try {
            return mtfMapper.getMtfById(id);
        } catch (Exception e) {
            System.err.println("Service层根据ID查询MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertMtf(Mtf mtf) {
        try {
            int result = mtfMapper.insertMtf(mtf);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层插入MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMtf(Mtf mtf) {
        try {
            int result = mtfMapper.updateMtf(mtf);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层更新MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMtf(String id) {
        try {
            int result = mtfMapper.deleteMtf(id);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层删除MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
