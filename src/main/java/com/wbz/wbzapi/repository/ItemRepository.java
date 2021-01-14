package com.wbz.wbzapi.repository;

import com.wbz.wbzapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    List<Item> findAll();

    @Override
    <S extends Item> S save(S s);

    @Override
    void deleteById(Long id);
}
