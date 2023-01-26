package tools;

import processing.core.PApplet;

public class Paper extends Tool {

    public Paper(PApplet sketch, float x, float y, float diameter) {
        super(sketch, x, y, diameter);
        display();
    }

    @Override
    public boolean canBeatMe(Tool tool) {
        return tool instanceof Scissors;
    }

    @Override
    public void display() {
        this.sketch.square(this.x, this.y, 25);
        // TODO: remove debug center
        this.sketch.fill(255, 0, 0);
        this.sketch.circle(x, y, 5);
    }
}
