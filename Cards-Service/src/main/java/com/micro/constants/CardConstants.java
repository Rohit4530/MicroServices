package com.micro.constants;

public class CardConstants {
    public static final long NEW_CARD_LIMIT = 100000;
    public static final String STATUS_400 ="404" ;
    public static final String MESSAGE_400 ="Please try again after sometime" ;
    public static final String MESSAGE_404 ="Card not found!!!" ;
    public static final String STATUS_404="404";


    private CardConstants(){
        //restrict instantiation
    }
    public static final String STATUS_201="201";
    public static final String MESSAGE_201="Card Created Successfully";
    public static final String STATUS_200="200";
    public static final String MESSAGE_200="Request Processed Successfully";
    public static final String STATUS_500="500";
    public static final String MESSAGE_500="An Error Occurred,Please Try Again";
}
