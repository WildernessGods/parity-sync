package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorMapper {

    Integer deleteByPrimaryKey(Long id);

    Integer insert(Author record);

    Integer insertSelective(Author record);

    Author selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(Author record);

    Integer updateByPrimaryKey(Author record);

    Author selectByAddress(String address);

    Integer updateSelectiveByAddress(Author author);

    List<Author> selectAll();

    Integer batchInsertSelective(List<Author> authorList);
}