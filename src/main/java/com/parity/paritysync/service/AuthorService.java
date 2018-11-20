package com.parity.paritysync.service;

import com.parity.paritysync.bean.Author;
import com.parity.paritysync.dao.AuthorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private Logger logger = LoggerFactory.getLogger(AuthorService.class);

    private final AuthorMapper authorMapper;

    public AuthorService(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public Author selectByAddress(String address) {
        return authorMapper.selectByAddress(address);
    }

    public Author selectByPrimaryKey(Long id) {
        return authorMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(Author author) {
        return authorMapper.insertSelective(author);
    }

    public int updateSelectiveByAddress(Author author) {
        return authorMapper.updateSelectiveByAddress(author);
    }

    public List<Author> selectAll() {
        return authorMapper.selectAll();
    }

    public int batchInsertSelective(List<Author> authorList) {
        if (authorList != null && authorList.size() > 0) {
            logger.info("insert author size = " + authorList.size());
            return authorMapper.batchInsertSelective(authorList);
        }
        return 0;
    }
}
