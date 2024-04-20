package com.example.demo.Service;

import com.example.demo.Entity.Movie;
import com.example.demo.Repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieMethods
{
    @Autowired
    private MoviesRepo moviesRepo;

    @Override
    public List<Movie> getMovies() {
        return moviesRepo.findAll();
    }

    @Override
    public Movie getMovie(String Name) {
        return moviesRepo.findByName(Name);
    }

    @Override
    public Movie addMovie(Movie newMovie) {
        return moviesRepo.save(newMovie);
    }

    @Override
    public Movie updateMovie(String Name, Movie newMovie)
    {
        Optional<Movie> existing= Optional.ofNullable(moviesRepo.findByName(Name));
        if(existing.isPresent())
        {
            Movie movie=existing.get();
            if(newMovie.getName()!=null)
            {
                movie.setName(newMovie.getName());
            }
            if(newMovie.getDirector()!=null)
            {
                movie.setDirector(newMovie.getDirector());
            }
            if(newMovie.getGenre()!=null)
            {
                movie.setGenre(newMovie.getGenre());
            }
            if(newMovie.getPoster()!=null)
            {
                movie.setPoster(newMovie.getPoster());
            }
            if (newMovie.getRelease_Year()!=0) {
                movie.setRelease_Year(newMovie.getRelease_Year());
            }
            return movie;
        }
        else throw new Error("Movie with name "+Name+" not found");
    }

    @Override
    public String deleteMovie(String Name)
    {
            Movie movie=moviesRepo.findByName(Name);
            moviesRepo.delete(movie);
            return  "movie "+Name+" is deleted";
//            else throw new Error("No such Movie My friend");
    }
}
