import processing.core.PApplet;
import tools.Paper;
import tools.Rock;
import tools.Scissors;
import tools.Tool;

public class RPS extends PApplet {
    public final int TOOL_SIZE = 30;
    public final int AMOUNT_OF_TOOLS = 60;
    Tool[] tools = new Tool[AMOUNT_OF_TOOLS];
    @Override
    public void settings() {
        size(720, 720);
    }

    @Override
    public void draw() {
        background(175);
        fill(255);
        rectMode(CENTER);

        if (tools[0] == null) {
            generateTools();
        } else {
            moveTools();
        }
    }

    public void moveTools() {
        for (Tool tool : tools) {
            fill(255, 255, 255);
            tool.move();
            tool.display();
        }
    }

    public void generateTools() {
        // Die Laufzeit ist shit
        for (int i = 0; i < tools.length; i++) {
            float x = random(TOOL_SIZE, 720 - TOOL_SIZE);
            float y = random(TOOL_SIZE, 720 - TOOL_SIZE);

            for (Tool tool : tools) {
                if (tool == null) {
                    continue;
                }

                if ((tool.x + x) / 2 <= TOOL_SIZE) {
                    x = random(TOOL_SIZE, 720 - TOOL_SIZE);
                }

                if ((tool.y + y) / 2 <= TOOL_SIZE) {
                    y = random(TOOL_SIZE, 720 - TOOL_SIZE);
                }
            }

            /*for (int j = 0; j <= i; j++) {
                if (tools[j] != null) {
                    Tool t = tools[j];

                    while ((t.x + x) / 2 <= TOOL_SIZE * 3) {
                        x = random(TOOL_SIZE, 720 - TOOL_SIZE);
                    }

                    while ((t.y + y) / 2 <= TOOL_SIZE * 3) {
                        y = random(TOOL_SIZE, 720 - TOOL_SIZE);
                    }
                }
            }*/

            switch (i % 3) {
                case 0 -> tools[i] = new Rock(this, x, y, TOOL_SIZE);
                case 1 -> tools[i] = new Paper(this, x, y, TOOL_SIZE);
                case 2 -> tools[i] = new Scissors(this, x, y, TOOL_SIZE);
            }
        }
    }
}
