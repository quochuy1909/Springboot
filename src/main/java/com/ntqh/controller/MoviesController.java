package com.ntqh.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntqh.model.Movies;
import com.ntqh.service.MoviesService;

@RestController
public class MoviesController {
	@Autowired
	MoviesService moviesService;
	@GetMapping("/movies/all")
	public ResponseEntity<List<Movies>> getAllMovies(){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return new ResponseEntity<List<Movies>>(moviesService.allMovies(),responseHeaders,HttpStatus.OK);
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movies> getMoviesById(@PathVariable("id") int id){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return new ResponseEntity<Movies>(moviesService.movieById(id),responseHeaders,HttpStatus.OK);
	}
	
	@GetMapping("/movies/page/{pageNumber}")
	public ResponseEntity<List<Movies>> getMoviesByPagegination(@PathVariable("pageNumber")int pageNumber){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		List<Movies> list = moviesService.movieByPagination(pageNumber).toList();
		return new ResponseEntity<List<Movies>>(list,responseHeaders,HttpStatus.OK);
	}
	@GetMapping("/movies/put/{id}/{view}")
	public ResponseEntity<String> updateViewMovies(@PathVariable("id") int id,
			@PathVariable("view") int view) {
		moviesService.movieUpdateByView(id,view);
		return ResponseEntity.ok("increase view");
	}
	
	@DeleteMapping("/movies/admin/delete/{id}")
	public ResponseEntity<String> deleteMovieById(@PathVariable("id") int id) {
		moviesService.movieDeletedById(id);
		return ResponseEntity.ok("deleted");
	}
	@PostMapping("/movies/admin/add")
	public ResponseEntity<Movies> addMovie(@RequestBody Movies movie){
		moviesService.movieAdd(movie);
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/movies/admin/update/{id}/{title}/{description}/{link}/{image}/{views}")
	public ResponseEntity<Movies> updateMovie(@PathVariable("id") int id,@PathVariable("title") String title,@PathVariable("description") String description
			,@PathVariable("link") String link,@PathVariable("image") String image,@PathVariable("views") int views){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return new ResponseEntity<Movies>(moviesService.updateMovie(description,
				title,image , link
				 , views, id),responseHeaders,HttpStatus.OK);
	}
	@GetMapping("/movies/admin/create/{title}/{des}/{link}/{image}/{views}")
	public ResponseEntity<String> createMovie(@PathVariable("title") String title,@PathVariable("des") String des,
			@PathVariable("link") String link,@PathVariable("image") String image,@PathVariable("views") int views){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return new ResponseEntity<String>(moviesService.creacteMovie(des, title, image, link, views),responseHeaders,HttpStatus.OK);
	}
	@PostMapping("/api/user")
	public ResponseEntity<String> testUser(@RequestBody String user) throws URISyntaxException{
		System.out.println(user);
		return  new ResponseEntity<String>(user,HttpStatus.OK);
	}
}

	

