package com.football.cassandra;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.football.entity.PlayerEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class SpringBootCassandraApplicationTest {
    @Autowired
    private CassandraAdminOperations adminTemplate;


    @Before
    public void createTable() {
        adminTemplate.createTable(true, CqlIdentifier.fromInternal(PlayerEntity.class.getSimpleName().toLowerCase()), PlayerEntity.class, new HashMap<>());
    }

    @Test
    public void insertIntoCassandraDatabaseAndGetFromDB(){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setAge(10);
        playerEntity.setFirstName("FIRST NAME");
        playerEntity.setLastName("LAST NAME");
        PlayerEntity returnedEntity = adminTemplate.insert(playerEntity);
        log.info("data successfully inserted {}",returnedEntity.getPlayerId());
        Assert.assertEquals("Checking age",playerEntity.getAge(),returnedEntity.getAge());
        Assert.assertEquals("Checking Last name",playerEntity.getLastName(),returnedEntity.getLastName());
        Assert.assertEquals("Checking First name",playerEntity.getFirstName(),returnedEntity.getFirstName());
        returnedEntity = adminTemplate.selectOneById(playerEntity.getPlayerId(),PlayerEntity.class);
        Assert.assertNotNull("Checking returned player entity",returnedEntity);
        Assert.assertEquals("Checking age",playerEntity.getAge(),returnedEntity.getAge());
        Assert.assertEquals("Checking Last name",playerEntity.getLastName(),returnedEntity.getLastName());
        Assert.assertEquals("Checking First name",playerEntity.getFirstName(),returnedEntity.getFirstName());
    }
}