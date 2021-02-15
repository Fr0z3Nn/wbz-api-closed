package com.wbz.wbzapi.repository;

import com.wbz.wbzapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    Optional<Item> findById(Long id);

    @Override
    List<Item> findAll();

    @Override
    <S extends Item> S save(S s);

    @Override
    void deleteById(Long id);

    Item findByName(String name);
}
