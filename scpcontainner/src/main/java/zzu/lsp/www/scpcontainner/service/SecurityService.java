package zzu.lsp.www.scpcontainner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.lsp.www.scpcontainner.javabean.Security;
import zzu.lsp.www.scpcontainner.mapper.SecurityMapper;

import java.util.ArrayList;

@Service
public class SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    public ArrayList<Security> getSecurity(String foundationId) {
        try {
            System.out.println("Service层接收到基金会ID: " + foundationId);
            ArrayList<Security> result = securityMapper.getFoudationSecurities(foundationId);
            System.out.println("Security查询结果: " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? result : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Service层查询Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Security getSecurityById(String id) {
        try {
            return securityMapper.getSecurityById(id);
        } catch (Exception e) {
            System.err.println("Service层根据ID查询Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertSecurity(Security security) {
        try {
            int result = securityMapper.insertSecurity(security);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层插入Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSecurity(Security security) {
        try {
            int result = securityMapper.updateSecurity(security);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层更新Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSecurity(String id) {
        try {
            int result = securityMapper.deleteSecurity(id);
            return result > 0;
        } catch (Exception e) {
            System.err.println("Service层删除Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
