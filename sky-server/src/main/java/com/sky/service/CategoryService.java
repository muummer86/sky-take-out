package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

public interface CategoryService {

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     *
     * @param categoryDTO
     * @return
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 启用、禁用分类
     *
     * @param status
     * @param id
     * @return
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    void save(CategoryDTO categoryDTO);
}
