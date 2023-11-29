package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Invite;
import dao.InviteDao;
import dao.PostDao;
import dao.UserDao;

public class InviteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String postid=req.getParameter("postid");
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		UserDao userDao = new UserDao();
		int toid = 0;
		try {
			toid = userDao.getUserByNickName(to).get(0).getUser_id();
		} catch (Exception e) {
			out.print("操作成功！");
			return;
		}
		Invite invite = new Invite();
		invite.setId(UUID.randomUUID().toString());
		invite.setPostid(postid);
		invite.setFrom(from);
		invite.setTo(toid+"");
		invite.setTime(String.valueOf(new Date()));
		InviteDao inviteDao = new InviteDao();
		inviteDao.insertInvite(invite);
		out.print("操作成功！");
	}

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	    	       

	}

}
