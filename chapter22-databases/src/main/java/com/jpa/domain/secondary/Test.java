package com.jpa.domain.secondary;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yushi on 2018/4/26.
 */
@Entity
@Table
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
