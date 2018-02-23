package org.ohjic.mem.service;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.common.GOODS;
import org.ohjic.mem.dao.ChurchUseNumberMapper;
import org.ohjic.mem.model.Cgroup;
import org.ohjic.mem.model.ChurchUseNumber;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.Kyo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml" })
public class SmsServiceTest {

//	@Autowired
//	private SmsService smsService;


}
