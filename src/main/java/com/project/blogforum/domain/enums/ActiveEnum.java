package com.project.blogforum.domain.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ActiveEnum {

    ACTIVE(true, "true"),
    NONE(false, "none"),
    UNKNOWN(false, "unknown"),
    ;

    private Boolean active;

    private String desc;

    public static String getDesc(Integer num) {
        ActiveEnum status;
        switch (num) {
            case 1:
                status = ACTIVE;break;
            case 0:
                status = NONE;break;
            default:
                status = UNKNOWN;break;
        }
        return status.getDesc();
    }

}