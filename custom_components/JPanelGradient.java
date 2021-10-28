package custom_components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JPanelGradient extends JPanel {

    private Color primaryColor = new Color(54, 215, 99);
    private Color secondaryColor = new Color(57, 215, 102);
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        
        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(0, 0, primaryColor, 180, height, secondaryColor);
        graphics2D.setPaint(gradient);
        graphics2D.fillRect(0, 0, width, height);
    }
}
