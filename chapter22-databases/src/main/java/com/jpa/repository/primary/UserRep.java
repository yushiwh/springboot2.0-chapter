package com.jpa.repository.primary;

import com.jpa.domain.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yushi on 2018/4/26.
 */
//@Repository
public interface UserRep extends JpaRepository<User,Integer>{
}
