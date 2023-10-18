import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class EditFrame extends JFrame {
    JLabel labelCode = new JLabel("Код");
    JLabel labelName = new JLabel("Наименование");
    JLabel labelKeyWords = new JLabel("Ключевые слова");
    JLabel labelJournal = new JLabel("Научный журнал");
    JLabel labelResearchMethod = new JLabel("Метод исследования");

    JTextField textFieldCode = new JTextField();
    JTextField textFieldName = new JTextField();
    JTextField textFieldKeyWords = new JTextField();

    JComboBox comboBoxJournal = new JComboBox();
    JComboBox comboBoxResearchMethod = new JComboBox();

    JButton btnAdd = new JButton("Добавить");
    JButton btnBack = new JButton("Назад");

    public EditFrame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        GroupLayout layoutSecond = new GroupLayout(getContentPane());
        getContentPane().setLayout(layoutSecond);
        layoutSecond.setAutoCreateGaps(true);
        layoutSecond.setAutoCreateContainerGaps(true);

        layoutSecond.setHorizontalGroup(layoutSecond.createSequentialGroup()
                .addGroup(layoutSecond.createParallelGroup(LEADING)
                        .addComponent(labelCode)
                        .addComponent(labelName)
                        .addComponent(labelKeyWords)
                        .addComponent(labelJournal)
                        .addComponent(labelResearchMethod)
                        .addComponent(btnBack))

                .addGroup(layoutSecond.createParallelGroup(LEADING)
                        .addComponent(textFieldCode)
                        .addComponent(textFieldName)
                        .addComponent(textFieldKeyWords)
                        .addComponent(comboBoxJournal)
                        .addComponent(comboBoxResearchMethod)

                        .addComponent(btnAdd))
        );

        layoutSecond.setVerticalGroup(layoutSecond.createSequentialGroup()
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(labelCode)
                        .addComponent(textFieldCode))
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(labelName)
                        .addComponent(textFieldName))
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(labelKeyWords)
                        .addComponent(textFieldKeyWords))
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(labelJournal)
                        .addComponent(comboBoxJournal))
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(labelResearchMethod)
                        .addComponent(comboBoxResearchMethod))
                .addContainerGap(12, 15)
                .addGroup(layoutSecond.createParallelGroup(BASELINE)
                        .addComponent(btnBack)
                        .addComponent(btnAdd))
        );

        btnAdd.addActionListener(new ButtonAddArticleListner());

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.app.setVisible(true); // включаем фрейм поиска
                Main.app.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false); // выклчюаем фрейм редактирования
            }
        });
    }

    class ButtonAddArticleListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Запись добавлена");
        }
    }

}
