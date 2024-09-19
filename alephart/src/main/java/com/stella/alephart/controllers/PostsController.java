package com.stella.alephart.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stella.alephart.dto.PostCreateDTO;
import com.stella.alephart.models.Posts;
import com.stella.alephart.services.PostsService;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	@Autowired
	private PostsService postService;
	
	// GET
		@GetMapping
		public List<Posts> getAllPosts() {
			return postService.findAllPosts();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Posts> getPostById(@PathVariable("id") Long id) {
			return postService.findPostById(id)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public ResponseEntity<Posts> createPost(
		        @RequestPart("post_file") MultipartFile postFile,
		        @RequestPart("post_date") String postDate,
		        @RequestPart("post_description") String postDescription,
		        @RequestPart("userId") Long userId,
		        @RequestPart("userProfileId") Long userProfileId) {
		    try {
		        // Convierte MultipartFile a byte[]
		        byte[] fileBytes = postFile.getBytes();

		        // Crea el DTO con los bytes del archivo
		        PostCreateDTO postCreateDTO = new PostCreateDTO(postDate, fileBytes, postDescription, userId, userProfileId);

		      
		        Posts createdPost = postService.savePost(postCreateDTO);
		        return ResponseEntity.ok(createdPost);
		    } catch (IOException e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		    } catch (RuntimeException e) {
		        return ResponseEntity.badRequest().body(null);
		    }
		}

		 
		
		// PUT
		@PutMapping("/{id}")
		public ResponseEntity<Posts> updatePost(@PathVariable("id") Long id, @RequestBody Posts updatedPost) {
	        try {
	            Posts post = postService.updatePost(id, updatedPost);
	            return ResponseEntity.ok(post);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
		
		// DELETE
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
			return postService.findPostById(id)
					.map(post -> {
						postService.deletePost(id);
						return ResponseEntity.ok().<Void>build();
					})
					.orElse(ResponseEntity.notFound().build());
		}
			
		/*
		 
		POST

		{
		"post_date":"2024-09-17",
		"post_file": null,
		"post_description": "descripción de la publicación",
		"userId": 2,
		"userProfileId": 2
		}

		PUT
		{
		"post_description": "Descripción actualizada"
		}
		 
		 * */

}