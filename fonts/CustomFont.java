package fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class CustomFont {
    private Font font = null;
    public String encodeSans = "src/fonts/EncodeSans-Bold.ttf";
    
    public Font loadFont(final String path, int style, float size) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        Font fontBase = font.deriveFont(style, size);
        
        return fontBase;
    }
}
