import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class MenuFrame extends JFrame {

    JButton btnFind = new JButton("Поиск");
    JButton btnAdd = new JButton("Добавить");


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
                )
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(btnFind)
                        .addComponent(btnAdd))
        );

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(btnFind))
//                        .addContainerGap(30,30)
                        .addGroup(layout.createParallelGroup(BASELINE))
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(btnAdd))
                        .addGroup(layout.createParallelGroup(BASELINE))
        );

        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchFrame frame = new SearchFrame();
                frame.setTitle("Поиск статьи");
                setVisible(false);
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());


            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditFrame frame = new EditFrame();
                frame.setTitle("Добавить запись");
                setVisible(false);
                frame.setVisible(true);
                frame.setBounds(getX(), getY(), getWidth(), getHeight());


            }
        });

        setTitle("Библиотека");
        pack();
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
