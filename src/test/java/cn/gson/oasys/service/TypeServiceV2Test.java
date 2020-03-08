package cn.gson.oasys.service;

import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.modelV2.po.TypePO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeServiceV2Test {
    @Resource
    TypePOServiceV2 typePOServiceV2;

    @Test
    public void getTypeIdAndTypeNameByTypePoList() {
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_evection");
        Map<Long, String> map = new HashMap<>();
        for (TypePO typePO : typePOList) {
            map.put(typePO.getTypeId(), typePO.getTypeName());
            log.info("map.get()={},map.get(typePO.getTypeId())={}",map.get(0),map.get(typePO.getTypeId()));
        }


    }
}
