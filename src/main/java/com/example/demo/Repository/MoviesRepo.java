package com.example.demo.Repository;

import com.example.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepo extends JpaRepository<Movie,Long>
{
    Movie findByName(String Name);
//    Boolean isExist(String Name);
}
