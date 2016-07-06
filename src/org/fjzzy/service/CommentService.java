package org.fjzzy.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.Pet;
import org.fjzzy.util.PageBean;
import org.fjzzy.util.SqlHelper;

public class CommentService extends AbstractService{
	
	private static UserService userService = new UserService();
	private static PetService petService = new PetService();
	private static ReplyService replyService = new ReplyService();
	
	//按pet_id获取评论
	public ArrayList<Comment> getCommentsByPetId(java.io.Serializable id, boolean load){
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		
		String sql = "select * from comment where comment_pet_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		for(Object[] obj : list){
			Comment comment = parserComment(obj);
			if(load){
				comment.setPet(petService.getPetById(comment.getCommentPetId(), !load));
				comment.setUser(userService.getUserById(comment.getCommentUserId(), !load));
				comment.setReplyList(replyService.getRepliesByCommentId(comment.getCommentId(), load));
			}
			commentList.add(comment);
		}
		return commentList;
	}
	//按Id获取Comment
	public Comment getCommentById(java.io.Serializable id, boolean load){
		String sql = "select * from comment where comment_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		Comment comment = null;
		if(!list.isEmpty()){
			comment = parserComment(list.get(0));
			if(load){
				comment.setPet(petService.getPetById(comment.getCommentPetId(), !load));
				comment.setUser(userService.getUserById(comment.getCommentUserId(), !load));
				comment.setReplyList(replyService.getRepliesByCommentId(comment.getCommentId(), !load));
			}
		}
		return comment;
	}
	
	//添加一条回复
	public boolean addComment(Comment comment){
		String sql = "insert into comment(comment_user_id, comment_pet_id, comment_content)"
				+ "values(?, ?, ?)";
		Object[] paras = {comment.getCommentUserId(), comment.getCommentPetId(), comment.getCommentContent()};
		int i = SqlHelper.executeUpdate(sql, paras);
		return i == 1 ? true : false;
	}
	
	//获取评论
	public ArrayList<Comment> getListByPage(PageBean pageBean, boolean load){
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		String sql = "select * from comment limit ?,?";
		Object[] paras = {(pageBean.getPageNow()-1)*pageBean.getPageSize(), pageBean.getPageSize()};
		pageBean.setRowCount(this.getRowCount("select count(*) from comment", null));
		int pageCount = (pageBean.getRowCount()-1) / pageBean.getPageSize() + 1;
		pageBean.setPageCount(pageCount);
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		for(Object[] obj : list){
			Comment comment = parserComment(obj);
			if(load){
				comment.setUser(userService.getUserById(comment.getCommentUserId(), !load));
			}
			commentList.add(comment);
		}
		return commentList;
	}
	//删除评论
	public boolean deleteComment(Comment comment){
		String sql = "delete from comment where comment_id = ?";
		Object[] paras = {comment.getCommentId()};
		int i = SqlHelper.executeUpdate(sql, paras);
		if(i == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public Comment parserComment(Object[] obj){
		Comment comment = new Comment();
		if(obj[0] != null){
			comment.setCommentId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			comment.setCommentUserId(Integer.parseInt(obj[1].toString()));
		}
		if(obj[2] != null){
			comment.setCommentPetId(Integer.parseInt(obj[2].toString()));
		}
		if(obj[3] != null){
			comment.setCommentContent(obj[3].toString());
		}
		if(obj[4] != null){
			comment.setCommentDate((Timestamp)obj[4]);
		}
		return comment;
	}
}
