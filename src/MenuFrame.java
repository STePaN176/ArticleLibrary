import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class MenuFrame extends JFrame {

    JButton btnFind = new JButton("Поиск");
    JButton btnAddArticle = new JButton("Добавить статью");
    JButton btnAddAJournal = new JButton("Добавить научный журнал");
    JButton btnAddAMethod = new JButton("Добавить метод анализа");


    public MenuFrame() {
        setBounds(300, 300, 1000, 455);
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
                        .addComponent(btnFind)
                        .addComponent(btnAddArticle)
                        .addComponent(btnAddAJournal)
                        .addComponent(btnAddAMethod)
                )
        );

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnFind))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnAddArticle))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnAddAJournal))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnAddAMethod)
                )
        );

        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchFrame frame = new SearchFrame();
                frame.setTitle("Поиск статьи");
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);

            }
        });

        btnAddArticle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditFrame frame = new EditFrame();
                frame.setTitle("Добавить запись");
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        btnAddAJournal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScienceJournalFrame frame = new ScienceJournalFrame();
                frame.setTitle("Добавить запись");
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        btnAddAMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MethodAnalysisFrame frame = new MethodAnalysisFrame();
                frame.setTitle("Добавить запись");
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        setTitle("Библиотека");
    }

    class ButtonSearchListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EditFrame frame = new EditFrame();
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btnAdd.setVisible(false);
        }
    }

}
