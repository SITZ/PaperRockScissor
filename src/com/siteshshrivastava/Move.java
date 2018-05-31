package com.siteshshrivastava;

enum Move {
    PAPER,
    ROCK,
    SCISSOR;

    Result compareMoves(Move thatChoice) {
        int thisChoiceId = this.ordinal();
        int thatChoiceId = thatChoice.ordinal();

        if ((thisChoiceId + 1) % 3 == thatChoiceId) return Result.WIN;
        if ((thatChoiceId + 1) % 3 == thisChoiceId) return Result.LOSS;
        return Result.TIE;
    }
}
