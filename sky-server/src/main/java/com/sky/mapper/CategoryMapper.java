package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     *
     * @param category
     * @return
     */
    void update(Category category);

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @Delete("delete from category where id=#{id}")
    void delete(@Param(value = "id") Integer id);

    /**
     * 新增分类
     *
     * @param category
     * @return
     */
    @Insert("insert into category" +
            "(type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "values (#{type},#{name},#{status},#{sort},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void save(Category category);
}
