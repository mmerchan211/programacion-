package ecg;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Pantalla {

    public static ImageIcon loadImage(String path) {
        try {
            java.net.URL url = Pantalla.class.getResource(path);
            if (url != null) return new ImageIcon(url);
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    public static BufferedImage signalToImage(double[] signal, int width, int height) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,width-1,height-1);

        int mid = height/2;
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, mid, width, mid);

        if (signal == null || signal.length == 0) {
            g.setColor(Color.RED);
            g.drawString("No hay datos de señal", 10, 20);
            g.dispose();
            return img;
        }

        g.setColor(Color.BLUE);
        double step = (double) signal.length / width;
        int prevX = 0;
        int prevY = mid - (int) (signal[0] * (height/2 - 10));
        for (int x = 1; x < width; x++) {
            int si = Math.min(signal.length - 1, (int) (x * step));
            int y = mid - (int) (signal[si] * (height/2 - 10));
            g.drawLine(prevX, prevY, x, y);
            prevX = x; prevY = y;
        }
        g.dispose();
        return img;
    }

    public static void showImageWithInfo(ImageIcon icon, String title, String message) {
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        JLabel txt = new JLabel("<html><body style='width:300px'>" + message + "</body></html>");
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(imgLabel, BorderLayout.CENTER);
        panel.add(txt, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showSignal(double[] signal, String title, String message) {
        int w = 700, h = 260;
        BufferedImage img = signalToImage(signal, w, h);
        ImageIcon icon = new ImageIcon(img);
        showImageWithInfo(icon, title, message);
    }

    // Muestra varios registros en una lista (título + id)
    public static String chooseRecordDialog(java.util.List<ECGRecord> records) {
        if (records == null || records.isEmpty()) return null;
        String[] options = records.stream()
                .map(r -> String.format("%s — %s", r.getId(), r.getTimestamp()))
                .toArray(String[]::new);
        return (String) JOptionPane.showInputDialog(null, "Seleccione un registro:", "Registros",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
}
