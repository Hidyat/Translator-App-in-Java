import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;


public class MainPage extends MouseAdapter implements ActionListener {

  private final JFrame frame = new JFrame();
  private final ImageIcon frameIcon = new ImageIcon("src\\pics\\LoaderPageLogo.png");
  private final JPanel mainPanel = new JPanel();
  private final JPanel headerPanel = new JPanel();
  private final JLabel headerLabel = new JLabel();
  private final JTextArea inputTextArea = new JTextArea();
  private final JScrollPane inputTextAreaScrollPane = new JScrollPane(inputTextArea);
  private final JTextArea transTextArea = new JTextArea();
  private final JScrollPane transilitionTextAreaScrollPane = new JScrollPane(transTextArea);
  private final JPanel soundAndCopyPanel = new JPanel();
  private final JPanel comboBoxPanel = new JPanel();
  private final JPanel transilitionTextAreaPanel = new JPanel();
  private final JButton soundButton = new JButton();
  private final JButton copyButton = new JButton();
  private final JButton swapButton = new JButton();
  private final String[] allLang = getAvailableLanguages();
  private final JComboBox<String> inputTextAreaComboBox = new JComboBox<>(allLang);
  private final JComboBox<String> transilitionTextAreaComboBox = new JComboBox<>(allLang);
  private final JButton copyButtonInTraPanel = new JButton();
  private final JButton soundButtonInTraPanel = new JButton();
  private final JPanel translateButtonPanel = new JPanel();
  private final JButton translateButton = new JButton();



  public MainPage() {
    setFrame();
    setMainPanel();
    addComponentsToMainPanel();
    setHeaderPanel();

    setInputTextArea();
    setTransilitionTextArea();
    addComponentsToFrame();
    setSoundAndCopyPanel();
    addComponentsToSoundAndCopyPanel();

    setComboBoxPanel();
    setTransilitionTextAreaPanel();
    setTranslateButtonPanel();
  }



  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(soundButton))
      textToSpeechInTextInputArea();

    else if (e.getSource().equals(soundButtonInTraPanel))
      textToSpeechInTextTransArea();

    else if (e.getSource().equals(copyButton))
      copyContentFromInputTextArea(inputTextArea);

    else if (e.getSource().equals(copyButtonInTraPanel))
      copyContentFromTransTextArea();

    else if (e.getSource().equals(swapButton))
      swapLangInComboBox();

    else if (e.getSource().equals(translateButton))
      transText();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if (e.getSource().equals(translateButton)) {
      translateButton.setBackground(Color.WHITE);
      translateButton.setForeground(Color.BLACK);
      translateButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));
    }

    else if (e.getSource().equals(soundButton))
      soundButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));

    else if (e.getSource().equals(copyButton))
      copyButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));

    else if (e.getSource().equals(swapButton))
      swapButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));

    else if (e.getSource().equals(soundButtonInTraPanel))
      soundButtonInTraPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));

    else if (e.getSource().equals(copyButtonInTraPanel))
      copyButtonInTraPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (e.getSource().equals(translateButton)) {
      translateButton.setBackground(Color.BLACK);
      translateButton.setForeground(Color.WHITE);
      translateButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));
    }

    else if (e.getSource().equals(soundButton))
      soundButton.setBorder(null);

    else if (e.getSource().equals(copyButton))
      copyButton.setBorder(null);

    else if (e.getSource().equals(swapButton))
      swapButton.setBorder(null);

    else if (e.getSource().equals(soundButtonInTraPanel))
      soundButtonInTraPanel.setBorder(null);

    else if (e.getSource().equals(copyButtonInTraPanel))
      copyButtonInTraPanel.setBorder(null);
  }



  // Inner Details of the program
  private void setFrame() {
    frame.setSize(1015, 680);
    frame.setTitle("My Translator");
    frame.setIconImage(frameIcon.getImage());
    frame.setLocation(200, 100);
    frame.setLayout(null);
    frame.setResizable(false);
    frame.getContentPane().setBackground(Color.WHITE);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private void setMainPanel() {
    mainPanel.setBounds(2, 120, 1000, 480);
    mainPanel.setLayout(null);
    mainPanel.setBackground(Color.WHITE);
  }

  private void setHeaderPanel() {
    headerPanel.setBounds(260, 40, 500, 75);
    headerPanel.setBackground(Color.WHITE);
    headerPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));


    setHeaderLabel();
  }

  // Written by: Hedayatullah Yamin
  private void setHeaderLabel() {
    headerLabel.setForeground(new Color(0, 0, 0));
    headerLabel.setFont(new Font("", Font.PLAIN, 36));
    headerLabel.setText("My Translator");

    headerPanel.add(headerLabel);
  }

  private void setTranslateButtonPanel() {
    translateButtonPanel.setBounds(50, 398, 900, 60);
    translateButtonPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));
    translateButtonPanel.setBackground(Color.WHITE);
    translateButtonPanel.setLayout(null);

    setTranslateButton();
  }

  private void setTranslateButton() {
    translateButton.setFont(new Font("", Font.PLAIN, 26));
    translateButton.setText("Translate");
    translateButton.setBounds(0, 0, 900, 60);
    translateButton.setFocusable(false);
    translateButton.setBackground(Color.BLACK);
    translateButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(91, 123, 161)));
    translateButton.setForeground(Color.WHITE);
    translateButton.setBorder(null);
    translateButton.addMouseListener(this);
    translateButton.addActionListener(this);
    translateButton.addActionListener(this);

    translateButtonPanel.add(translateButton);
  }

  private void setTransilitionTextAreaPanel() {
    transilitionTextAreaPanel.setBounds(519, 338, 430, 61);
    transilitionTextAreaPanel.setBorder(new MatteBorder(1, 0, 1, 1, new Color(91, 123, 161)));
    transilitionTextAreaPanel.setBackground(Color.WHITE);
    transilitionTextAreaPanel.setLayout(null);

    setTransilitionTextAreaComboBox();
    setCopyButtonInTransilitionPanel();
    setSoundButtonInTransilitionPanel();
  }

  private void setCopyButtonInTransilitionPanel() {
    ImageIcon soundIcon = new ImageIcon("src\\pics\\copy.png");
    copyButtonInTraPanel.setBounds(300, 10, 40, 40);
    copyButtonInTraPanel.setFocusable(false);
    copyButtonInTraPanel.setIcon(soundIcon);
    copyButtonInTraPanel.setBackground(Color.WHITE);
    copyButtonInTraPanel.setBorder(null);
    copyButtonInTraPanel.addActionListener(this);
    copyButtonInTraPanel.addMouseListener(this);

    transilitionTextAreaPanel.add(copyButtonInTraPanel);
  }

  private void setSoundButtonInTransilitionPanel() {
    ImageIcon soundIcon = new ImageIcon("src\\pics\\volume.png");
    soundButtonInTraPanel.setBounds(367, 10, 40, 40);
    soundButtonInTraPanel.setFocusable(false);
    soundButtonInTraPanel.setIcon(soundIcon);
    soundButtonInTraPanel.setBackground(Color.WHITE);
    soundButtonInTraPanel.setBorder(null);
    soundButtonInTraPanel.addActionListener(this);
    soundButtonInTraPanel.addMouseListener(this);

    transilitionTextAreaPanel.add(soundButtonInTraPanel);
  }

  private void setTransilitionTextAreaComboBox() {
    transilitionTextAreaComboBox.setFocusable(false);
    transilitionTextAreaComboBox.setBounds(25, 10, 240, 40);
    transilitionTextAreaComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
    transilitionTextAreaComboBox.setBackground(Color.WHITE);

    transilitionTextAreaPanel.add(transilitionTextAreaComboBox);
  }

  private void setComboBoxPanel() {
    comboBoxPanel.setBounds(189, 338, 330, 61);
    comboBoxPanel.setBorder(new MatteBorder(1, 0, 1, 0, new Color(91, 123, 161)));
    comboBoxPanel.setBackground(Color.WHITE);
    comboBoxPanel.setLayout(null);

    setInputTextAreaComboBox();
    setSwapButton();
  }

  private void setInputTextAreaComboBox() {
    inputTextAreaComboBox.setFont(new Font("Arial", Font.PLAIN, 10));
    inputTextAreaComboBox.setFocusable(false);
    inputTextAreaComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
    inputTextAreaComboBox.setBounds(10, 10, 240, 40);
    inputTextAreaComboBox.setBackground(Color.WHITE);

    comboBoxPanel.add(inputTextAreaComboBox);
  }

  private void setSwapButton() {
    ImageIcon swapIcon = new ImageIcon("src\\pics\\swap.png");
    swapButton.setBounds(283, 10, 40, 40);
    swapButton.setFocusable(false);
    swapButton.setIcon(swapIcon);
    swapButton.setBackground(Color.WHITE);
    swapButton.setBorder(null);
    swapButton.addActionListener(this);
    swapButton.addMouseListener(this);

    comboBoxPanel.add(swapButton);
  }

  private void setSoundAndCopyPanel() {
    soundAndCopyPanel.setBounds(50, 339, 140, 60);
    soundAndCopyPanel.setBorder(new MatteBorder(1, 1, 1, 0, new Color(91, 123, 161)));
    soundAndCopyPanel.setBackground(Color.WHITE);
    soundAndCopyPanel.setLayout(null);
    soundAndCopyPanel.addMouseListener(this);

    setSoundButton();
    setCopyButton();
  }

  private void addComponentsToSoundAndCopyPanel() {
    soundAndCopyPanel.add(soundButton);
    soundAndCopyPanel.add(copyButton);
  }

  private void setSoundButton() {
    ImageIcon soundIcon = new ImageIcon("src\\pics\\volume.png");
    soundButton.setBounds(20, 10, 40, 40);
    soundButton.setFocusable(false);
    soundButton.setIcon(soundIcon);
    soundButton.setBackground(Color.WHITE);
    soundButton.setBorder(null);
    soundButton.addActionListener(this);
    soundButton.addMouseListener(this);
  }

  private void setCopyButton() {
    ImageIcon soundIcon = new ImageIcon("src\\pics\\copy.png");
    copyButton.setBounds(80, 10, 40, 40);
    copyButton.setFocusable(false);
    copyButton.setIcon(soundIcon);
    copyButton.setBackground(Color.WHITE);
    copyButton.setBorder(null);
    copyButton.addActionListener(this);
    copyButton.addMouseListener(this);
  }


  private void setInputTextArea() {
    Font font = new Font("", Font.PLAIN, 24);

    inputTextArea.setBorder(new MatteBorder(1, 1, 1, 0, new Color(91, 123, 161)));
    inputTextArea.setFont(font);
    inputTextArea.setBackground(Color.WHITE);
    inputTextArea.setMargin(new Insets(5, 10, 5, 5));
    inputTextArea.setLineWrap(true);
    inputTextArea.setWrapStyleWord(true);

    inputTextAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    inputTextAreaScrollPane.setBounds(50, 40, 450, 300);
  }

  private void setTransilitionTextArea() {
    Font font = new Font("", Font.PLAIN, 24);

    transTextArea.setBorder(new MatteBorder(1, 1, 1, 0, new Color(91, 123, 161)));
    transTextArea.setFont(font);
    transTextArea.setBackground(Color.WHITE);
    transTextArea.setMargin(new Insets(5, 10, 5, 5));
    transTextArea.setLineWrap(true);
    transTextArea.setWrapStyleWord(true);

    transilitionTextAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    transilitionTextAreaScrollPane.setBounds(500, 40, 450, 300);
  }

  private void addComponentsToFrame() {
    frame.add(mainPanel);
    frame.add(headerPanel);
  }

  private void addComponentsToMainPanel() {
    mainPanel.add(inputTextAreaScrollPane);
    mainPanel.add(transilitionTextAreaScrollPane);
    mainPanel.add(soundAndCopyPanel);
    mainPanel.add(comboBoxPanel);
    mainPanel.add(transilitionTextAreaPanel);
    mainPanel.add(translateButtonPanel);
  }

  // Buttons features
  private void textToSpeechInTextInputArea() {
    String inputText = inputTextArea.getText();
    TextToSpeech.speech(inputText);
  }

  private void textToSpeechInTextTransArea() {
    String inputText = transTextArea.getText();
    TextToSpeech.speech(inputText);
  }

  private void copyContentFromInputTextArea(JTextArea textArea) {
    String text = textArea.getText();

    StringSelection selection = new StringSelection(text);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, null);

    showTemporaryMessage();
  }

  private void copyContentFromTransTextArea() {
    String text = transTextArea.getText();

    StringSelection selection = new StringSelection(text);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, null);

    showTemporaryMessage();
  }

  private void showTemporaryMessage() {
    JOptionPane optionPane = new JOptionPane("Text Copied Successfully!", JOptionPane.INFORMATION_MESSAGE);
    JDialog dialog = optionPane.createDialog("Copied");

    Timer timer = new Timer(600, j -> dialog.dispose());
    timer.setRepeats(false);
    timer.start();

    dialog.setVisible(true);
  }

  public void swapLangInComboBox() {
    String temp = (String) inputTextAreaComboBox.getSelectedItem();

    inputTextAreaComboBox.setSelectedItem(transilitionTextAreaComboBox.getSelectedItem());
    transilitionTextAreaComboBox.setSelectedItem(temp);
  }

  private void transText() {
    TranslateText tts = new TranslateText();
    HashMap<String, String> map = langMaps();

    String sourceLang = (String) inputTextAreaComboBox.getSelectedItem();
    String targetLang = (String) transilitionTextAreaComboBox.getSelectedItem();

    String sLMap = map.get(sourceLang);
    String tLMap = map.get(targetLang);

    try {
      String inputText = inputTextArea.getText();
      String translatedText = tts.translateText(sLMap, tLMap, inputText);

      transTextArea.setText(translatedText);
    }

    catch (IOException e) {
      System.out.println();
    }

  }


  private String[] getAvailableLanguages() {
      return new String[] {
              "Afrikaans", "Albanian", "Amharic", "Arabic", "Armenian", "Azerbaijani",
              "Basque", "Belarusian", "Bengali", "Bosnian", "Bulgarian", "Catalan",
              "Cebuano", "Chichewa", "Chinese (Simplified)", "Chinese (Traditional)", "Corsican", "Croatian",
              "Czech", "Danish", "Dutch", "English", "Esperanto", "Estonian",
              "Filipino", "Finnish", "French", "Frisian", "Galician", "Georgian",
              "German", "Greek", "Gujarati", "Haitian Creole", "Hausa", "Hawaiian",
              "Hebrew", "Hindi", "Hmong", "Hungarian", "Icelandic", "Igbo",
              "Indonesian", "Irish", "Italian", "Japanese", "Javanese", "Kannada",
              "Kazakh", "Khmer", "Kinyarwanda", "Korean", "Kurdish (Kurmanji)", "Kyrgyz",
              "Lao", "Latin", "Latvian", "Lithuanian", "Luxembourgish", "Macedonian",
              "Malagasy", "Malay", "Malayalam", "Maltese", "Maori", "Marathi",
              "Mongolian", "Myanmar (Burmese)", "Nepali", "Norwegian", "Odia", "Pashto",
              "Persian", "Polish", "Portuguese", "Punjabi", "Romanian", "Russian",
              "Samoan", "Scots Gaelic", "Serbian", "Sesotho", "Shona", "Sindhi",
              "Sinhala", "Slovak", "Slovenian", "Somali", "Spanish", "Sundanese",
              "Swahili", "Swedish", "Tajik", "Tamil", "Tatar", "Telugu",
              "Thai", "Turkish", "Turkmen", "Ukrainian", "Urdu", "Uyghur",
              "Uzbek", "Vietnamese", "Welsh", "Xhosa", "Yiddish", "Yoruba", "Zulu"
      };
    }

  private HashMap<String, String> langMaps() {
    HashMap<String, String> languageMap = new HashMap<>();

    languageMap.put("Afrikaans", "af");
    languageMap.put("Albanian", "sq");
    languageMap.put("Amharic", "am");
    languageMap.put("Arabic", "ar");
    languageMap.put("Armenian", "hy");
    languageMap.put("Azerbaijani", "az");
    languageMap.put("Basque", "eu");
    languageMap.put("Belarusian", "be");
    languageMap.put("Bengali", "bn");
    languageMap.put("Bosnian", "bs");
    languageMap.put("Bulgarian", "bg");
    languageMap.put("Catalan", "ca");
    languageMap.put("Cebuano", "ceb");
    languageMap.put("Chinese (Simplified)", "zh-CN");
    languageMap.put("Chinese (Traditional)", "zh-TW");
    languageMap.put("Corsican", "co");
    languageMap.put("Croatian", "hr");
    languageMap.put("Czech", "cs");
    languageMap.put("Danish", "da");
    languageMap.put("Dutch", "nl");
    languageMap.put("English", "en");
    languageMap.put("Esperanto", "eo");
    languageMap.put("Estonian", "et");
    languageMap.put("Finnish", "fi");
    languageMap.put("French", "fr");
    languageMap.put("Frisian", "fy");
    languageMap.put("Galician", "gl");
    languageMap.put("Georgian", "ka");
    languageMap.put("German", "de");
    languageMap.put("Greek", "el");
    languageMap.put("Gujarati", "gu");
    languageMap.put("Haitian Creole", "ht");
    languageMap.put("Hausa", "ha");
    languageMap.put("Hawaiian", "haw");
    languageMap.put("Hebrew", "he");
    languageMap.put("Hindi", "hi");
    languageMap.put("Hmong", "hmn");
    languageMap.put("Hungarian", "hu");
    languageMap.put("Icelandic", "is");
    languageMap.put("Igbo", "ig");
    languageMap.put("Indonesian", "id");
    languageMap.put("Irish", "ga");
    languageMap.put("Italian", "it");
    languageMap.put("Japanese", "ja");
    languageMap.put("Javanese", "jv");
    languageMap.put("Kannada", "kn");
    languageMap.put("Kazakh", "kk");
    languageMap.put("Khmer", "km");
    languageMap.put("Kinyarwanda", "rw");
    languageMap.put("Korean", "ko");
    languageMap.put("Kurdish", "ku");
    languageMap.put("Kyrgyz", "ky");
    languageMap.put("Lao", "lo");
    languageMap.put("Latin", "la");
    languageMap.put("Latvian", "lv");
    languageMap.put("Lithuanian", "lt");
    languageMap.put("Luxembourgish", "lb");
    languageMap.put("Macedonian", "mk");
    languageMap.put("Malagasy", "mg");
    languageMap.put("Malay", "ms");
    languageMap.put("Malayalam", "ml");
    languageMap.put("Maltese", "mt");
    languageMap.put("Maori", "mi");
    languageMap.put("Marathi", "mr");
    languageMap.put("Mongolian", "mn");
    languageMap.put("Myanmar (Burmese)", "my");
    languageMap.put("Nepali", "ne");
    languageMap.put("Norwegian", "no");
    languageMap.put("Nyanja (Chichewa)", "ny");
    languageMap.put("Odia (Oriya)", "or");
    languageMap.put("Pashto", "ps");
    languageMap.put("Persian", "fa");
    languageMap.put("Polish", "pl");
    languageMap.put("Portuguese", "pt");
    languageMap.put("Punjabi", "pa");
    languageMap.put("Romanian", "ro");
    languageMap.put("Russian", "ru");
    languageMap.put("Samoan", "sm");
    languageMap.put("Scots Gaelic", "gd");
    languageMap.put("Serbian", "sr");
    languageMap.put("Sesotho", "st");
    languageMap.put("Shona", "sn");
    languageMap.put("Sindhi", "sd");
    languageMap.put("Sinhala (Sinhalese)", "si");
    languageMap.put("Slovak", "sk");
    languageMap.put("Slovenian", "sl");
    languageMap.put("Somali", "so");
    languageMap.put("Spanish", "es");
    languageMap.put("Sundanese", "su");
    languageMap.put("Swahili", "sw");
    languageMap.put("Swedish", "sv");
    languageMap.put("Tagalog (Filipino)", "tl");
    languageMap.put("Tajik", "tg");
    languageMap.put("Tamil", "ta");
    languageMap.put("Tatar", "tt");
    languageMap.put("Telugu", "te");
    languageMap.put("Thai", "th");
    languageMap.put("Turkish", "tr");
    languageMap.put("Turkmen", "tk");
    languageMap.put("Ukrainian", "uk");
    languageMap.put("Urdu", "ur");
    languageMap.put("Uyghur", "ug");
    languageMap.put("Uzbek", "uz");
    languageMap.put("Vietnamese", "vi");
    languageMap.put("Welsh", "cy");
    languageMap.put("Xhosa", "xh");
    languageMap.put("Yiddish", "yi");
    languageMap.put("Yoruba", "yo");
    languageMap.put("Zulu", "zu");

    return languageMap;
  }
}
