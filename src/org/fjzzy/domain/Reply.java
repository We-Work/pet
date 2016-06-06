package org.fjzzy.domain;
import java.sql.*;
public class Reply {
	private int replyId;
	private int replyCommentId;
	private String replyContent;
	private Timestamp replyDate;
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
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
	public Timestamp getReplyDate() {
		return replyDate;
	}
}
