package com.micro.mapper;

import com.micro.dto.CardDto;
import com.micro.entity.Card;

public class CardMapper {
    public static Card mapToCard(CardDto cardDto,Card card){
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setTotalLimit(cardDto.getTotalLimit());
        return card;
    }
    public static CardDto mapToCardDto(Card card,CardDto cardDto){
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setTotalLimit(card.getTotalLimit());
        return cardDto;
    }

}
