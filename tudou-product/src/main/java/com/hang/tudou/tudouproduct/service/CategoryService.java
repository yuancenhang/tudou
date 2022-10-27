
package com.hang.tudou.tudouproduct.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hang.tudou.tudouproduct.entity.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {

    List<Category> getAll();
}