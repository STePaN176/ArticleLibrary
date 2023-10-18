import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.*;


public class MenuFrame extends JFrame {

    JButton btnFind = new JButton("            Поиск статьи              ");
    JButton btnAddArticle = new JButton("          Добавить статью         ");
    JButton btnAddAJournal = new JButton("Добавить научный журнал");
    JButton btnAddAMethod = new JButton("  Добавить метод анализа  ");
    JButton btnSetting = new JButton("                Настройки                ");
    JLabel empty = new JLabel("                                                                     ");


    public MenuFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(empty)
                )
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(btnFind)
                        .addComponent(btnAddArticle)
                        .addComponent(btnAddAJournal)
                        .addComponent(btnAddAMethod)
                        .addComponent(btnSetting)

                )
        );

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnFind))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddArticle))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddAJournal))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddAMethod))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnSetting))
        );

        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchFrame frame = new SearchFrame();
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);

            }
        });

        btnAddArticle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditFrame frame = new EditFrame();
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        btnAddAJournal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScienceJournalFrame frame = new ScienceJournalFrame();
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        btnAddAMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MethodAnalysisFrame frame = new MethodAnalysisFrame();
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false);


            }
        });

        setTitle("Библиотека статей");
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
