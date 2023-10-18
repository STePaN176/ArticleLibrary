import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class MethodAnalysisFrame extends JFrame {


    JLabel labelMethod  = new JLabel("Метод анализа");
    JTextField textFieldMethod  = new JTextField();
    JButton btnCancel = new JButton("Очистить");
    JButton btnAdd = new JButton("Добавить");
    JButton btnBack = new JButton("Назад");

    public MethodAnalysisFrame() {
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

                        .addComponent(labelMethod))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldMethod))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(btnCancel)
                        .addComponent(btnAdd)
                        .addComponent(btnBack))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnCancel);


        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(btnCancel))
//                        .addContainerGap(30,30)
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(labelMethod)
                                .addComponent(btnAdd))
                        .addGroup(layout.createParallelGroup(BASELINE)
                                .addComponent(textFieldMethod)
                                .addComponent(btnBack))
        );

        btnCancel.addActionListener(new ButtonClearListner());

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

        setTitle("Метод анализа");

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
