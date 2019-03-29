package com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper.MessageRequest;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.model.MessengerServiceChannel;

public interface GraphApiService {

    void sendMessage(MessageRequest messageRequest, MessengerServiceChannel channel);
}
