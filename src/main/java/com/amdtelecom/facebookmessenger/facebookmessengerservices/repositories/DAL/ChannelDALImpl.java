package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories.DAL;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.DAL.ChannelDAL;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.ChannelResponse;
//import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.CredentialsBase;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Credentials;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServiceChannel;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
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

import java.util.Date;
import java.util.List;

@Repository
public class ChannelDALImpl implements ChannelDAL {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<ChannelResponse> getAllFacebookChannelsOfPrincipal(String principalId) {
//        Pageable pageable = PageRequest.of(1,1);
        Query query = new Query();
        query.addCriteria(Criteria.where("principalId").is(principalId));
        List<ChannelResponse> channels = mongoTemplate.find(query,ChannelResponse.class,"channels");
        return channels;
//        return PageableExecutionUtils.getPage(
//                channels,
//                pageable,
//                () -> mongoTemplate.count(query, ChannelResponse.class));
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

    @Override
    public boolean update(String channelId,String principalId, Credentials credentials) {
        Query query = new Query();
        Update update = new Update();
        if(credentials.getPageAccessToken() !=null) {
            update.set("credentials.pageAccessToken", credentials.getPageAccessToken());
        }
        if(credentials.getVerifyToken() !=null) {
            update.set("credentials.verifyToken", credentials.getVerifyToken());
        }
        if(credentials.getCallbackStatusUrl() !=null) {
            update.set("credentials.callbackStatusUrl", credentials.getCallbackStatusUrl());
        }
        if(credentials.getCallbackInboundUrl() !=null) {
            update.set("credentials.callbackInboundUrl", credentials.getCallbackInboundUrl());
        }
        update.set("updatedAt",new Date());
        query.addCriteria(Criteria.where("channelId").is(channelId));
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,MessengerServiceChannel.class);
        System.out.println("Update"+updateResult);
        return (updateResult.getModifiedCount() ==1 ? true : false);
    }

}
