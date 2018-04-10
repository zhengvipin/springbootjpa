package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 持久层 由 jpa 管理
 *
 * @author Zheng
 */

public interface MovieRepository extends JpaRepository<Movie, Integer> {// 指定实体类名和主键类型
    // 包含了一般的增删改查

    /**
     * 根据电影名查询
     *
     * @param name
     * @return
     */
    List<Movie> findByName(String name);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Query(value="select * from #{#entityName} m where m.name like CONCAT('%',?1,'%')",nativeQuery=true)
    List<Movie> findByNameLike(String name);

    //@Query(value = "from Movie m where m.name like CONCAT('%',:name,'%')")
    //List<Movie> findByNameLike(@Param("name") String name);
}
