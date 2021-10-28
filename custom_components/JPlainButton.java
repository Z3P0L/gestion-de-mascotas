package custom_components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

public class JPlainButton extends JButton {
    private Color color;
    
    public JPlainButton() {
        this.color = new Color(50, 205, 76);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    public void changeColor(Color color) {
        this.color = color;
        Graphics g = getGraphics();
        paintComponent(g);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setPaint(this.color);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.dispose();
        super.paintComponent(g);
    }
}
