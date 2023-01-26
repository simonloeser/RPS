package tools;

import processing.core.PApplet;

public class Scissors extends Tool {

    public Scissors(PApplet sketch, float x, float y, float diameter) {
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
        this.sketch.triangle(this.x, this.y, this.x + 25, this.y, (float) (this.x + 12.5), this.y - 25);
    }
}
