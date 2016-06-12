package com.test;

import java.util.List;

import org.fjzzy.domain.Comment;
import org.fjzzy.domain.Pet;
import org.fjzzy.domain.Reply;
import org.fjzzy.service.CommentService;
import org.fjzzy.service.PetService;


public class App {
	public static void main(String[] args) {
		PetService petService = new PetService();
		Pet pet = petService.getPetById(1, true);
		for(Comment comment : pet.getCommentList()){
			System.out.println(comment.getCommentContent());
		}
		CommentService commentService = new CommentService();
		List<Comment> list = commentService.getCommentsByPetId(1, true);
		for(Comment comment : list){
			System.out.println("--" + comment.getCommentContent());
			for(Reply reply : comment.getReplyList()){
				System.out.println("----" + reply.getReplyContent());
			}
		}
	}
}
