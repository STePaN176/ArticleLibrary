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

public class SimpleGUI extends JFrame {
    JLabel labelArticleSearch = new JLabel("Поиск статьи :");
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
    JButton btnDelete = new JButton("Удалить");

    public SimpleGUI() {
        super("Библиотека");
        setBounds(300, 300, 700, 455);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};

        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);

        Container container = getContentPane();
        container.setLayout(new GridLayout());

        String[] items = {
                "1Элемент списка 1",
                "2Элемент списка 2",
                "3Эемент списка 1",
                "4Элемент списка 2",
                "13Элемент списка 3"
        };
        JComboBox comboBox = new JComboBox(items);
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
                        .addComponent(btnDelete))
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
                        .addComponent(btnDelete))
        );

        btnCancel.addActionListener(new ButtonClearListner());
        btnFind.addActionListener(new ButtonSearchListner());
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddEditFrame frame = new AddEditFrame();
                frame.setTitle("Добавить запись");
            }
        });

        setTitle("Библиотека");
//        setIconImage();
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
            AddEditFrame frame = new AddEditFrame();
            frame.textFieldCode.setText(textFieldCode.getText());
            frame.textFieldKeyWords.setText(Main.codeKeyWords.get(searchWord));
            frame.textFieldName.setText(Main.codeName.get(searchWord));
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btn_Add.setVisible(false);
        }
    }

}
