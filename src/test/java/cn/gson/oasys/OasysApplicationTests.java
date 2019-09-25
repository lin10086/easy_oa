package cn.gson.oasys;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.services.inform.InformService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OasysApplicationTests {
	
	@Autowired
	private NoticeMapper nm;
	
	@Autowired
	private InformService informService;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void getConnection() throws SQLException {
		Connection conn=ds.getConnection();
		System.err.println("conn:"+conn);
	}
		
//		List<Map<String, Object>> list=informService.informList(listOne);
//		for (Map<String, Object> map : list) {
//			System.out.println(map);
//		}

	
	

}
