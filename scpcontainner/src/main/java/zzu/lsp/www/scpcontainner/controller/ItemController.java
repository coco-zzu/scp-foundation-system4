package zzu.lsp.www.scpcontainner.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import zzu.lsp.www.scpcontainner.javabean.*;
import zzu.lsp.www.scpcontainner.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    private final ScpService scpService;
    private final MtfService mtfService;
    private final ResearcherService researcherService;
    private final DclassService dclassService;
    private final SecurityService securityService;

    public ItemController(
            ScpService scpService,
            MtfService mtfService,
            ResearcherService researcherService,
            DclassService dclassService,
            SecurityService securityService) {
        this.scpService = scpService;
        this.mtfService = mtfService;
        this.researcherService = researcherService;
        this.dclassService = dclassService;
        this.securityService = securityService;
    }

    // SCP相关API
    @PostMapping("/api/scp/list")
    public List<Scp> getScpByFoundation(@RequestBody FoundationRequest request) {
        try {
            System.out.println("接收到SCP查询请求，基金会ID: " + request.getFoudationId());
            ArrayList<Scp> result = scpService.getScp(request.getFoudationId());
            System.out.println("SCP查询到 " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? new ArrayList<>(result) : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("查询SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/api/scp/{id}")
    public Scp getScpById(@PathVariable String id) {
        try {
            System.out.println("接收到SCP查询请求，ID: " + id);
            return scpService.getScpById(id);
        } catch (Exception e) {
            System.err.println("根据ID查询SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/scp")
    public Map<String, Object> insertScp(@RequestBody Scp scp) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到SCP插入请求: " + scp);
            boolean result = scpService.insertScp(scp);
            response.put("success", result);
            response.put("message", result ? "插入成功" : "插入失败");
            return response;
        } catch (Exception e) {
            System.err.println("插入SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "插入失败: " + e.getMessage());
            return response;
        }
    }

    @PutMapping("/api/scp")
    public Map<String, Object> updateScp(@RequestBody Scp scp) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到SCP更新请求: " + scp);
            boolean result = scpService.updateScp(scp);
            response.put("success", result);
            response.put("message", result ? "更新成功" : "更新失败");
            return response;
        } catch (Exception e) {
            System.err.println("更新SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "更新失败: " + e.getMessage());
            return response;
        }
    }

    @DeleteMapping("/api/scp/{id}")
    public Map<String, Object> deleteScp(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到SCP删除请求，ID: " + id);
            boolean result = scpService.deleteScp(id);
            response.put("success", result);
            response.put("message", result ? "删除成功" : "删除失败");
            return response;
        } catch (Exception e) {
            System.err.println("删除SCP数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "删除失败: " + e.getMessage());
            return response;
        }
    }

    // MTF相关API
    @PostMapping("/api/mtf/list")
    public List<Mtf> getMtfByFoundation(@RequestBody FoundationRequest request) {
        try {
            System.out.println("接收到MTF查询请求，基金会ID: " + request.getFoudationId());
            ArrayList<Mtf> result = mtfService.getMtf(request.getFoudationId());
            System.out.println("MTF查询到 " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? new ArrayList<>(result) : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("查询MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/api/mtf/{id}")
    public Mtf getMtfById(@PathVariable String id) {
        try {
            System.out.println("接收到MTF查询请求，ID: " + id);
            return mtfService.getMtfById(id);
        } catch (Exception e) {
            System.err.println("根据ID查询MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/mtf")
    public Map<String, Object> insertMtf(@RequestBody Mtf mtf) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到MTF插入请求: " + mtf);
            boolean result = mtfService.insertMtf(mtf);
            response.put("success", result);
            response.put("message", result ? "插入成功" : "插入失败");
            return response;
        } catch (Exception e) {
            System.err.println("插入MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "插入失败: " + e.getMessage());
            return response;
        }
    }

    @PutMapping("/api/mtf")
    public Map<String, Object> updateMtf(@RequestBody Mtf mtf) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到MTF更新请求: " + mtf);
            boolean result = mtfService.updateMtf(mtf);
            response.put("success", result);
            response.put("message", result ? "更新成功" : "更新失败");
            return response;
        } catch (Exception e) {
            System.err.println("更新MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "更新失败: " + e.getMessage());
            return response;
        }
    }

    @DeleteMapping("/api/mtf/{id}")
    public Map<String, Object> deleteMtf(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到MTF删除请求，ID: " + id);
            boolean result = mtfService.deleteMtf(id);
            response.put("success", result);
            response.put("message", result ? "删除成功" : "删除失败");
            return response;
        } catch (Exception e) {
            System.err.println("删除MTF数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "删除失败: " + e.getMessage());
            return response;
        }
    }

    // Researcher相关API
    @PostMapping("/api/researcher/list")
    public List<Researcher> getResearcherByFoundation(@RequestBody FoundationRequest request) {
        try {
            System.out.println("接收到Researcher查询请求，基金会ID: " + request.getFoudationId());
            ArrayList<Researcher> result = researcherService.getResearcher(request.getFoudationId());
            System.out.println("Researcher查询到 " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? new ArrayList<>(result) : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("查询Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/api/researcher/{id}")
    public Researcher getResearcherById(@PathVariable String id) {
        try {
            System.out.println("接收到Researcher查询请求，ID: " + id);
            return researcherService.getResearcherById(id);
        } catch (Exception e) {
            System.err.println("根据ID查询Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/researcher")
    public Map<String, Object> insertResearcher(@RequestBody Researcher researcher) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Researcher插入请求: " + researcher);
            boolean result = researcherService.insertResearcher(researcher);
            response.put("success", result);
            response.put("message", result ? "插入成功" : "插入失败");
            return response;
        } catch (Exception e) {
            System.err.println("插入Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "插入失败: " + e.getMessage());
            return response;
        }
    }

    @PutMapping("/api/researcher")
    public Map<String, Object> updateResearcher(@RequestBody Researcher researcher) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Researcher更新请求: " + researcher);
            boolean result = researcherService.updateResearcher(researcher);
            response.put("success", result);
            response.put("message", result ? "更新成功" : "更新失败");
            return response;
        } catch (Exception e) {
            System.err.println("更新Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "更新失败: " + e.getMessage());
            return response;
        }
    }

    @DeleteMapping("/api/researcher/{id}")
    public Map<String, Object> deleteResearcher(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Researcher删除请求，ID: " + id);
            boolean result = researcherService.deleteResearcher(id);
            response.put("success", result);
            response.put("message", result ? "删除成功" : "删除失败");
            return response;
        } catch (Exception e) {
            System.err.println("删除Researcher数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "删除失败: " + e.getMessage());
            return response;
        }
    }

    // Dclass相关API
    @PostMapping("/api/dclass/list")
    public List<Dclass> getDclassByFoundation(@RequestBody FoundationRequest request) {
        try {
            System.out.println("接收到Dclass查询请求，基金会ID: " + request.getFoudationId());
            ArrayList<Dclass> result = dclassService.getDclass(request.getFoudationId());
            System.out.println("Dclass查询到 " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? new ArrayList<>(result) : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("查询Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/api/dclass/{id}")
    public Dclass getDclassById(@PathVariable String id) {
        try {
            System.out.println("接收到Dclass查询请求，ID: " + id);
            return dclassService.getDclassById(id);
        } catch (Exception e) {
            System.err.println("根据ID查询Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/dclass")
    public Map<String, Object> insertDclass(@RequestBody Dclass dclass) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Dclass插入请求: " + dclass);
            boolean result = dclassService.insertDclass(dclass);
            response.put("success", result);
            response.put("message", result ? "插入成功" : "插入失败");
            return response;
        } catch (Exception e) {
            System.err.println("插入Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "插入失败: " + e.getMessage());
            return response;
        }
    }

    @PutMapping("/api/dclass")
    public Map<String, Object> updateDclass(@RequestBody Dclass dclass) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Dclass更新请求: " + dclass);
            boolean result = dclassService.updateDclass(dclass);
            response.put("success", result);
            response.put("message", result ? "更新成功" : "更新失败");
            return response;
        } catch (Exception e) {
            System.err.println("更新Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "更新失败: " + e.getMessage());
            return response;
        }
    }

    @DeleteMapping("/api/dclass/{id}")
    public Map<String, Object> deleteDclass(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Dclass删除请求，ID: " + id);
            boolean result = dclassService.deleteDclass(id);
            response.put("success", result);
            response.put("message", result ? "删除成功" : "删除失败");
            return response;
        } catch (Exception e) {
            System.err.println("删除Dclass数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "删除失败: " + e.getMessage());
            return response;
        }
    }

    // Security相关API
    @PostMapping("/api/security/list")
    public List<Security> getSecurityByFoundation(@RequestBody FoundationRequest request) {
        try {
            System.out.println("接收到Security查询请求，基金会ID: " + request.getFoudationId());
            ArrayList<Security> result = securityService.getSecurity(request.getFoudationId());
            System.out.println("Security查询到 " + (result != null ? result.size() : 0) + " 个项目");
            return result != null ? new ArrayList<>(result) : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("查询Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/api/security/{id}")
    public Security getSecurityById(@PathVariable String id) {
        try {
            System.out.println("接收到Security查询请求，ID: " + id);
            return securityService.getSecurityById(id);
        } catch (Exception e) {
            System.err.println("根据ID查询Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/security")
    public Map<String, Object> insertSecurity(@RequestBody Security security) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Security插入请求: " + security);
            boolean result = securityService.insertSecurity(security);
            response.put("success", result);
            response.put("message", result ? "插入成功" : "插入失败");
            return response;
        } catch (Exception e) {
            System.err.println("插入Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "插入失败: " + e.getMessage());
            return response;
        }
    }

    @PutMapping("/api/security")
    public Map<String, Object> updateSecurity(@RequestBody Security security) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Security更新请求: " + security);
            boolean result = securityService.updateSecurity(security);
            response.put("success", result);
            response.put("message", result ? "更新成功" : "更新失败");
            return response;
        } catch (Exception e) {
            System.err.println("更新Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "更新失败: " + e.getMessage());
            return response;
        }
    }

    @DeleteMapping("/api/security/{id}")
    public Map<String, Object> deleteSecurity(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println("接收到Security删除请求，ID: " + id);
            boolean result = securityService.deleteSecurity(id);
            response.put("success", result);
            response.put("message", result ? "删除成功" : "删除失败");
            return response;
        } catch (Exception e) {
            System.err.println("删除Security数据时发生错误: " + e.getMessage());
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "删除失败: " + e.getMessage());
            return response;
        }
    }

    @Getter
    @Setter
    public static class FoundationRequest {
        private String foudationId;
    }
}
