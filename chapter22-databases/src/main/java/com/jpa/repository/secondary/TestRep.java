package com.jpa.repository.secondary;

import com.jpa.domain.secondary.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yushi on 2018/4/26.
 */
//@Repository
public interface TestRep extends JpaRepository<Test,Integer>{
}
