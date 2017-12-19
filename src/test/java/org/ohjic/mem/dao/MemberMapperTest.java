package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.AuthSet;
import org.ohjic.mem.model.Kgroup;
import org.ohjic.mem.model.KgroupKey;
import org.ohjic.mem.model.Kyo;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.TidsVo;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testSelectLatestMemberByTids() {
		
		Integer churchCode = 3241;
		Integer[] tids = {16557, 59341};
		
		TidsVo vo = new TidsVo();
		vo.setChurchCode(churchCode);
		vo.setTidArray(tids);
		
		Member member = memberMapper.selectLatestMemberByTids(vo);
		System.out.println("tid: " + member.getTid());
		assertTrue(member!=null);

	}
	
	
	@Test
	public void testSelectMemberList() {
		
		Integer churchCode = 3227;
		
		Kyo kyo =new Kyo(churchCode);
		List<Member> members = memberMapper.selectMemberList(kyo);
		System.out.println("tid: " + members.size());
		assertTrue(members!=null);

	}
	
	
}
