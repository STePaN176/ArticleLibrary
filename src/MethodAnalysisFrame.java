import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.*;


public class MethodAnalysisFrame extends JFrame {


    JLabel labelMethod = new JLabel("Название метода анализа");
    JTextField textFieldMethod = new JTextField();
    JLabel empty = new JLabel("                   ");
    JButton btnAdd = new JButton("Добавить");
    JButton btnClear = new JButton("Очистить");
    JButton btnBack = new JButton("   Назад   ");

    public MethodAnalysisFrame() {
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
                        .addComponent(labelMethod))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldMethod))
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
                        .addComponent(labelMethod)
                        .addComponent(textFieldMethod)
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

        setTitle("Добавить метод анализа");

    }

    class ButtonClearListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldMethod.setText("");
        }
    }

    class ButtonSearchListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchWord = textFieldMethod.getText();
            Main.codeKeyWords.get(searchWord);
            Main.codeName.get(searchWord);
            EditFrame frame = new EditFrame();
            frame.textFieldCode.setText(textFieldMethod.getText());
            frame.textFieldKeyWords.setText(Main.codeKeyWords.get(searchWord));
            frame.textFieldName.setText(Main.codeName.get(searchWord));
            frame.textFieldCode.setEnabled(false);
            frame.textFieldKeyWords.setEnabled(false);
            frame.textFieldName.setEnabled(false);
            frame.btnAdd.setVisible(false);
        }
    }

}
