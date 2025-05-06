package com.example.movie_managing.controller;

import com.example.movie_managing.model.Movie;
import com.example.movie_managing.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // 영화 추가
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // 영화 목록 조회
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // 영화 상세 조회
    @GetMapping("/{title}")
    public Movie getMovie(@PathVariable String title) {
        Movie movie = movieService.getMovieByTitle(title);

        // getTitle 외의 메서드들도 사용할 수 있도록 추가
        String genre = movie.getGenre();
        String director = movie.getDirector();
        String releaseDate = movie.getReleaseDate();

        // 필드 정보를 출력
        System.out.println("Genre: " + genre);
        System.out.println("Director: " + director);
        System.out.println("Release Date: " + releaseDate);

        return movie;
    }

    // 영화 삭제
    @DeleteMapping("/{title}")
    public String deleteMovie(@PathVariable String title) {
        return movieService.deleteMovie(title);
    }

    // 영화 수정 (UPDATE)
    @PutMapping("/{title}")
    public Movie updateMovie(@PathVariable String title, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(title, updatedMovie);
    }
}


