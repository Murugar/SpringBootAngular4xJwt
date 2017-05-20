package com.iqmsoft.boot.jwt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.iqmsoft.boot.jwt.model.DeletableModel;

import java.util.List;


@NoRepositoryBean
public interface DeletableModelRepository<T extends DeletableModel>
        extends PagingAndSortingRepository<T, Long> {

    @Override
    @Query( "select m from #{#entityName} m where m.deletedAt IS NULL Order By m.id" )
    public List<T> findAll();

}
