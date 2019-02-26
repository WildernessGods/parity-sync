package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.bean.Author;
import com.parity.paritysync.service.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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

    public Mono<ServerResponse> sendTimePerSec(ServerRequest request) {

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1)).map(l -> authorService.selectByPrimaryKey((long) new Random().nextInt(3212965))), Author.class);
    }
}
