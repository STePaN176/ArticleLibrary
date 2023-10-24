package frame;

import db.DbHandler;
import entity.MethodAnalysis;
import entity.ScienceJournal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import static frame.MenuFrame.appFrame;
import static javax.swing.GroupLayout.Alignment.*;


public class SearchFrame extends JFrame {

    ScienceJournal Journal = new ScienceJournal();
    JLabel labelCode = new JLabel("Код");
    JLabel labelName = new JLabel("Наименование");
    JLabel labelKeyWords = new JLabel("Ключевые слова");
    JLabel labelJournal = new JLabel("Научный журнал");
    JLabel labelResearchMethod = new JLabel("Метод исследования");

    JTextField textFieldCode = new JTextField();
    JTextField textFieldName = new JTextField();
    JTextField textFieldKeyWords = new JTextField();

    JComboBox <String> comboBoxJournal = new JComboBox<>();
    JComboBox <String> comboBoxResearchMethod = new JComboBox<>();

    JButton btnFind = new JButton(" Поиск ");
    JButton btnClear = new JButton("Очистить");
    JButton btnBack = new JButton("  Назад   ");

    public SearchFrame() {
        setBounds(appFrame.getX(), appFrame.getY(), appFrame.getWidth(), appFrame.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initLayout();
        initActionListenerButton();
        initComboBox();
        setTitle("Поиск статьи");
    }

    protected void initLayout() {
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
                        .addComponent(labelResearchMethod)
                )
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldCode)
                        .addComponent(textFieldName)
                        .addComponent(textFieldKeyWords)
                        .addComponent(comboBoxJournal)
                        .addComponent(comboBoxResearchMethod)
                )
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(btnFind)
                        .addComponent(btnClear)
                        .addComponent(btnBack)
                )
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnFind, btnClear);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelCode)
                        .addComponent(textFieldCode)
                        .addComponent(btnFind)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelName)
                        .addComponent(textFieldName)
                        .addComponent(btnClear)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelKeyWords)
                        .addComponent(textFieldKeyWords)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelJournal)
                        .addComponent(comboBoxJournal)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelResearchMethod)
                        .addComponent(comboBoxResearchMethod)
                        .addComponent(btnBack)
                )
        );
    }

    protected void initActionListenerButton() {
        btnClear.addActionListener(new ButtonClearListner());
        btnFind.addActionListener(new ButtonSearchListner());
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appFrame.setVisible(true); // включаем фрейм поиска
                appFrame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false); // выклчюаем фрейм редактирования
            }
        });
    }


    class ButtonClearListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldCode.setText("");
            textFieldName.setText("");
            textFieldKeyWords.setText("");
            comboBoxJournal.setSelectedIndex(0);
            comboBoxResearchMethod.setSelectedIndex(0);
        }
    }

    class ButtonSearchListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    protected void initComboBox(){
        try {
            DbHandler dbHandler = DbHandler.getInstance();
            List<ScienceJournal> journals = dbHandler.getAllJournals();
            for (ScienceJournal journal : journals) {
                comboBoxJournal.addItem(journal.toString());
            }
            List<MethodAnalysis> methodAnalysis = dbHandler.getAllMethodAnalysis();
            for (MethodAnalysis methodAnalys : methodAnalysis) {
                comboBoxResearchMethod.addItem(methodAnalys.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        comboBoxJournal.setEditable(false);
        comboBoxResearchMethod.setEditable(false);
    }

}
