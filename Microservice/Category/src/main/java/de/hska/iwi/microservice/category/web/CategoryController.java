/*
 *    Copyright (c) 2016.   Joshua Braun
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package de.hska.iwi.microservice.category.web;

import de.hska.iwi.microservice.category.domian.Category;
import de.hska.iwi.microservice.category.service.ICategoryServiceFacade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ameo on 27.05.16.
 */
@RestController
public class CategoryController implements ICategoryController {
    private final Logger logger = Logger.getLogger(CategoryController.class);

    private ICategoryServiceFacade categoryServiceFacade;

    @Autowired
    public CategoryController(ICategoryServiceFacade categoryServiceFacade) {
        this.categoryServiceFacade = categoryServiceFacade;
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryServiceFacade.getAllCategories();
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Category createCategory(@ModelAttribute Category category) {
        return categoryServiceFacade.createCategory(category);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Category updateCategory(@ModelAttribute Category category) {
        return categoryServiceFacade.updateCategory(category);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable("id") int id) {
        return categoryServiceFacade.getCategory(id);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteCategory(@PathVariable("id") int id) {
        return categoryServiceFacade.deleteCategory(id);
    }
}
