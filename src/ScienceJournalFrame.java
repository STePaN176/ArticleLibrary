import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.*;


public class ScienceJournalFrame extends JFrame {


    JLabel labelJournal = new JLabel("Название журнала");
    JLabel empty = new JLabel("                   ");
    JTextField textFieldNameJournal = new JTextField();
    JButton btnAdd = new JButton("Добавить");
    JButton btnClear = new JButton("Очистить");
    JButton btnBack = new JButton("   Назад   ");

    public ScienceJournalFrame() {
        setBounds(Main.app.getX(), Main.app.getY(), Main.app.getWidth(), Main.app.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(labelJournal))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldNameJournal))
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(btnAdd)
                        .addComponent(btnClear)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(empty)
                        .addComponent(btnBack))

        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnClear);


        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(textFieldNameJournal)
                        .addComponent(labelJournal)
                        .addComponent(btnAdd))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnClear))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(empty))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(btnBack))
        );

        btnClear.addActionListener(new ButtonClearListner());

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                EditFrame frame = new EditFrame();
//                frame.setTitle("Добавить запись");
//                setVisible(false);
//                frame.setVisible(true);
//                frame.setBounds(getX(), getY(), getWidth(), getHeight());


            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.app.setVisible(true); // включаем фрейм поиска
                Main.app.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false); // выклчюаем фрейм редактирования
            }
        });

        setTitle("Добавить научный журнал");

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
            Main.codeKeyWords.get(searchWord);
            Main.codeName.get(searchWord);
            EditFrame frame = new EditFrame();
            frame.textFieldCode.setText(textFieldNameJournal.getText());
            frame.textFieldKeyWords.setText(Main.codeKeyWords.get(searchWord));
            frame.textFieldName.setText(Main.codeName.get(searchWord));
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btnAdd.setVisible(false);
        }
    }

}
