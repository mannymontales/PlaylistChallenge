package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {

        int trueIndex = startIndex;

        int forwardSkips = movingForward(startIndex, selection);
        int backwardSkips = movingBackward(trueIndex, selection);

        if (forwardSkips < backwardSkips ){
            return forwardSkips;
        }
        return backwardSkips;
    }

    public Integer movingForward(int startIndex , String selection){
        int movingForward = 0;

        for (int i = startIndex; i < playList.length; i = startIndex++) {
            if (playList[i + 1].equals(selection)) {
                break;
            }
            movingForward++;
        }
        return movingForward;
    }

    public Integer movingBackward(int startIndex, String selection) {

        int movingBackwardCount = 0;


        for (int i = startIndex;  i > 0 || i == 0; i--){
            if (i == 0){
                i = playList.length - 1;
                movingBackwardCount += 1;
            }
            if (playList[i - 1].equals(selection)){
                break;
            }
            movingBackwardCount++;
        }

        //}
        return movingBackwardCount;
    }
}
