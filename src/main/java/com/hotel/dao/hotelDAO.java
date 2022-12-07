package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotel.util.DBManager;
import com.hotel.vo.hotelVO;

public class hotelDAO {
	private hotelDAO() {}
	private static hotelDAO instance = new hotelDAO();
	public static hotelDAO getInstance() {
		return instance;
	}

	// 회원가입 메소드
	public void loginHotel(hotelVO hvo) {
		String sql = "insert into register(name,id,pass,email,lev,phone) values(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hvo.getName());
			pstmt.setString(2, hvo.getId());
			pstmt.setString(3, hvo.getPass());
			pstmt.setString(4, hvo.getEmail());
			pstmt.setString(5, hvo.getLev());
			pstmt.setString(6, hvo.getPhone());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);

		}

	}

	// 아이디 찾기 메소드
	public String idFind(String name, String email) {

		String id= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select id from register where name=? and email=?";
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);


			rs= pstmt.executeQuery();

			if(rs.next()) {
				id=rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return id;
	}
	//유저 check 메소드
	public int userCheck(String id,String pass,String lev) {
		int result=4;
		Connection conn=null;
		String sql="select * from register where id=?";
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println(id);
			rs=ps.executeQuery();
			//아이디값이 존재할경우
			if(rs.next()) {
				//비밀번호가 일치할경우
				if(pass.equals(rs.getString("pass"))) {
					if(lev.equals(rs.getString("lev"))) {

						// 관리자,일반회원 구분 lev이 일치할경우 관리자로 로그인 성공
						result=2;
						if(lev.equals("B")) {
							//lev이 B'일반회원'과 일치할경우 일반회원으로 로그인성공
							result=3;
						}
					}else { //레벨이 불일치할경우 
						result=1;
					}
				}else {//비밀번호가 다를경우
					result=0;
				}
			}//아이디가 없는경우
			else {
				result=-1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				DBManager.close(rs, ps, conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 회원정보를 가져올 getMember메소드 
	public hotelVO getMember(String id) {
		hotelVO member=null;
		String sql="select * from register where id=?";

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();

			//찾는건 한번이니깐 if문 사용
			if(rs.next()) {
				member=new hotelVO();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setLev(rs.getString("lev"));
				member.setPhone(rs.getString("phone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		return member;
	}

	// 아이디 중복체크 메소드
	public int confirmID(String id){
		int result=0;
		String sql="select id from register where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//찾는거 한번이니깐 if문사용
			if(rs.next()) {
				result=1; //아이디 존재할경우 1로지정
				System.out.println(result);
			}else {
				result=-1; //아이디가 존재하지않을경우 -1로 지정
				System.out.println(result);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}


}
