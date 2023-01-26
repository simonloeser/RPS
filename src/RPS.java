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
            checkCollision();
            checkWinner();
        }
    }

    private void checkCollision() {
        for (Tool tool : tools) {
            for (Tool tool2 : tools) {
                if (tool.collidesWith(tool2)) {
                    if (tool.canBeatMe(tool2)) {
                        // TODO: Override tool with tool2

                    } else {
                        // TODO: Override tool2 with tool
                    }
                }
            }
        }
    }

    public void checkWinner() {
        // Check whether only one type of Tool is in the tools-array left
        Tool tmp = tools[0];
        for (Tool tool : tools) {
            if (!tool.getClass().equals(tmp.getClass())) {
                return;
            }
            tmp = tool;
        }
        // Print winner item to screen
        textSize(50);
        text(tmp.getClass().getName().substring(6) + " wins!", width / 2 - 120, height / 2);
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
            float x = random(TOOL_SIZE, width - TOOL_SIZE);
            float y = random(TOOL_SIZE, height - TOOL_SIZE);

            // TODO: Spawning system (don't spawn objects in each other)

            switch (i % 3) {
                case 0 -> tools[i] = new Rock(this, x, y, TOOL_SIZE);
                case 1 -> tools[i] = new Paper(this, x, y, TOOL_SIZE);
                case 2 -> tools[i] = new Scissors(this, x, y, TOOL_SIZE);
            }
        }
    }
}
