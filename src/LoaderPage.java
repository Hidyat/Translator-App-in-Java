import javax.swing.*;
import java.awt.*;

// Written by: Hedayatullah Yamin
public class LoaderPage {

  private final JFrame frame = new JFrame();
  private final JProgressBar progressBar = new JProgressBar();
  private final ImageIcon loaderLogo = new ImageIcon("src\\pics\\LoaderPageLogo.png");
  private final JLabel labelForLogo = new JLabel();
  private final ImageIcon frameIcon = new ImageIcon("src\\pics\\LoaderPageLogo.png");

  public LoaderPage() {
    setFrame();
    addComponentsToFrame();

    setLabelForLogo();
    setProgressBar();
  }


  // Private Details
  private void setFrame() {
    frame.setSize(1000, 680);
    frame.setLocation(200, 100);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setTitle("My Translator");
    frame.setLayout(null);
    frame.setResizable(false);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setIconImage(frameIcon.getImage());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private void setLabelForLogo() {
    labelForLogo.setBounds(350, 60, 300, 300);
    labelForLogo.setIcon(loaderLogo);
  }

  private void setProgressBar() {
    progressBar.setBounds(100, 490, 800, 20);
    progressBar.setMinimum(0);
    progressBar.setMaximum(100);
    progressBar.setForeground(Color.BLACK);
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    progressBar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

    fillProgressBar();
  }

  private void fillProgressBar() {
    int x = 0;
    while (x <= 100) {
      try {
        Thread.sleep(10);
        progressBar.setValue(x);
      }
      catch (Exception e) {
        System.out.println("sth");
      }

      x += 1;
    }

    // When progress bar finished, open the main page
    new MainPage();
    frame.dispose();
  }

  private void addComponentsToFrame() {
    frame.add(progressBar);
    frame.add(labelForLogo);
  }
}
