//package com.example.capstone3.Service;
//
//import com.example.capstone3.Model.Subscription;
//import com.example.capstone3.Repository.SubscriptionRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//
//public class SubscriptionService {
//
//    private final SubscriptionRepository subscribeRepository;
//
//    public List<Subscription> getAllSubscribe(){
//        return subscribeRepository.findAll();
//    }
//
//    public void deleteSubscribe(int id) {
//        Subscription subscription = subscribeRepository.findSubscribeById(id);
//        subscribeRepository.delete(subscription);
//    }
//
//
//
//}
