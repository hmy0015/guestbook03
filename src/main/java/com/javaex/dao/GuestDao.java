package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<GuestVo> getBookList() {
		List<GuestVo> bookList = sqlSession.selectList("guestbook.select");

		return bookList;
	}

	// 추가
	public void bookInsert(GuestVo bookVo) {
		sqlSession.insert("guestbook.insert", bookVo);
	}

	// 삭제
	public void bookDelete(int no, String pw) {
			Map<String, Object> gMap = new HashMap<String, Object>();
			gMap.put("no", no);
			gMap.put("pw", pw);
			
			sqlSession.delete("guestbook.delete", gMap);
	}
}
