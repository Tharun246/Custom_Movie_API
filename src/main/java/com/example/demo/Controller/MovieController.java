package com.example.demo.Controller;
import com.example.demo.Entity.Movie;
import com.example.demo.Service.MovieService;
import com.example.demo.Repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController
{
    @Autowired
    private MovieService movieService;
    private MoviesRepo moviesRepo;

    @GetMapping(path = "/all")
    public List<Movie> getMovies()
    {
        return movieService.getMovies();
    }

    @GetMapping(path = "/{Name}")
    public Movie getMovie(@PathVariable String Name)
    {
        return movieService.getMovie(Name);
    }

    @PostMapping(path = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movie newMovie, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
           return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }

    @PutMapping(path = "/update/{Name}")
    public Movie updateMovie(@Validated @PathVariable String Name, @RequestBody Movie newMovie)
    {
        return movieService.updateMovie(Name,newMovie);
    }

    @DeleteMapping(path = "/delete/{Name}")
    public String deleteMovie(@PathVariable String Name)
    {
        movieService.deleteMovie(Name);
        return "Movie "+Name+" is deleted from the database";
    }
}
