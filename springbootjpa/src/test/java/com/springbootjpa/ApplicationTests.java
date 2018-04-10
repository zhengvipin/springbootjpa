package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Test
    public void save() {
        Movie movie = new Movie();
        movie.setName("逐梦演艺圈");
        movie.setPrice(70d);
        movie.setActionTime(new Date());

        movieService.save(movie);
    }

    @Test
    public void findAll() {
        for (Movie movie : movieService.findAll()) {
            System.out.println(movie.getName() + " " + movie.getPrice() + " " + movie.getActionTime());
        }
    }

    @Test
    public void findByName() {
        for (Movie movie : movieService.findByName("头号玩家")) {
            System.out.println(movie.getName() + " " + movie.getPrice() + " " + movie.getActionTime());
        }
    }

    @Test
    public void findByNameLike() {
        for (Movie movie : movieService.findByNameLike("头")) {
            System.out.println(movie.getName() + " " + movie.getPrice() + " " + movie.getActionTime());
        }
    }

    @Test
    public void findById() {
        // Optional 这是一个可以为null的容器对象
        Optional<Movie> optionalMovie = movieService.findById(1);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            System.out.println(movie.getName() + " " + movie.getPrice() + " " + movie.getActionTime());
        }
    }

    @Test
    public void deleteById(){
        movieService.deleteById(4);
    }
}
