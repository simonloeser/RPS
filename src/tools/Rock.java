package tools;

import processing.core.PApplet;

public class Rock extends Tool {

    public Rock(PApplet sketch, float x, float y, float diameter) {
        super(sketch, x, y, diameter);
        display();
    }

    @Override
    public boolean canBeatMe(Tool tool) {
        return tool instanceof Paper;
    }

    @Override
    public void display() {
        this.sketch.circle(this.x, this.y, 25);
        // TODO: remove debug center
        this.sketch.fill(255, 0, 0);
        this.sketch.circle(x, y, 5);
    }
}
