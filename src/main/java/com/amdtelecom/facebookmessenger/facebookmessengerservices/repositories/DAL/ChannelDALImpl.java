package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.DAL;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL.ChannelDAL;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
//import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.CredentialsBase;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDALImpl implements ChannelDAL {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<ChannelResponse> getAllFacebookChannelsOfPrincipal(String principalId) {
        Pageable pageable = new PageRequest(2,6 );
        Query query = new Query();
        query.addCriteria(Criteria.where("principalId").is(principalId));
        List<ChannelResponse> channels = mongoTemplate.find(query,ChannelResponse.class,"channels");
        return PageableExecutionUtils.getPage(
                channels,
                pageable,
                () -> mongoTemplate.count(query, ChannelResponse.class));
    }
    @Override
    public void delete(String channelId,String principalId) {
        Pageable pageable = new PageRequest(0,2);
        Query query = new Query();
        query.addCriteria(Criteria.where("channelId").is(channelId)
                            .and("principalId").is(principalId));
        Update update = new Update().set("isDeleted",true);
        Object obj = mongoTemplate.findAndModify(query,update,MessengerServiceChannel.class);
        System.out.println(obj);
    }

    @Override
    public ChannelResponse update(String channelId, Credentials credentials) {
        Query query = new Query();
//        query.addCriteria(Criteria.where("channelId").is(cha));
        return null;
    }

}
