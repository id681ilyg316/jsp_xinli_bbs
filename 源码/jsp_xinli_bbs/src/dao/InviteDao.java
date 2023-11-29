package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import bean.Invite;
import bean.Post;
import util.DBUtil;

public class InviteDao {

	public void insertInvite(Invite invite) {
		Connection cont = DBUtil.getConnection();
		String sql = "insert into invite (id,fromuser,touser,postid,time) values(?,?,?,?,?)";
		try {
			PreparedStatement prepStmt = cont.prepareStatement(sql);
			prepStmt.setString(1, invite.getId());
			prepStmt.setString(2, invite.getFrom());
			prepStmt.setString(3, invite.getTo());
			prepStmt.setString(4, invite.getPostid());
			prepStmt.setString(5, invite.getTime());
			System.out.println(prepStmt.toString());
			prepStmt.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			cont.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Invite> getInviteListByTo(String to) {
		Connection cont = DBUtil.getConnection();
		List<Invite> invites = new ArrayList<Invite>();
		String sql = "select * from invite where touser= ?";
		try {
			PreparedStatement prepStmt = cont.prepareStatement(sql);
			prepStmt.setString(1,to);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				Invite invite = new Invite();
				invite.setId(rs.getString("id"));
				invite.setPostid(rs.getString("postid"));
				invite.setFrom(rs.getString("fromuser"));
				invite.setTo(rs.getString("touser"));
				invite.setTime(rs.getString("time"));
				invites.add(invite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			cont.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invites;
	}
	
	public List<Invite> getInviteListByFrom(String to) {
		Connection cont = DBUtil.getConnection();
		List<Invite> invites = new ArrayList<Invite>();
		String sql = "select * from invite where fromuser= ?";
		try {
			PreparedStatement prepStmt = cont.prepareStatement(sql);
			prepStmt.setString(1,to);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				Invite invite = new Invite();
				invite.setId(rs.getString("id"));
				invite.setPostid(rs.getString("postid"));
				invite.setFrom(rs.getString("fromuser"));
				invite.setTo(rs.getString("touser"));
				invite.setTime(rs.getString("time"));
				invites.add(invite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			cont.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invites;
	}
}
