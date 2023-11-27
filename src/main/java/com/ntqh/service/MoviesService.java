package com.ntqh.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ntqh.dao.MoviesDAO;
import com.ntqh.model.Movies;
@Service
public class MoviesService {
	@Autowired
	private MoviesDAO moviesDAO;
	
	public List<Movies> allMovies(){
		return moviesDAO.findAll();
	}
	public Movies movieById(int id) {
		return moviesDAO.findById(id).get();
	}
	
	public Page<Movies> movieByPagination(int pageNumber){
		Sort sort = Sort.by(Sort.Direction.DESC, "views");
		Pageable pageable = PageRequest.of(pageNumber, 6,sort);
		return moviesDAO.findAll(pageable);
	}
	
	public String movieUpdateByView(int id, int view) {
		Movies movie = moviesDAO.getById(id);
		movie.setViews(view);
		moviesDAO.save(movie);
		return "";
	}
	
	public String movieDeletedById(int id) {
		moviesDAO.deleteById(id);
		return "Deleted Movie";
	}
	
//	public String createMovie(int id, String title, String link,
//			String image, String description, int views) {
//		Movies mov = new Movies();
//		return "";
//	}
	
	public List<Movies> movieAdd(Movies movies){
		moviesDAO.save(movies);
		return moviesDAO.findAll();
	}
	
	public Movies updateMovie(String des, String title, String image, String link, int views,int id) {
		Movies movi = moviesDAO.getById(id);
		movi.setDescription(des);
		movi.setTitle(title);
		movi.setImage(image);
		movi.setViews(views);
		movi.setLink(link);
		moviesDAO.save(movi);
		return movi;
				
	}
	
	public String creacteMovie(String des, String title, String image, String link, int views ) {
		Movies movi = new Movies();
		movi.setDescription(des);
		movi.setImage(image);
		movi.setTitle(title);
		movi.setLink(link);
		movi.setViews(views);
		moviesDAO.save(movi);
		return "create movie successfully";
	}
}
