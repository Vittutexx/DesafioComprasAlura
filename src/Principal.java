import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Intanciando o scanner e setando o limite do cartão
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        //Criando uma variável para efetuar um laço de compras onde o usuario só poderá sair +
        // do laço quando digitar o numero 0 após comprar um produto ou ficar sem saldo.
        int sair = 1;
        while(sair != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancarCompra(compra);


            //Criando o while para finalizar a compra ou finalizar e inicar uma outra compra
            if (compraRealizada) {
                System.out.println("A compra foi realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!!");
                sair = 0;
            }//if
        }//while

        //Informa as compras realizadas
        System.out.println("==================\n");
        System.out.println("COMPRAS REALIZADAS\n");
        System.out.println("==================\n");

        //Organizando a array de acordo com o valor da compra.
        Collections.sort(cartao.getCompras());

        //Criando um laço para percorrer o array e apresentar cada produto dele.
        for(Compra c : cartao.getCompras()){
            System.out.println("Compra de " + "'"+ c.getDescricao() + "'" + " No valor de: " + c.getValor());
        }//foreach

        //Informando o saldo final do cartão após as compras realizadas.
        System.out.println("==================\n");
        System.out.println("SALDO DO CARTÃO: "+ cartao.getSaldo() + "\n");
        System.out.println("==================\n");




    }//main
}//classe
