package custom_components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class JRoundButton extends JButton {

    private Color color;
    private Color borderColor;
    private int radius = 16;

    public JRoundButton() {
        this.color = new Color(50, 205, 76);
        this.borderColor = new Color(50, 205, 76);
    }

    public void setColor(Color color) {
        this.color = color;
        Graphics g = getGraphics();
        paintComponent(g);
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        Graphics g = getGraphics();
        paintComponent(g);
    }

    public void setRadius(int radius) {
        this.radius = radius;
        Graphics g = getGraphics();
        paintComponent(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D graphics2D = (Graphics2D) g.create();

        setContentAreaFilled(false);
        setFocusPainted(false);

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setPaint(this.color);
        graphics2D.setColor(borderColor);
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        graphics2D.setColor(this.color);
        
        graphics2D.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        graphics2D.dispose();
        super.paintComponent(g);
    }
}
