package com.micro.service;

import com.micro.dto.CardDto;
import org.springframework.stereotype.Service;

@Service
public interface ICardService {
    void createCard(String mobileNumber);

    boolean updateCardDetails(CardDto cardDto);

    CardDto findByMobileNumber(String mobileNumber);

    boolean deleteCard(String mobileNumber);
}
