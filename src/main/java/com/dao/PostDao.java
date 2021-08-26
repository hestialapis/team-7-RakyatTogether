package com.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import com.dao.bean.Post;

public class PostDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nrpprofile", "root", "Shkw150500");
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int save(Post p) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into posts_table(postContent, profileID, postTag) values (?,?,?)");
			ps.setString(1,  p.getPostContent());
			ps.setString(2,  p.getProfileID());
			ps.setString(3,  p.getPostTag());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
			}
		return status;
	}
	
	public static int update (Post p) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update posts_table set postContent = ?, profileID = ?, postTag = ? where postID = ?");
			ps.setString(1,  p.getPostContent());
			ps.setString(2,  p.getProfileID());
			ps.setString(3,  p.getPostTag());
			ps.setInt(4, p.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
			}
		return status;
	}
	
	public static int updateLikes (Post p) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update posts_table set postLike = postLike + 1 where postID = ?");
			ps.setInt(1, p.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
			}
		return status;
	}
	
	public static int updateDislikes (Post p) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update posts_table set postDislike = postDislike + 1 where postID = ?");
			ps.setInt(1, p.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
			}
		return status;
	}
	
	public static int delete(Post p) {
        int status = 0;
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from posts_table where id = ?");
            ps.setInt(1, p.getId());
            status = ps.executeUpdate();
        }catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
	
	public static List<Post> getAllRecords(){
		List<Post> list = new ArrayList<Post>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from posts_table order by postLike - postDislike desc");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Post p = new Post();
				p.setId(rs.getInt("postID"));
				p.setPostContent(rs.getString("postContent"));
				p.setProfileID(rs.getString("profileID"));
				p.setPostTag(rs.getString("postTag"));
				p.setPostLike(rs.getString("postLike"));
				p.setPostDislike(rs.getString("postDislike"));
				list.add(p);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			}
		return list;
	}
	
	public static List<Post> getAllRecordsLatest(){
		List<Post> list = new ArrayList<Post>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from posts_table order by postID desc");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Post p = new Post();
				p.setId(rs.getInt("postID"));
				p.setPostContent(rs.getString("postContent"));
				p.setProfileID(rs.getString("profileID"));
				p.setPostTag(rs.getString("postTag"));
				p.setPostLike(rs.getString("postLike"));
				p.setPostDislike(rs.getString("postDislike"));
				list.add(p);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			}
		return list;
	}
	
	public static List<Post> getAllRecordsByTag(){
		List<Post> list = new ArrayList<Post>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from posts_table where postTag = 'Vacancy'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Post p = new Post();
				p.setId(rs.getInt("postID"));
				p.setPostContent(rs.getString("postContent"));
				p.setProfileID(rs.getString("profileID"));
				p.setPostTag(rs.getString("postTag"));
				p.setPostLike(rs.getString("postLike"));
				p.setPostDislike(rs.getString("postDislike"));
				list.add(p);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			}
		return list;
	}
	
	public static Post getRecordById(int postID) {
		Post p = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from posts_table where postID = ?");
			ps.setInt(1, postID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p = new Post();
				p.setId(rs.getInt("postID"));
				p.setPostContent(rs.getString("postContent"));
				p.setProfileID(rs.getString("profileID"));
				p.setPostTag(rs.getString("postTag"));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			}
		return p;
	}
}
