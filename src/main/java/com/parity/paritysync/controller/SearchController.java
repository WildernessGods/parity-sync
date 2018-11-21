package com.parity.paritysync.controller;

import com.parity.paritysync.bean.Author;
import com.parity.paritysync.bean.Block;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.service.AuthorService;
import com.parity.paritysync.service.BlockService;
import com.parity.paritysync.service.TransactionsService;
import com.parity.paritysync.utils.ParityLog;
import com.parity.paritysync.utils.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public ReturnMessage search(@RequestParam("search") String search) {

        Author author = authorService.selectByAddress(search);
        Map<String, List<ReturnTransactions>> addressTransactions = new HashMap<>();
        if (author != null) {
            addressTransactions.put(search, transactionsService.selectForSearchByAuthor(author.getAddress()));
        }

        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(search);
        Block block = null;
        if (matcher.matches()) {
            block = blockService.selectByPrimaryKey(Long.valueOf(search));
        }

        ReturnTransactions returnTransactions = transactionsService.selectByTxHash(search);

        return ReturnMessage.success(ReturnMessage.OPERATE_SUCCESS)
                .add("AddressTransactions", addressTransactions)
                .add("Block", block)
                .add("Transactions", returnTransactions);
    }
}
