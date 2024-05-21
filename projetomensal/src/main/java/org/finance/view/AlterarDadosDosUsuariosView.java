package org.finance.view;

import org.finance.controller.EnderecoController;
import org.finance.controller.UsuarioController;

import java.util.Scanner;

import static org.finance.view.Screen.usuario;

public class AlterarDadosDosUsuariosView {

    public static void menuDados() {

        Scanner sc = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        EnderecoController enderecoController = new EnderecoController();



        System.out.println("Seus dados pessoais");
        System.out.println("Dados do Usuário:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Nome de Usuário: " + usuario.getNomeUsuario());
        System.out.println("Endereço:");
        System.out.println("Rua: " + usuario.getEndereco().getRua());
        System.out.println("Número: " + usuario.getEndereco().getNumero());
        System.out.println("CEP: " + usuario.getEndereco().getCep());
        System.out.println("Cidade: " + usuario.getEndereco().getCidade());
        System.out.println("Estado: " + usuario.getEndereco().getEstado());System.out.println("País: " + usuario.getEndereco().getPais());
        System.out.println("Complemento: " + usuario.getEndereco().getComplemento());

        System.out.println("Digite 1 para alterar endereço! ");
        System.out.println("Digite 2 para alterar Usuario");
        System.out.println("Digite 3 para retornar ao menu de opções");
        int opc = sc.nextInt();

        switch (opc){
            case 1:
                System.out.println("Digite o novo endereço:");
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
                sc.nextLine();

                usuario.getEndereco().setRua(rua);
                usuario.getEndereco().setNumero(numero);
                usuario.getEndereco().setCep(cep);
                usuario.getEndereco().setCidade(cidade);
                usuario.getEndereco().setEstado(estado);
                usuario.getEndereco().setPais(pais);
                usuario.getEndereco().setComplemento(complemento);

                usuario.setEndereco(enderecoController.updateEndereco(usuario.getEndereco()));

                break;
            case 2:
                System.out.println("Digite o novo nome de usuario: ");
                String username = sc.next();
                sc.nextLine();
                System.out.println("Digite o novo email: ");
                String email = sc.next();
                usuario.setNomeUsuario(username);
                usuario.setEmail(email);
                usuarioController.updateUser(usuario);
                break;
            case 3:
                System.out.println("Voltando: ");
                break;
            default:
                System.out.println("Valor invalido");
                break;
        }

    }
}
