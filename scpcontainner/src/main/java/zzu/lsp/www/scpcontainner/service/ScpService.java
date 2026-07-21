package zzu.lsp.www.scpcontainner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lsp.www.scpcontainner.javabean.Scp;
import zzu.lsp.www.scpcontainner.mapper.ScpMapper;

import java.util.ArrayList;

@Service
public class ScpService {

    @Autowired
    private ScpMapper scpMapper;

    public ArrayList<Scp> getScp(String foundationId) {
        try {
            System.out.println("Service层接收到基金会ID: " + foundationId);
            ArrayList<Scp> result = scpMapper.getFoudationScps(foundationId);
            System.out.println("SCP查询结果: " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? result : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Service层查询SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Scp getScpById(String id) {
        try {
            return scpMapper.getScpById(id);
        } catch (Exception e) {
            System.err.println("Service层根据ID查询SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertScp(Scp scp) {
        try {
            int result = scpMapper.insertScp(scp);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层插入SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateScp(Scp scp) {
        try {
            int result = scpMapper.updateScp(scp);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层更新SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteScp(String id) {
        try {
            int result = scpMapper.deleteScp(id);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层删除SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
