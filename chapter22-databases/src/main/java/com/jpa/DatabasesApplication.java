package com.jpa;

import com.jpa.domain.primary.User;
import com.jpa.domain.secondary.Test;
import com.jpa.repository.primary.UserRep;
import com.jpa.repository.secondary.TestRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DatabasesApplication {


    public static void main(String[] args) {
        SpringApplication.run(DatabasesApplication.class, args);
    }


}
