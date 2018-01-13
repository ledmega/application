package net.oopscraft.application.console;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.oopscraft.application.core.JsonConverter;
import net.oopscraft.application.core.TextTableBuilder;
import net.oopscraft.application.core.ValueMap;
import net.oopscraft.application.user.User;
import net.oopscraft.application.user.UserDao;

@Controller
@RequestMapping("/console")
public class ConsoleController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView get() throws Exception {
		ModelAndView modelAndView = new ModelAndView("user/User.tiles");
		return modelAndView;
	}

	@RequestMapping(value="/getUserList", method=RequestMethod.GET, produces="application/json")
	//@Transactional
	public ResponseEntity<?> getUserList(
			 @RequestParam(value="key",required=false)String key
			,@RequestParam(value="value",required=false)String value
			,@RequestParam(value="rows",defaultValue="20")Integer rows
			,@RequestParam(value="page",defaultValue="1")Integer page
	) throws Exception {
		

		//ApplicationContext applicationContext = ApplicationContainer.getApplicationContext();
		//SqlSessionProxyFactory sqlSessionFactory = applicationContext.getSqlSessionProxyFactory("core");
		try {
			//TransactionManager.begin();
			for(int idx = 0; idx < 10; idx ++) {
				//SqlSessionProxy sqlSession = sqlSessionFactory.openSession((idx%2==0?"oltp":"olap"));
				//UserDao userDao = sqlSession.getMapper(UserDao.class);
				User user = new User(UUID.randomUUID().toString().replaceAll("-",""));
				userDao.insertUser(user);
				//sqlSession.commit();
				//sqlSession.close();
			}
			//TransactionManager.commit();
		}catch(Exception e) {
			e.printStackTrace(System.err);
			//TransactionManager.rollback();
			throw e;
		}finally {
			//TransactionManager.close();
		}
		
		//SqlSessionProxy sqlSession = sqlSessionFactory.openSession();
		//UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> userList = userDao.selectUserList(key, value, 1, 1);
		System.out.println(TextTableBuilder.build(userList));
		//sqlSession.close();
		
		return new ResponseEntity<>(JsonConverter.convertObjectToJson(userList), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getUser(
			 @RequestParam(value="userId")String userId
	) throws Exception {
		return new ResponseEntity<>(new ValueMap(), HttpStatus.OK);
	}

	
}