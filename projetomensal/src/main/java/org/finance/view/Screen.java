package org.finance.view;

import org.finance.controller.GastoController;
import org.finance.controller.UsuarioController;
import org.finance.model.entities.EnderecoEntity;
import org.finance.model.entities.UsuarioEntity;

import java.time.LocalDate;
import java.util.Scanner;

import static org.finance.view.GastosView.gastosMenu;
import static org.finance.view.TiposDeDespesaView.tipoDeDespesaMenu;
import static org.finance.view.AlterarDadosDosUsuariosView.menuDados;

public class Screen {

    public static UsuarioEntity usuario = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();

        System.out.println("Seja bem vindo ao sistema de controle de finanças!! ");
        while (usuario == null) {

            System.out.println("Já possui cadastro ?");
            System.out.println("Digite 1 para entrar no sistema! ");
            System.out.println("Caso não possua cadastro digite 2 para fazer um cadastro!");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Digite o login: ");
                    String email = sc.next();
                    sc.nextLine();
                    System.out.println("Digite a senha: ");
                    String senha = sc.next();
                    usuario = usuarioController.login(email, senha);
                    if (usuario != null) {
                        System.out.println("Logado com sucesso");
                    } else {
                        System.out.println("Usuario não encontrado!");
                    }
                    break;
                case 2:
                    System.out.println("Digite seu nome: ");
                    String nome = sc.next();
                    sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf = sc.next();
                    sc.nextLine();
                    System.out.println("Digite sua data de nascimento (AAAA-MM-DD): ");
                    LocalDate dataNascimento = LocalDate.parse(sc.next());
                    sc.nextLine();
                    System.out.println("Digite seu email: ");
                    email = sc.next();
                    sc.nextLine();
                    System.out.println("Digite um nome de usuário: ");
                    String nomeUsuario = sc.next();
                    sc.nextLine();
                    System.out.println("Digite uma senha: ");
                    senha = sc.next();
                    sc.nextLine();

                    System.out.println("Digite seu endereço:");
                    System.out.println("Rua: ");
                    String rua = sc.next();
                    sc.nextLine();
                    System.out.println("Número: ");
                    String numero = sc.next();
                    sc.nextLine();
                    System.out.println("CEP: ");
                    String cep = sc.next();
                    sc.nextLine();
                    System.out.println("Cidade: ");
                    String cidade = sc.next();
                    sc.nextLine();
                    System.out.println("Estado: ");
                    String estado = sc.next();
                    sc.nextLine();
                    System.out.println("País: ");
                    String pais = sc.next();
                    sc.nextLine();
                    System.out.println("Complemento: ");
                    String complemento = sc.next();

                    EnderecoEntity endereco = new EnderecoEntity(rua, numero, cep, cidade, estado, pais, complemento);

                    UsuarioEntity novoUsuario = new UsuarioEntity(nome, cpf, dataNascimento, email, nomeUsuario, senha, endereco);
                    usuario = usuarioController.creatUser(novoUsuario);

                    if (usuario != null) {
                        System.out.println("Cadastro realizado com sucesso");
                    } else {
                        System.out.println("Erro ao realizar o cadastro. Tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Digite 1 para login ou 2 para cadastro.");
                    opc = sc.nextInt();
                    break;
            }
        }

        GastoController gastoController = new GastoController();
        System.out.println("Bem vindo! :" + usuario.getNomeUsuario());
        System.out.println("Você já gastou um total de: " + gastoController.valorTotal(usuario.getId()));
        Boolean x = true;

        while (x) {
            System.out.println("Menu de opções: ");
            System.out.println("Digite 1 para gerenciar tipos de Desepesas");
            System.out.println("Digite 2 para gerenciar gastos ");
            System.out.println("Digite 3 para gerenciar seus dados");
            System.out.println("Digite 4 para sair");
            System.out.println("Bem vindo! :" + usuario.getNomeUsuario());
            System.out.println("Você já gastou um total de: " + gastoController.valorTotal(usuario.getId()));
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    tipoDeDespesaMenu();
                    break;
                case 2:
                    gastosMenu();
                    break;
                case 3:
                    menuDados();
                    break;
                case 4:
                    System.out.println("Bye bye!");
                    x = false;
                    break;
                default:
                    System.out.println("Opção Inválida! Digite novamente");
                    break;
            }
        }

    }
}
