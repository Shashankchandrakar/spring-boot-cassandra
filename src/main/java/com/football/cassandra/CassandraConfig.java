package com.football.cassandra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;

@Slf4j
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String CASSANDRA_KEYSPACE_NAME = "cassandra.keyspace.name";
    private static final String CASSANDRA_PORT = "cassandra.port";
    private static final String CONTACT_POINTS_PROPERTY = "cassandra.contact.points";
    private static final String DEFAULT_KEY_SPACE = "default_keys";
    private static final String ENTITY_BASE_PACKAGES = "com.football";


    private final Environment environment;

    @Autowired
    public CassandraConfig(Environment environment) {
        this.environment = environment;
    }


    @NonNull
    @Override
    protected String getKeyspaceName() {
        if(!environment.containsProperty(CASSANDRA_KEYSPACE_NAME)){
            log.info("Getting default keyspace for com.football.cassandra :: {}",DEFAULT_KEY_SPACE);
            return DEFAULT_KEY_SPACE;
        }
        String keySpace = environment.getRequiredProperty(CASSANDRA_KEYSPACE_NAME);
        log.info("Cassandra keyspace name :: {}",keySpace);
        return keySpace;
    }

    @NonNull
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @NonNull
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()).ifNotExists(true));
    }

    @NonNull
    @Override
    protected String getContactPoints() {
        if(environment.containsProperty(CONTACT_POINTS_PROPERTY)){
            return environment.getRequiredProperty(CONTACT_POINTS_PROPERTY);
        }
        return super.getContactPoints();
    }

    @Override
    protected int getPort() {
        if(environment.containsProperty(CASSANDRA_PORT)){
            return environment.getRequiredProperty(CASSANDRA_PORT,Integer.class);
        }
        return super.getPort();
    }

    @NonNull
    @Override
    public String[] getEntityBasePackages() {
        return new String[]{ENTITY_BASE_PACKAGES};
    }

}
