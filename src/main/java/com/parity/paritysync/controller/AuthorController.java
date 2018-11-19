package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.bean.Author;
import com.parity.paritysync.service.AuthorService;
import com.parity.paritysync.utils.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.parity.paritysync.utils.ReturnMessage.OPERATE_SUCCESS;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{pageNum}")
    public ReturnMessage read(@PathVariable("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<Author> blockList = authorService.selectAll();
        PageInfo<Author> pageInfo = new PageInfo<>(blockList);
        return ReturnMessage.success(OPERATE_SUCCESS).add("author", pageInfo);
    }
}
