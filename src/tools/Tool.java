package tools;

import processing.core.PApplet;

public abstract class Tool implements Beatable {
    public final float TOOL_MOVE_OFFSET = 0.1F;
    public final float BOUNCE_SPEED = 3;
    public final int TOOL_SIZE = 30;
    public PApplet sketch;
    public float x;
    public float y;
    public float xSpeed = TOOL_MOVE_OFFSET;
    public float ySpeed = TOOL_MOVE_OFFSET;
    public float diameter;

    public Tool(PApplet sketch, float x, float y, float diameter) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public void move() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        this.xSpeed += sketch.random(-TOOL_MOVE_OFFSET, TOOL_MOVE_OFFSET);
        this.ySpeed += sketch.random(-TOOL_MOVE_OFFSET, TOOL_MOVE_OFFSET);
        wallBounce();
    }

    public void wallBounce() {
        // Check for collision with window borders -> modify speed
        float offset = 0;
        float triangle = 0;

        if (this instanceof Scissors) {
            triangle = TOOL_SIZE;
        } else {
            offset = TOOL_SIZE / 2;
        }

        // RIGHT
        if (this.x >= sketch.width - offset - triangle) {
            this.xSpeed -= BOUNCE_SPEED;
        }

        // LEFT
        if (this.x <= offset) {
            this.xSpeed += BOUNCE_SPEED;
        }

        // BOTTOM
        if (this.y >= sketch.height - offset) {
            this.ySpeed -= BOUNCE_SPEED;
        }

        // TOP
        if (this.y <= offset + triangle) {
            this.ySpeed += BOUNCE_SPEED;
        }
    }

    public boolean collidesWith(Tool tool) {
        // Return whether collision with tool happened
        float offsetOne = this instanceof Scissors ? TOOL_SIZE / 2 : 0;
        float offsetTwo = tool instanceof Scissors ? TOOL_SIZE / 2 : 0;

        return this.x + offsetOne - tool.x + offsetTwo <= TOOL_SIZE / 2 && this.y + offsetOne - tool.y + offsetTwo <= TOOL_SIZE / 2;
    }
}
