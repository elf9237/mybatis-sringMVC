package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;



/**
 * @author andy
 * @date 2017年2月22日 下午4:37:49
 * @version 1.0
 */
public class MybatisFirst {
	@Test
	public void findUserByNameById() throws IOException {
		//定义mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.findUserById",1);
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
}

