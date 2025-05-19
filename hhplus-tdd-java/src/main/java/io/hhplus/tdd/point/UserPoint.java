package io.hhplus.tdd.point;

import lombok.Getter;

public record UserPoint(
        long id,
        @Getter
        long point,
        long updateMillis
) {

    // null 처리
    public static UserPoint empty(long id) {
        return new UserPoint(id, 0, System.currentTimeMillis());
    }
}
