package com.mach.tradingreport.model.repository.collection;

import com.mach.tradingreport.api.dto.BinnacleConfigurationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BinnacleConfigurationCollection implements BinnacleConfiguration {

    private static final String COLLECTION = "binnacle_configuration";

    private MongoTemplate mongoTemplate;

    @Autowired
    public BinnacleConfigurationCollection(@Qualifier("mongoDB") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<BinnacleConfigurationDto> find(String typeParam){
        Query query = new Query();
        query.addCriteria(Criteria.where("typeParam").is(typeParam));
        return mongoTemplate.find(query,BinnacleConfigurationDto.class,COLLECTION);
    }

    @Override
    public void insert(BinnacleConfigurationDto binnacle){
        mongoTemplate.insert(binnacle,COLLECTION);
    }
}
