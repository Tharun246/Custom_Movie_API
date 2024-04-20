package com.example.demo.Service;

import com.example.demo.Entity.Movie;

import java.util.List;

public interface MovieMethods
{
    List<Movie> getMovies();

    Movie getMovie(String Name);

    Movie addMovie(Movie newMovie);

    Movie updateMovie(String Name,Movie newMovie);

    String deleteMovie(String Name);

}
