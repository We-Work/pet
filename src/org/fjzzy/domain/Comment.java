package org.fjzzy.domain;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Comment {
	private int commentId;
	private int commentUserId;
	private int commentPetId;
	private String commentContent;
	private Timestamp commentDate;
	//引用外键
	private User user;
	private Pet pet;
	//引用主键
	private List<Reply> replyList = new ArrayList<Reply>();
	
	public String getCommentContent() {
		return commentContent;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public int getCommentId() {
		return commentId;
	}
	public int getCommentPetId() {
		return commentPetId;
	}
	
	public int getCommentUserId() {
		return commentUserId;
	}
	public Pet getPet() {
		return pet;
	}
	
	public List<Reply> getReplyList() {
		return replyList;
	}
	public User getUser() {
		return user;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public void setCommentPetId(int commentPetId) {
		this.commentPetId = commentPetId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
