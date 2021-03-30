package com.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;
//import com.User.UserDetails;
public class PostDAO {

	private Connection con;
	
	public PostDAO(Connection con){
		super();
		this.con = con;
		
	}
	public boolean AddNotes(String title,String content,int uid)
	{
		boolean f=false;
		try{
			String qu="insert into post(title,content,uid) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(qu);
			ps.setString(1,title);
			ps.setString(2,content);
			ps.setInt(3,uid);
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e){
			
		}
		return f;
	}
	public List<Post> getData(int id)
	{
		List<Post> list=new ArrayList<Post>();
		Post po=null;
		try{
			String qu="select * from post where uid=? order by id DESC";
			PreparedStatement ps=con.prepareStatement(qu);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				po=new Post();
				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
				po.setPdate(rs.getTimestamp(4));

				list.add(po);
			}
		}catch(Exception e){
			
		}
		return list;
	}
	public Post getDataById(int noteid)
	{
		Post p=null;
		try
		{
			String qu="select * from post where id=?";
			PreparedStatement ps=con.prepareStatement(qu);
			ps.setInt(1, noteid);
			ResultSet rs=ps.executeQuery();
		
			if(rs.next())
			{
				p=new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}
	
	public boolean PostUpdate(int noteid,String title,String content)
	{
		boolean f=false;
		try{
			 String qu="update post set title=?,content=? where id=?";
			 PreparedStatement ps=con.prepareStatement(qu);
			 ps.setString(1, title);
			 ps.setString(2, content);
			 ps.setInt(3, noteid);
			 int i=ps.executeUpdate();
			 if(i==1)
			 {
				 f=true;
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean DeleteNotes(int noteid)
	{
		boolean f=false;
		try{
			String qu="delete from post where id=?";
			PreparedStatement ps=con.prepareStatement(qu);
			ps.setInt(1, noteid);
			int x=ps.executeUpdate();
			if(x==1)
			{
				f=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
}