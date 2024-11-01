import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Real extends JFrame {
    private JLabel title;
    private JLabel age;
    private JLabel year;
    private JLabel month;
    private JLabel date;

    Real(int years, int months, int days) {
        setSize(400, 300);
        setTitle("Age Calculator Result");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#d1e8e4"));

        title = new JLabel("Calculated Age");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.decode("#3e4a61"));
        add(title, BorderLayout.NORTH);

        JPanel ymdPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        ymdPanel.setBackground(Color.decode("#ffffff"));
        ymdPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        age = new JLabel("Age (Years, Months, Days)");
        age.setFont(new Font("SansSerif", Font.PLAIN, 16));
        age.setForeground(Color.decode("#3e4a61"));
        ymdPanel.add(age);

        year = new JLabel("Years: " + years);
        year.setFont(new Font("SansSerif", Font.PLAIN, 16));
        ymdPanel.add(year);

        month = new JLabel("Months: " + months);
        month.setFont(new Font("SansSerif", Font.PLAIN, 16));
        ymdPanel.add(month);

        date = new JLabel("Days: " + days);
        date.setFont(new Font("SansSerif", Font.PLAIN, 16));
        ymdPanel.add(date);

        add(ymdPanel, BorderLayout.CENTER);
    }
}

class Age extends JFrame {
    private JTextField titlee;
    private JTextField monthh;
    private JTextField datee;
    private JButton calculate;

    Age() {
        setSize(400, 400);
        setTitle("Age Calculator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#c2f2e8"));

        JLabel title = new JLabel("Age Calculator");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.decode("#2c3e50"));
        add(title, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(Color.decode("#ffffff"));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        yearLabel.setForeground(Color.decode("#34495e"));
        inputPanel.add(yearLabel);

        titlee = new JTextField();
        styleTextField(titlee);
        inputPanel.add(titlee);

        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        monthLabel.setForeground(Color.decode("#34495e"));
        inputPanel.add(monthLabel);

        monthh = new JTextField();
        styleTextField(monthh);
        inputPanel.add(monthh);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        dateLabel.setForeground(Color.decode("#34495e"));
        inputPanel.add(dateLabel);

        datee = new JTextField();
        styleTextField(datee);
        inputPanel.add(datee);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#c2f2e8"));

        calculate = new JButton("Calculate");
        styleButton(calculate);
        buttonPanel.add(calculate);
        add(buttonPanel, BorderLayout.SOUTH);

        calculate.addActionListener(evt -> calculateAge());
    }

    private void calculateAge() {
        int yearText, monthText, dateText;
        try {
            yearText = Integer.parseInt(titlee.getText());
            monthText = Integer.parseInt(monthh.getText());
            dateText = Integer.parseInt(datee.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
            return;
        }

        if (yearText >= 2025) {
            JOptionPane.showMessageDialog(null, "Year must be less than 2025.");
            return;
        }
        if (monthText < 1 || monthText > 12) {
            JOptionPane.showMessageDialog(null, "Month must be between 1 and 12.");
            return;
        }
        if (dateText < 1 || dateText > 31) {
            JOptionPane.showMessageDialog(null, "Date must be between 1 and 31.");
            return;
        }

        int fixedYear = 2025, fixedMonth = 1, fixedDay = 1;
        int years = fixedYear - yearText;
        int months = fixedMonth - monthText;
        int days = fixedDay - dateText;

        if (days < 0) {
            days += 30;
            months--;
        }
        if (months < 0) {
            months += 12;
            years--;
        }

        Real resultFrame = new Real(years, months, days);
        resultFrame.setVisible(true);
    }

    private void styleTextField(JTextField field) {
        field.setFont(new Font("SansSerif", Font.PLAIN, 16));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#3e4a61"), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(Color.decode("#76d7c4"));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#3e4a61"), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
    }
}

class agecal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Age ageCalculator = new Age();
            ageCalculator.setVisible(true);
        });
    }
}
