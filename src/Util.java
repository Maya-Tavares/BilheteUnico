import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Util {

    private Bilhete[] bilhete = new Bilhete[5];
    private int index = 0;

    public void menuPrincipal() {
        int opcao = 0;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao < 1 || opcao > 3) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        menuAdministrador();
                        break;

                    case 2:
                        menuUsario();
                        break;
                }
            }
        } while (opcao != 3);
    }

    private void menuAdministrador() {
        int opcao;
        String menuAdmin = "1. Emitir bilhete\n";
        menuAdmin += "2. Listar bilhetes\n";
        menuAdmin += "3. Remover bilhetes\n";
        menuAdmin += "4. Sair\n";

        do {
            opcao = parseInt(showInputDialog(menuAdmin));
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválido");
            } else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                }
            }
        } while (opcao != 4);
    }

    private void emitirBilhete() {

        String nome;
        long cpf;
        String perfil;

        if (index < bilhete.length) {
            nome = showInputDialog("Nome:");
            cpf = parseLong(showInputDialog("CPF"));
            perfil = showInputDialog("Estudante ou Professor ou Comum");
            bilhete[index] = new Bilhete(new Usuario(nome, cpf, perfil));
            index++;
        }
    }

    private void listarBilhetes() {

    }

    private void menuUsario() {
        int opcao;
        String menu = "1. Consultar Bilhete\n2. Carregar Bilhete\n3.Passar na Catraca\n4.Sair";
        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida.");
            } else {
                switch (opcao) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        carregarBilhete();
                    default:
                        break;
                }
            }
        } while (opcao != 4);
    }

    private void carregarBilhete() {
        int posicao = pesquisar();
        double valor;
        if (posicao != -1) {
            valor = parseDouble(showInputDialog("Valor da recarga"));
            bilhete[posicao].porSaldo(valor);
        }
    }

    private void passarCatraca() {

    }

    private void consultarSaldo() {
        int posicao = pesquisar();
        if (posicao != -1) {
            showMessageDialog(null, bilhete[posicao].cadeSaldo());
        }
    }

    private int pesquisar() {
        int posicao = -1;
        long cpf = parseLong(showInputDialog("CPF: "));
        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf) {
                return i;
            }
            showMessageDialog(null, cpf + " Não encontrado.");
        }

        return posicao;
        // return 0;
    }
}