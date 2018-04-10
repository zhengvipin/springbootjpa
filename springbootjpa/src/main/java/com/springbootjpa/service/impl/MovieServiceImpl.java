package com.springbootjpa.service.impl;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import com.springbootjpa.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑实现类
 *
 * @author Zheng
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Resource(name = "movieRepository")
    private MovieRepository movieRepository;

    /**
     * 新增(无id) | 修改(有id)
     * @param movie
     */
    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    /**
     * 根据电影名查询
     *
     * @param name
     * @return
     */
    @Override
    public List<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public List<Movie> findByNameLike(String name) {
        return movieRepository.findByNameLike(name);
    }

}
