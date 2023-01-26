import processing.core.PApplet;
import tools.Paper;
import tools.Rock;
import tools.Scissors;
import tools.Tool;

public class RPS extends PApplet {

    Tool[] tools = new Tool[30];
    @Override
    public void settings() {
        size(720, 720);
    }

    @Override
    public void draw() {
        background(175);
        fill(255);

        generateTools();
        if (tools[0] == null) {
            generateTools();
        } else {
            moveTools();
        }
    }

    public void moveTools() {
        for (Tool tool : tools) {
            tool.move();
        }
    }

    public void generateTools() {
        for (int i = 0; i < tools.length; i++) {
            switch (i % 3) {
                case 0 -> tools[i] = new Rock(this, random(25, 695), random(25, 695), 25);
                case 1 -> tools[i] = new Paper(this, random(25, 695), random(25, 695), 25);
                case 2 -> tools[i] = new Scissors(this, random(25, 695), random(25, 695), 25);
            }
        }
    }
}
