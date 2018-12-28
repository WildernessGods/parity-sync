package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.bean.Author;
import com.parity.paritysync.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{pageNum}")
    public ResponseEntity read(@PathVariable("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<Author> blockList = authorService.selectAll();
        PageInfo<Author> pageInfo = new PageInfo<>(blockList);
        return ResponseEntity.ok(Mono.justOrEmpty(pageInfo));
    }
}
