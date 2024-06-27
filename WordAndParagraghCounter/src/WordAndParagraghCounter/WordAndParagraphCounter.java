package WordAndParagraghCounter;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordAndParagraphCounter extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel paragraphCountLabel;

    public WordAndParagraphCounter(){
        super("Word Counter");
        setLayout(new BorderLayout());

        textArea = new JTextArea(10, 20);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        

        JButton countButton = new JButton("Count");
        countButton.addActionListener(new CountButtonListener());
        add(countButton, BorderLayout.SOUTH);
        countButton.setBackground(new Color(102, 205, 170));
        countButton.setForeground(new Color(0, 0, 139));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(5, 1));

        wordCountLabel = new JLabel("Word Count : 0");
        labelPanel.add(wordCountLabel);
  
        paragraphCountLabel = new JLabel("Paragraph Count: 0");
        labelPanel.add(paragraphCountLabel);
        labelPanel.setFont(new Font("Serif", Font.BOLD, 15));
        labelPanel.setBackground(new Color(102, 205, 170));
        labelPanel.setForeground(new Color(255, 255, 255));

        add(labelPanel, BorderLayout.WEST);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CountButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            String[] paragraphs = text.split("\\n{2,}");
            int paragraphCount = paragraphs.length;

            String[] words = text.split("\\s+");
            int wordCount = words.length;

            wordCountLabel.setText("Word Count: " + wordCount);
            paragraphCountLabel.setText("Paragraph Count: " + paragraphCount);
        }
    }

    public static void main(String[] args) {
        new WordAndParagraphCounter();
    }
}
