package day0530;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class HelloMyBatis {
	
	public void useMyBatis() {
		
		//1.설정용 XML과 연결
		try {
			Reader reader=Resources.getResourceAsReader("day0530/mybatis-config.xml");
			/*
			 * SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			 * SqlSessionFactory ssf=ssfb.build(reader);
			 */
			
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			
			//3.mybatis handler얻기
			SqlSession ss= ssf.openSession();
			
			//4.handler 사용한 조작
			List<Dept> list=ss.selectList("kr.co.sist.hello.selectAllDept");
			for(Dept dept:list) {
				System.out.println(dept.getDeptno()+"/"+dept.getDname()+"/"+dept.getLoc());
			}
			//5.mybatis handler 닫기
			ss.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}

	public static void main(String[] args) {
		new HelloMyBatis().useMyBatis();
	}

}
