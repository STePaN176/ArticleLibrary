import db.DbHandler;
import entity.MethodAnalysis;
import entity.ScienceJournal;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.LEADING;


public class EditFrame extends JFrame {
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

    JButton btnAdd = new JButton("Добавить");
    JButton btnClear = new JButton("Очистить ");
    JButton btnBack = new JButton("    Назад   ");

    public EditFrame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initLayout();
        initActionListenerButton();
        initComboBox();
        setTitle("Добавление статьи");
    }

    protected void initLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

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
                        .addComponent(btnClear)
                        .addComponent(btnAdd)
                        .addComponent(btnBack)
                )
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnClear);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelCode)
                        .addComponent(textFieldCode)
                        .addComponent(btnAdd)
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
        btnAdd.addActionListener(new ButtonAddArticleListner());
        btnClear.addActionListener(new ButtonClearListner());
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.appFrame.setVisible(true); // включаем фрейм поиска
                Main.appFrame.setBounds(getX(), getY(), getWidth(), getHeight());
                setVisible(false); // выклчюаем фрейм редактирования
            }
        });
    }

    class ButtonAddArticleListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Запись добавлена");
        }
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
