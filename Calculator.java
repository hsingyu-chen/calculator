import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Calculator extends JFrame{

    private JTextField outputField;
    private ArrayList<JButton> digits;
    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton divide;
    private JButton equal;
    private String currentOp;
    private double first;
    private double second;
    private double result;

    public Calculator() {
        this.currentOp = "";
        this.first = 0.0;
        this.second = 0.0;
        this.result = 0.0;

        JPanel display = new JPanel(new FlowLayout());
        outputField = new JTextField("0", 25);
        Font bigger = outputField.getFont().deriveFont(Font.PLAIN, 20);
        outputField.setFont(bigger);
        display.add(outputField);

        JPanel button = new JPanel(new GridLayout(1, 2));
        button.setPreferredSize(new Dimension(500, 500));
        JPanel digitsButton = new JPanel(new GridLayout(4, 3));
        digits = new ArrayList<JButton>();
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));
        digits.add(new JButton(""));

        Icon oneIcon = new ImageIcon("1.png");
        Icon twoIcon = new ImageIcon("2.png");
        Icon threeIcon = new ImageIcon("3.png");
        Icon fourIcon = new ImageIcon("4.png");
        Icon fiveIcon = new ImageIcon("5.png");
        Icon sixIcon = new ImageIcon("6.png");
        Icon sevenIcon = new ImageIcon("7.png");
        Icon eightIcon = new ImageIcon("8.png");
        Icon nineIcon = new ImageIcon("9.png");
        Icon zeroIcon = new ImageIcon("0.png");
        Icon decIcon = new ImageIcon("dot.png");
        Icon clearIcon = new ImageIcon("clear.png");
        Icon trashIcon = new ImageIcon("trash.png");

        Image one = ((ImageIcon) oneIcon).getImage();
        Image oneIm = one.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(6).setIcon(new ImageIcon(oneIm));

        Image two = ((ImageIcon) twoIcon).getImage();
        Image twoIm = two.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(7).setIcon(new ImageIcon(twoIm));

        Image three = ((ImageIcon) threeIcon).getImage();
        Image threeIm = three.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(8).setIcon(new ImageIcon(threeIm));

        Image four = ((ImageIcon) fourIcon).getImage();
        Image fourIm = four.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(3).setIcon(new ImageIcon(fourIm));

        Image five = ((ImageIcon) fiveIcon).getImage();
        Image fiveIm = five.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(4).setIcon(new ImageIcon(fiveIm));

        Image six = ((ImageIcon) sixIcon).getImage();
        Image sixIm = six.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(5).setIcon(new ImageIcon(sixIm));

        Image seven = ((ImageIcon) sevenIcon).getImage();
        Image sevenIm = seven.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(0).setIcon(new ImageIcon(sevenIm));

        Image eight = ((ImageIcon) eightIcon).getImage();
        Image eightIm = eight.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(1).setIcon(new ImageIcon(eightIm));

        Image nine = ((ImageIcon) nineIcon).getImage();
        Image nineIm = nine.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(2).setIcon(new ImageIcon(nineIm));

        Image zero = ((ImageIcon) zeroIcon).getImage();
        Image zeroIm = zero.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(10).setIcon(new ImageIcon(zeroIm));

        Image dec = ((ImageIcon) decIcon).getImage();
        Image decIm = dec.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        digits.get(9).setIcon(new ImageIcon(decIm));

        Image clear = ((ImageIcon) clearIcon).getImage();
        Image clearIm = clear.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        digits.get(11).setIcon(new ImageIcon(clearIm));

        digitsButton.add(digits.get(0));
        digitsButton.add(digits.get(1));
        digitsButton.add(digits.get(2));
        digitsButton.add(digits.get(3));
        digitsButton.add(digits.get(4));
        digitsButton.add(digits.get(5));
        digitsButton.add(digits.get(6));
        digitsButton.add(digits.get(7));
        digitsButton.add(digits.get(8));
        digitsButton.add(digits.get(9));
        digitsButton.add(digits.get(10));
        digitsButton.add(digits.get(11));
        button.add(digitsButton);

        JPanel operator = new JPanel(new GridLayout(5, 1));
        plus = new JButton("");
        minus = new JButton("");
        multiply = new JButton("");
        divide = new JButton("");
        equal = new JButton("");

        Icon plusIcon = new ImageIcon("plus.png");
        Icon minusIcon = new ImageIcon("minus.png");
        Icon multIcon = new ImageIcon("multiply.png");
        Icon divIcon = new ImageIcon("divide.png");
        Icon equalIcon = new ImageIcon("equal.png");

        Image p = ((ImageIcon) plusIcon).getImage();
        Image pl = p.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        plus.setIcon(new ImageIcon(pl));

        Image m = ((ImageIcon) minusIcon).getImage();
        Image mi = m.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        minus.setIcon(new ImageIcon(mi));

        Image mu = ((ImageIcon) multIcon).getImage();
        Image mul = mu.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        multiply.setIcon(new ImageIcon(mul));

        Image d = ((ImageIcon) divIcon).getImage();
        Image di = d.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        divide.setIcon(new ImageIcon(di));

        Image eq = ((ImageIcon) equalIcon).getImage();
        Image equ = eq.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        equal.setIcon(new ImageIcon(equ));

        JMenuBar menuBar = new JMenuBar();
        JMenu opMenu = new JMenu("Operation Menu");
        Font bigMenu = opMenu.getFont().deriveFont(Font.BOLD, 20);
        opMenu.setFont(bigMenu);
        JMenuItem plusM = new JMenuItem("Add", new ImageIcon("plus.png"));
        plusM.setMnemonic(KeyEvent.VK_C);
        plusM.setActionCommand("+");
        JMenuItem subM = new JMenuItem("Subtract", new ImageIcon("minus.png"));
        subM.setMnemonic(KeyEvent.VK_C);
        subM.setActionCommand("-");
        JMenuItem multiM = new JMenuItem("Multiply", new ImageIcon("multiply.png"));
        multiM.setMnemonic(KeyEvent.VK_C);
        multiM.setActionCommand("x");
        JMenuItem divM = new JMenuItem("Divide", new ImageIcon("divide.png"));
        divM.setMnemonic(KeyEvent.VK_C);
        divM.setActionCommand("/");
        JMenuItem clearM = new JMenuItem("Clear", new ImageIcon("trash.png"));
        clearM.setMnemonic(KeyEvent.VK_C);
        clearM.setActionCommand("C");

        Image pM = ((ImageIcon) plusIcon).getImage();
        Image plM = pM.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        plusM.setIcon(new ImageIcon(plM));

        Image mM = ((ImageIcon) minusIcon).getImage();
        Image miM = mM.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        subM.setIcon(new ImageIcon(miM));

        Image muM = ((ImageIcon) multIcon).getImage();
        Image mulM = muM.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        multiM.setIcon(new ImageIcon(mulM));

        Image dM = ((ImageIcon) divIcon).getImage();
        Image diM = dM.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        divM.setIcon(new ImageIcon(diM));

        Image cM = ((ImageIcon) trashIcon).getImage();
        Image clM = cM.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        clearM.setIcon(new ImageIcon(clM));

        opMenu.add(plusM);
        opMenu.add(subM);
        opMenu.add(multiM);
        opMenu.add(divM);
        opMenu.add(clearM);

        menuBar.add(opMenu);
        display.add(menuBar);

        operator.add(divide);
        operator.add(multiply);
        operator.add(minus);
        operator.add(plus);
        operator.add(equal);
        button.add(operator);

        display.add(button);
        add(display);

        digits.get(11).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValue();
            }
        });

        digits.get(9).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = outputField.getText();
                if(currentText.indexOf(".") < 0){
                    outputField.setText(currentText + ".");
                }
            }
        });

        OperatorListener opListener = new OperatorListener();
        plus.addActionListener(opListener);
        minus.addActionListener(opListener);
        multiply.addActionListener(opListener);
        divide.addActionListener(opListener);

        ActionListener menuAll = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                if (source == plusM){
                    currentOp = "+";
                }else if (source == subM){
                    currentOp = "-";
                }else if (source == multiM){
                    currentOp = "x";
                }else if (source == divM){
                    currentOp = "/";
                }
                String currentText = outputField.getText();
                try {
                    Double currentTextDouble = Double.parseDouble(currentText);
                    first = currentTextDouble;
                    outputField.setText("");
                }catch (NumberFormatException n){
                    resetValue();
                }
            }
        };
        plusM.addActionListener(menuAll);
        subM.addActionListener(menuAll);
        multiM.addActionListener(menuAll);
        divM.addActionListener(menuAll);
        clearM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValue();
            }
        });

        for (int i = 0; i <= 10; i++) {
            digits.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String currentText = outputField.getText();
                    JButton source = (JButton) e.getSource();
                    String newDigit = "";
                    if (source == digits.get(0)) {
                        newDigit = "7";
                    } else if (source == digits.get(1)) {
                        newDigit = "8";
                    } else if (source == digits.get(2)) {
                        newDigit = "9";
                    } else if (source == digits.get(3)) {
                        newDigit = "4";
                    } else if (source == digits.get(4)) {
                        newDigit = "5";
                    } else if (source == digits.get(5)) {
                        newDigit = "6";
                    } else if (source == digits.get(6)) {
                        newDigit = "1";
                    } else if (source == digits.get(7)) {
                        newDigit = "2";
                    } else if (source == digits.get(8)) {
                        newDigit = "3";
                    } else if (source == digits.get(10)) {
                        newDigit = "0";
                    }

                    currentText = currentText + newDigit;
                    currentText = currentText.replaceFirst("^0+(?!$)", "");
                    outputField.setText(currentText);
                }
            });
        }

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = outputField.getText();
                try {
                    second = Double.parseDouble(currentText);

                    if (currentOp.equals("+")){
                        result = first + second;
                    }else if (currentOp.equals("-")){
                        result = first - second;
                    }else if (currentOp.equals("x")){
                        result = first * second;
                    }else if (currentOp.equals("/")){
                        if (second != 0){
                            result = first / second;
                        }else {
                            resetValue();
                            outputField.setBackground(Color.YELLOW);
                        }
                    }
                    String r = String.valueOf(result);
                    outputField.setText(r);
                    first = result;
                }catch (NumberFormatException n){
                    resetValue();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setTitle("Calculator");
        setSize(600, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void resetValue(){
        currentOp = "";
        first = 0.0;
        outputField.setText("0");
        outputField.setBackground(Color.WHITE);
    }

    private class OperatorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JButton source = (JButton) e.getSource();
            if (source == plus){
                currentOp = "+";
            }else if (source == minus){
                currentOp = "-";
            }else if (source == multiply){
                currentOp = "x";
            }else if (source == divide){
                currentOp = "/";
            }

            String currentText = outputField.getText();
            try {
                Double currentTextDouble = Double.parseDouble(currentText);
                first = currentTextDouble;
                outputField.setText("");
            }catch (NumberFormatException n){
                resetValue();
            }
        }
    }

    public static void main(String arg[]){
        new Calculator();
    }
}

//Images are from https://www.flaticon.com