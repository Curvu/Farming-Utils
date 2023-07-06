import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Locale;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

import static com.curvu.farmingutils.FarmingUtils.NAME;
import static com.curvu.farmingutils.FarmingUtils.VERSION;
import static com.curvu.farmingutils.FarmingUtils.MODID;

public class FarmingUtilsInstallerFrame extends JFrame {
  private static final Pattern IN_MODS_SUBFOLDER = Pattern.compile("1\\.8\\.9[/\\\\]?$"); // 1.8.9/

  private JPanel panelCenter = null;
  private JPanel panelBottom = null;
  private JPanel totalContentPane = null;

  private static final int TOTAL_HEIGHT = 435;
  private static final int TOTAL_WIDTH = 404;

  private int x = 0;
  private int y = 0;

  private int w = TOTAL_WIDTH;
  private int h;
  private int margin;

  public FarmingUtilsInstallerFrame() {
    try {
      setName("FarmingUtilsInstallerFrame");
      setTitle("FarmingUtils Installer");
      setResizable(false);
      setSize(TOTAL_WIDTH, TOTAL_HEIGHT);

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private JPanel getTotalContentPane() {
    if (totalContentPane == null) {
      totalContentPane = new JPanel();
      totalContentPane.setLayout(null);
      totalContentPane.setBackground(Color.WHITE);
      totalContentPane.setBounds(0, 0, TOTAL_WIDTH, TOTAL_HEIGHT);
      totalContentPane.add(getPanelCenter(), "Center");
      totalContentPane.add(getPanelBottom(), "South");

      JButton btnInstall = new JButton("Install");
      btnInstall.setBounds(10, 11, 89, 23);
    }
    return totalContentPane;
  }

  private JPanel getPanelCenter() {
    if (panelCenter == null) {
      panelCenter = new JPanel();
      panelCenter.setLayout(null);
      panelCenter.setBackground(Color.WHITE);
      panelCenter.setBounds(0, 0, TOTAL_WIDTH, TOTAL_HEIGHT);
    }
    return panelCenter;
  }

private JPanel getPanelBottom() {
    if (panelBottom == null) {
      panelBottom = new JPanel();
      panelBottom.setLayout(null);
      panelBottom.setBackground(Color.WHITE);
      panelBottom.setBounds(0, 0, TOTAL_WIDTH, TOTAL_HEIGHT);
    }
    return panelBottom;
  }

}
