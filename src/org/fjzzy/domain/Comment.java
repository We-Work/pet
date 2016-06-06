package org.fjzzy.domain;
import java.sql.*;
public class Comment {
	private int commentId;
	private int commentUserId;
	private int commentPetId;
	private String commentContent;
	private Timestamp commentDate;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public int getCommentPetId() {
		return commentPetId;
	}
	public void setCommentPetId(int commentPetId) {
		this.commentPetId = commentPetId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
}
