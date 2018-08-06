package de.slashgarbage.example;

public class Frame {
    private int firstBalls;
    private int secondBalls;
    private int thirdBalls;
    private FrameType frameType;

    Frame(int firstBalls,int secondBalls){
        this(firstBalls, secondBalls,0);
    }

    Frame(int firstBalls,int secondBalls,int thirdBalls){
        this.firstBalls = firstBalls;
        if(firstBalls == 10) {
            frameType = FrameType.STRIKE;
        }else if(firstBalls +secondBalls == 10) {
            frameType = FrameType.SPARE;
        }else {
            frameType = FrameType.NORMAL;
            this.secondBalls = secondBalls;
            this.thirdBalls = thirdBalls;
        }
    }

}
