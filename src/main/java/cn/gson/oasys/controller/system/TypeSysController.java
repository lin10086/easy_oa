package cn.gson.oasys.controller.system;

import cn.gson.oasys.ServiceV2.TypePOServiceV2;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.vo.TypeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class TypeSysController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private TypePOServiceV2 typeServiceV2;

    /**
     * 进入类型管理表格界面
     *
     * @param req
     * @return
     */
    @RequestMapping("testsystype")
    public String testsystype(HttpServletRequest req) {
        List<TypePO> typePOList = typeServiceV2.getTypePOListAll();//获取所有类型列表
        req.setAttribute("typeList", typePOList);
        return "systemcontrol/typemanage";
    }

    /**
     * 类型编辑界面；
     *
     * @param req
     * @return
     */
    @RequestMapping("typeedit")
    public String typeEdit(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("typeid"))) {
            Long typeId = Long.parseLong(req.getParameter("typeid"));
            TypePO typePO = typeServiceV2.getTypePOByTypeId(typeId);
            req.setAttribute("typeObj", typePO);
            HttpSession session = req.getSession();
            session.setAttribute("typeid", typeId);
        }
        return "systemcontrol/typeedit";
    }


    /**
     * 系统管理表单验证
     *
     * @param req
     * @param typeVO
     * @param br     后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     */
    @RequestMapping("typecheck")
    public String typeCheck(HttpServletRequest req, @Valid TypeVO typeVO, BindingResult br) {
        HttpSession session = req.getSession();
        Long typeId = null;
        req.setAttribute("menuObj", typeVO);
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        // 校验失败
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        } else {// 校验通过，下面写自己的逻辑业务
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            if (!StringUtils.isEmpty(session.getAttribute("typeid"))) {
                typeId = (Long) session.getAttribute("typeid"); // 获取进入编辑界面的typeId值
                typeVO.setTypeId(typeId);
                session.removeAttribute("typeid");
            }
            // 执行业务代码
            TypePO typePO = new TypePO();
            typePO.setTypeId(typeVO.getTypeId());
            typePO.setTypeName(typeVO.getTypeName());
            typePO.setTypeModel(typeVO.getTypeModel());
            typePO.setTypeColor(typeVO.getTypeColor());
            typePO.setSortValue(typeVO.getTypeSortValue());
            typeServiceV2.insertOrUpdateTypepO(typePO);
            req.setAttribute("success", "后台验证成功");
        }
        return "systemcontrol/typeedit";
    }

    /**
     * 执行删除方法
     */
    @RequestMapping("deletetype")
    public String deleteThis(HttpServletRequest req) {
        Long typeId = Long.parseLong(req.getParameter("id"));
        typeServiceV2.deleteTypePOByTypeId(typeId);
        return "forward:/testsystype";
    }

    /**
     * 查找类型表格
     *
     * @param req
     * @return
     */
    @RequestMapping("typetable")
    public String typeTable(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("name"))) {//模糊搜索的输入值
            String name = req.getParameter("name");
            List<TypePO> typePOList = typeServiceV2.getTypePOListByTypeNameLikeOrTypeModelLike(name);
            req.setAttribute("typeList", typePOList);
        } else {
            List<TypePO> typePOList = typeServiceV2.getTypePOListAll();
            req.setAttribute("typeList", typePOList);
        }
        return "systemcontrol/typetable";
    }

    /**
     * 查看
     *
     * @param req
     * @return
     */
    @RequestMapping("looktype")
    public String lookType(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("typeid"))) {
            Long typeId = Long.parseLong(req.getParameter("typeid"));
            TypePO typePO = typeServiceV2.getTypePOByTypeId(typeId);
            req.setAttribute("typeObj", typePO);
        }
        return "systemcontrol/looktype";
    }
}
