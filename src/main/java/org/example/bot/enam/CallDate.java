package org.example.bot.enam;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CallDate {

    CALLBACK_TEXT("text"),
    CALLBACK_EDIT("edit"),



    CALLBACK_SIZE("size"),

    CALLBACK_SMALL("small"),
    CALLBACK_MEDIUM("medium"),
    CALLBACK_BIG("big"),



    CALLBACK_COLOR("color"),

    CALLBACK_WHITE("white"),
    CALLBACK_BACK("black"),
    CALLBACK_BLUE("blue"),



    CALLBACK_SPEED("speed"),

    SPEED_SLOW("slow"),
    SPEED_MIDDLE("meddle"),
    SPEED_FAST("fast");



//    CALLBACK_STYLE("speed"),
//
//    SPEED_BOLD("slow"),
//    SPEED_ITALIC("italic"),
//    SPEED_FAST("fast");







    private static final Map<String,CallDate> map = new HashMap<>();
    static {
        for (CallDate s: CallDate.values()) {
            map.put(s.value,s);
        }
    }

    private final String value;

    CallDate(String value){
        this.value = value;
    }
    public static CallDate of(String s){
        return map.get(s);
    }

}
