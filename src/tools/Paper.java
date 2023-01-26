package tools;

import processing.core.PApplet;

public class Paper extends Tool {

    public Paper(PApplet sketch, float x, float y, float diameter) {
        super(sketch, x, y, diameter);
        display();
    }

    @Override
    public boolean canBeatMe(Tool tool) {
        // TODO: return whether tool is stronger
        return true;
    }

    @Override
    public void display() {
        this.sketch.square(this.x, this.y, 25);
    }
}
