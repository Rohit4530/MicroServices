package com.micro.service;

import com.micro.constants.CardConstants;
import com.micro.dto.CardDto;
import com.micro.entity.Card;
import com.micro.exception.CardAlreadyExistException;
import com.micro.exception.ResourceNotFoundException;
import com.micro.mapper.CardMapper;
import com.micro.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
public class CardService implements  ICardService{
    private final CardRepository cardRepository;
     @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card>optionalCard=cardRepository.findByMobileNumber(mobileNumber);
        if (optionalCard.isPresent()){
            throw new CardAlreadyExistException("Card already exist with mobile number: "+mobileNumber);
        }
         cardRepository.save(CreateNewCard(mobileNumber));
    }

    @Override
    public boolean updateCardDetails(CardDto cardDto) {
        Card card=cardRepository.findByMobileNumber(cardDto.getMobileNumber()).orElseThrow(
                ()->new ResourceNotFoundException("Cannot find the card to update  with mobile number: "+cardDto.getMobileNumber())
        );
        CardMapper.mapToCard(cardDto,card);
        cardRepository.save(card);
        return true;
    }

    @Override
    public CardDto findByMobileNumber(String mobileNumber) {
        Card card=cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Cannot find the user with mobile number: "+mobileNumber)
        );
        return CardMapper.mapToCardDto(card,new CardDto());
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Card card=cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Cannot find the user with mobile number: "+mobileNumber)
        );
        cardRepository.deleteById(card.getCardId());
        return true;
    }

    private Card CreateNewCard(String mobileNumber) {
         Card card = new Card();
        long randomLoanNumber=100000000000L+new Random().nextInt(900000000);
        card.setCardNumber(Long.toString(randomLoanNumber));
        card.setMobileNumber(mobileNumber);
        card.setCardType("CREDIT_CARD");
        card.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        card.setAmountUsed(0);
        card.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        return  card;
    }
}
