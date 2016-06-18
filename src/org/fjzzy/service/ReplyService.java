package org.fjzzy.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.fjzzy.domain.Reply;
import org.fjzzy.util.SqlHelper;

public class ReplyService extends AbstractService{
	private static UserService userService = new UserService();
	private static CommentService commentService = new CommentService();
	
	//commentId获取Reply
	public List<Reply> getRepliesByCommentId(java.io.Serializable id, boolean load){
		String sql = "select * from reply where reply_comment_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		List<Object[]> replyList = SqlHelper.executeQuery(sql, paras);
		ArrayList<Reply> list = new ArrayList<Reply>();
		for(Object[] obj : replyList){
			Reply reply = parserReply(obj);
			if(load){
				reply.setUser(userService.getUserById(reply.getReplyUserId(), !load));
				reply.setComment(commentService.getCommentById(reply.getReplyCommentId(), !load));
			}
			list.add(reply);
		}
		return list;
	}
	//按replyID获取Reply
	public Reply getReplyById(java.io.Serializable id, boolean load){
		String sql = "select * from reply where reply_id = ?";
		Object[] paras = {id};
		@SuppressWarnings("unchecked")
		List<Object[]> list = SqlHelper.executeQuery(sql, paras);
		Reply reply = null;
		if(!list.isEmpty()){
			reply = parserReply(list.get(0));
			if(load){
				reply.setUser(userService.getUserById(reply.getReplyUserId(), !load));
				reply.setComment(commentService.getCommentById(reply.getReplyCommentId(), !load));
			}
		}
		return reply;
	}
	
	public Reply parserReply(Object[] obj){
		Reply reply = new Reply();
		if(obj[0] != null){
			reply.setReplyId(Integer.parseInt(obj[0].toString()));
		}
		if(obj[1] != null){
			reply.setReplyUserId(Integer.parseInt(obj[1].toString()));
		}
		if(obj[2] != null){
			reply.setReplyCommentId(Integer.parseInt(obj[2].toString()));
		}
		if(obj[3] != null){
			reply.setReplyContent(obj[3].toString());
		}
		if(obj[4] != null){
			reply.setReplyDate((Timestamp)obj[4]);
		}
		return reply;
	}
	
}
