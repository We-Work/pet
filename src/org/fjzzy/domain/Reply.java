package org.fjzzy.domain;
import java.sql.*;
public class Reply {
	private int replyId;
	private int replyCommentId;
	private String replyContent;
	private Date replyDate;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getReplyCommentId() {
		return replyCommentId;
	}
	public void setReplyCommentId(int replyCommentId) {
		this.replyCommentId = replyCommentId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
}
