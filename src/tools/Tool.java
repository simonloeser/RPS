package tools;

import processing.core.PApplet;

public abstract class Tool implements Beatable {
    public final float TOOL_MOVE_OFFSET = 5;
    public PApplet sketch;
    public float x;
    public float y;
    public float xSpeed;
    public float ySpeed;
    public float diameter;

    public Tool(PApplet sketch, float x, float y, float diameter) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public void move() {
        this.x = this.x + sketch.random(-TOOL_MOVE_OFFSET, TOOL_MOVE_OFFSET);
        this.y = this.y + sketch.random(-TOOL_MOVE_OFFSET, TOOL_MOVE_OFFSET);
    }

    public void wallBounce() {
        // TODO: check for collision with window borders -> modify speed
    }

    public boolean collidesWith(Tool tool) {
        // TODO: return whether collision with tool happened
        return true;
    }
}
