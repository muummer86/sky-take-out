package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分类分页查询");
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 修改分类
     *
     * @param categoryDTO
     * @return
     */
    @Override
    public void update(CategoryDTO categoryDTO) {
        log.info("修改分类");
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    /**
     * 启用、禁用分类
     *
     * @param status
     * @param id
     * @return
     */
    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = Category.builder()
                                    .id(id)
                                    .status(status)
                                    .build();
        categoryMapper.update(category);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        categoryMapper.delete(id);
    }


    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                                    .name(categoryDTO.getName())
                                    .sort(categoryDTO.getSort())
                                    .type(categoryDTO.getType())
                                    .build();
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.save(category);
    }


}
