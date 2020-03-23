package com.mphase.stock;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mphase.stock.service.StockService;
import com.mphase.stock.service.impl.StockServiceImpl;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@ComponentScan(basePackages = "com.mphase.stock")
@Configuration
@EnableMongoRepositories(basePackages="com.mphase.stock.repository")
public class StockConfig {

    @Autowired private MongoDbFactory mongoDbFactory;

    @Autowired private MongoMappingContext mongoMappingContext;

    @Bean
    public MappingMongoConverter mappingMongoConverter() {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return converter;
    }

    @Bean
    public StockService stockService() {
        return new StockServiceImpl();
    }

//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//        return new SimpleMongoDbFactory(new MongoClient(), "mphase");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//
//        //remove _class
//        MappingMongoConverter converter =
//                new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
//
//        return mongoTemplate;
//
//    }


}
