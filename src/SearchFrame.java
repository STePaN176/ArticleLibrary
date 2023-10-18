import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class SearchFrame extends JFrame {
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
    JButton btnFind = new JButton("Поиск");
    JButton btnCancel = new JButton("Очистить");
    JButton btnAdd = new JButton("Добавить");
    JButton btnBack = new JButton("Назад");

    public SearchFrame() {
        super("Поиск статьи");
        setBounds(Main.app.getX(), Main.app.getY(), Main.app.getWidth(), Main.app.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout());

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(labelCode)
                        .addComponent(labelName)
                        .addComponent(labelKeyWords)
                        .addComponent(labelJournal)
                        .addComponent(labelResearchMethod))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldCode)
                        .addComponent(textFieldName)
                        .addComponent(textFieldKeyWords)
                        .addComponent(comboBoxJournal)
                        .addComponent(comboBoxResearchMethod))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(btnFind)
                        .addComponent(btnCancel)
                        .addComponent(btnAdd)
                        .addComponent(btnBack))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnFind, btnCancel);


        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelCode)
                                .addComponent(textFieldCode)
                                .addComponent(btnFind))
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelName)
                                .addComponent(textFieldName)
                                .addComponent(btnCancel))
//                        .addContainerGap(30,30)
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelKeyWords)
                                .addComponent(textFieldKeyWords))
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelJournal)
                                .addComponent(comboBoxJournal)
                                .addComponent(btnAdd))
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelResearchMethod)
                                .addComponent(comboBoxResearchMethod)
                                .addComponent(btnBack))
        );

        btnCancel.addActionListener(new ButtonClearListner());
        btnFind.addActionListener(new ButtonSearchListner());

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditFrame frame = new EditFrame();
                frame.setTitle("Добавить запись");
                setVisible(false);
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());


            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // выклчюаем фрейм редактирования
                Main.app.setVisible(true); // включаем фрейм поиска
                Main.app.setBounds(getX(), getY(), getWidth(), getHeight());
            }
        });

        setTitle("Поиск статьи");
        pack();
    }

    class ButtonClearListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldCode.setText("");
        }
    }

    class ButtonSearchListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchWord = textFieldCode.getText();
            Main.codeKeyWords.get(searchWord);
            Main.codeName.get(searchWord);
            EditFrame frame = new EditFrame();
            frame.textFieldCode.setText(textFieldCode.getText());
            frame.textFieldKeyWords.setText(Main.codeKeyWords.get(searchWord));
            frame.textFieldName.setText(Main.codeName.get(searchWord));
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btnAdd.setVisible(false);
        }
    }

}
