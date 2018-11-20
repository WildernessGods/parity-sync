package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Author;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    Author selectByAddress(String address);

    int updateSelectiveByAddress(Author author);

    int updateTransactionsCountByAddress(@Param("address") String address, @Param("transactionscount") Long transactionscount);

    List<Author> selectAll();

    int batchInsertSelective(List<Author> authorList);
}