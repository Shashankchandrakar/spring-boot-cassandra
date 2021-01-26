package com.football.cassandra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

//todo add test here for cassandra
@RunWith(SpringRunner.class)
@Import({CassandraConfig.class})
public class SpringBootCassandraApplicationTest {

    @Test
    public void test(){
        assert true;
    }
}