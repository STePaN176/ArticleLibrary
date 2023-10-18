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
        initLayoyt();
        initActionListenerButton();
        setTitle("Библиотека статей");
    }

    protected void initLayoyt() {
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
                        .addComponent(btnFind)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddArticle)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddAJournal)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnAddAMethod)
                )
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty)
                        .addComponent(btnSetting)
                )
        );
    }

    protected void initActionListenerButton() {
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerform(new SearchFrame());
            }
        });

        btnAddArticle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerform(new EditFrame());
            }
        });

        btnAddAJournal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerform(new ScienceJournalFrame());
            }
        });

        btnAddAMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerform(new MethodAnalysisFrame());
            }
        });
    }

    public void actionPerform(JFrame frame) {
        frame.setVisible(true);
        frame.setBounds(getX(), getY(), getWidth(), getHeight());
        setVisible(false);
    }

}
