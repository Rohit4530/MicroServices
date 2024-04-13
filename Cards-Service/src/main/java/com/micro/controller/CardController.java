package com.micro.controller;

import com.micro.constants.CardConstants;
import com.micro.dto.CardDto;
import com.micro.dto.CardsContactInfoDto;
import com.micro.dto.payload.ResponseDto;
import com.micro.mapper.CardMapper;
import com.micro.service.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardController {
    @Autowired
    private final ICardService iCardService;
    @Autowired
    private CardsContactInfoDto cardsContactInfoDto;

    @Autowired
    public CardController(ICardService iCardService) {
        this.iCardService = iCardService;
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDto>createCard(@Valid
                                                 @RequestParam
                                                 String mobileNumber){
        iCardService.createCard(mobileNumber);
       return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        CardConstants.STATUS_201,
                        CardConstants.MESSAGE_201
                ));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto>updateCardDetails(@Valid @RequestBody
                                                    CardDto cardDto){
        boolean isUpdated=iCardService.updateCardDetails(cardDto);
      if(isUpdated) {
          return ResponseEntity
                  .status(HttpStatus.CREATED)
                  .body(new ResponseDto(
                          CardConstants.STATUS_201,
                          CardConstants.MESSAGE_201
                  ));
      }else{
          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body(new ResponseDto(
                          CardConstants.STATUS_400,
                          CardConstants.MESSAGE_400
                  ));
      }
    }
    @GetMapping("/fetch")
    public ResponseEntity<CardDto>fetchCard(@Valid
                                            @RequestParam
                                            String mobileNumber){
        CardDto cardDto=iCardService.findByMobileNumber(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardDto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteCard(@Valid
                                                     @RequestParam
                                                     String mobileNumber){
        boolean isDeleted=iCardService.deleteCard(mobileNumber);
        if(isDeleted){
              return ResponseEntity
                       .status(HttpStatus.OK)
                       .body(new ResponseDto(
                               CardConstants.STATUS_200,
                               CardConstants.MESSAGE_200
                       ));
        }else{
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(
                            CardConstants.STATUS_404,
                            CardConstants.MESSAGE_404
                    ));
        }
    }
    @GetMapping("/contact-info")
    public ResponseEntity<CardsContactInfoDto>getContactDetails(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsContactInfoDto);
    }

}
