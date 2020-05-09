import javax.swing.*;

public class Window extends JFrame {
    float peso;
    float altura;

    private JTextField textField1;
    private JTextField textField2;
    private JButton verificarOIMCButton;
    private JPanel jPanel;
    private JLabel resultLabel;
    private JButton verTabelaButton;

    public Window(){
        setSize(800, 600);
        setTitle("Calculadora do seu IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(jPanel);

        verificarOIMCButton.addActionListener(actionEvent -> {
            try {
                peso = Float.parseFloat(textField1.getText());
                altura = Float.parseFloat(textField2.getText());

                float imc = peso / (altura * altura);

                if(imc < 18.5){
                    resultLabel.setText("Resultado: Magreza IMC: " + imc);
                }else if((imc >= 18.5) && (imc <= 24.9)){
                    resultLabel.setText("Resultado: Peso normal IMC: " + imc);
                }else if((imc >= 25.0) && (imc <= 29.9)){
                    resultLabel.setText("Resultado: Sobrepeso IMC: " + imc);
                }else if((imc >= 30.0) && (imc <= 39.9)){
                    resultLabel.setText("Resultado: Obesidade IMC: " + imc);
                }else if(imc > 40.0){
                    resultLabel.setText("Resultado: Obesidade grave IMC: " + imc);
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Verifique se o número foi digitado corretamente (com . ao invés de ,) e " +
                        "se foi digitado um NÚMERO ao invés de LETRAS");
            }

        });

        verTabelaButton.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(null, "Menor que 18,5 -> Magreza" +
                    "\n" + "Entre 18,5 e 24,9 -> Peso normal" + "\n" + "Entre 25 e 29,9 -> Sobrepeso" +
                    "\n" + "Entre 30 e 39,9 -> Obesidade" + "\n" + "Acima de 40 -> Obesidade grave", "Tabela de IMC"
                    , JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
