package com.parity.paritysync.controller;

import com.parity.paritysync.bean.Author;
import com.parity.paritysync.service.AuthorService;
import com.parity.paritysync.service.BlockService;
import com.parity.paritysync.service.TransactionsService;
import com.parity.paritysync.utils.ParityLog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static com.parity.paritysync.utils.Utils.NUMBER_PATTERN;

@RestController
public class SearchController {

    private final AuthorService authorService;

    private final BlockService blockService;

    private final TransactionsService transactionsService;

    public SearchController(AuthorService authorService, BlockService blockService, TransactionsService transactionsService) {
        this.authorService = authorService;
        this.blockService = blockService;
        this.transactionsService = transactionsService;
    }

    @ParityLog("检索地址，交易哈希，区块编号")
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("search") String search) {

        Map<String, Object> returnMap = new HashMap<String, Object>() {
            {
                put("AddressTransactions", null);
                put("Block", null);
                put("Transactions", null);
            }
        };

        Mono.just(search).doOnNext(s -> {
            Author author = authorService.selectByAddress(s);
            if (author != null) {
                returnMap.put("AddressTransactions", transactionsService.selectForSearchByAuthor(author.getAddress()));
            }
        }).doOnNext(s -> {
            if (NUMBER_PATTERN.matcher(s).matches()) {
                returnMap.put("Block", blockService.selectByPrimaryKey(Long.valueOf(s)));
            }
        }).doOnNext(s -> returnMap.put("Transactions", transactionsService.selectByTxHash(s)))
                .subscribe();

        return ResponseEntity.ok(Mono.justOrEmpty(returnMap));
    }
}
