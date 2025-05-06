package com.example.movie_managing.service;

import com.example.movie_managing.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList = new ArrayList<>();

    // 영화 추가
    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    // 영화 목록 조회
    public List<Movie> getAllMovies() {
        return movieList;
    }

    // 영화 제목으로 조회
    public Movie getMovieByTitle(String title) {
        return movieList.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    // 영화 삭제
    public String deleteMovie(String title) {
        movieList.removeIf(movie -> movie.getTitle().equals(title));
        return "삭제 완료!";
    }

    // 영화 수정 (UPDATE)
    public Movie updateMovie(String title, Movie updatedMovie) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(title)) {
                movie.setGenre(updatedMovie.getGenre());
                movie.setDirector(updatedMovie.getDirector());
                movie.setReleaseDate(updatedMovie.getReleaseDate());
                return movie;
            }
        }
        return null;  // 제목에 해당하는 영화X -> null
    }
}

