package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.DAL;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL.ChannelDAL;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Channel;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDALImpl implements ChannelDAL {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<ChannelResponse> getAllFacebookChannelsOfPrincipal(String principalId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("principalId").is(principalId));
        List<ChannelResponse> channels = mongoTemplate.find(query,ChannelResponse.class,"channels");
        return channels;
    }
    @Override
    public void delete(String channelId,String principalId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("channelId").is(channelId)
                            .and("principalId").is(principalId));
        Update update = new Update().set("isDeleted",true);
        Object obj = mongoTemplate.findAndModify(query,update,MessengerServiceChannel.class);
        System.out.println(obj);
    }

}
