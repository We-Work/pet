package org.fjzzy.domain;
import java.sql.Timestamp;

public class Reply {
	private int replyId;
	private int replyUserId;
	private int replyCommentId;
	private String replyContent;
	private Timestamp replyDate;
	
	//引用外键
	private User user;
	private Comment comment;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public int getReplyCommentId() {
		return replyCommentId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public Timestamp getReplyDate() {
		return replyDate;
	}
	public int getReplyId() {
		return replyId;
	}
	public int getReplyUserId() {
		return replyUserId;
	}
	public void setReplyCommentId(int replyCommentId) {
		this.replyCommentId = replyCommentId;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}
}
