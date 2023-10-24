package frame;

import db.DbHandler;
import entity.ScienceJournal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static frame.MenuFrame.appFrame;
import static javax.swing.GroupLayout.Alignment.*;


public class ScienceJournalFrame extends JFrame {

    ScienceJournal Journal = new ScienceJournal();
    JLabel labelJournal = new JLabel("Название журнала");
    JLabel empty = new JLabel("                   ");
    JTextField textFieldNameJournal = new JTextField();
    JButton btnAdd = new JButton("Добавить");
    JButton btnClear = new JButton("Очистить");
    JButton btnBack = new JButton("   Назад   ");

    public ScienceJournalFrame() {
        setBounds(appFrame.getX(), appFrame.getY(), appFrame.getWidth(), appFrame.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initLayout();
        initActionListenerButton();
        setTitle("Добавить научный журнал");
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
                        .addComponent(labelJournal)
                )
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldNameJournal)
                )
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(btnAdd)
                        .addComponent(btnClear)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(btnBack)
                )
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnClear);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(textFieldNameJournal)
                        .addComponent(labelJournal)
                        .addComponent(btnAdd)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnClear)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnBack)
                )
        );
    }

    protected void initActionListenerButton() {
        btnClear.addActionListener(new ButtonClearListner());
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DbHandler add = new DbHandler();
                    add.addScienceJournal(textFieldNameJournal.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                textFieldNameJournal.setText("");
            }
        });
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
            textFieldNameJournal.setText("");
        }
    }

    class ButtonSearchListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchWord = textFieldNameJournal.getText();
            EditFrame frame = new EditFrame();
            frame.textFieldCode.setText(textFieldNameJournal.getText());
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btnAdd.setVisible(false);
        }
    }

}