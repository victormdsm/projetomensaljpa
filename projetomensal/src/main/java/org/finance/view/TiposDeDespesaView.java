package org.finance.view;

import org.finance.controller.TiposDeDespesaController;
import org.finance.model.entities.TiposDeDespesaEntity;
import org.finance.model.entities.UsuarioEntity;

import java.util.Scanner;

import static org.finance.view.Screen.usuario;

public class TiposDeDespesaView {
    public static void tipoDeDespesaMenu() {
        Scanner sc = new Scanner(System.in);
        TiposDeDespesaController tiposDeDespesaController = new TiposDeDespesaController();
        usuario.setTiposDeDespesaEntities(tiposDeDespesaController.getAllTipos(usuario.getId()));
        Boolean x =true;
        while (x) {
            System.out.println("Menus de tipo de gasto! ");
            System.out.println("Digite 1 para ver os tipos cadastrados!");
            System.out.println("Digite 2 para cadastrar um tipo!");
            System.out.println("Digite 3 para excluir um tipo de gasto!");

            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    mostrarTudo();
                    break;
                case 2:
                    System.out.println("Digite uma categoria de despesa que você deseja adicionar: ");
                    String categoria = sc.next();
                    TiposDeDespesaEntity tipo = new TiposDeDespesaEntity(categoria, usuario);
                    usuario.addTipoDespesa(tiposDeDespesaController.creatTipo(tipo));
                    System.out.println();
                    break;
                case 3:
                    mostrarTudo();
                    System.out.println("Digite um codigo para excluir: ");
                    Long cdg = sc.nextLong();
                    TiposDeDespesaEntity tiposDeDespesa = null;
                    for (TiposDeDespesaEntity tipos : usuario.getTiposDeDespesaEntities()) {
                        if (tipos.getId() == cdg) {
                            tiposDeDespesa = tipos;
                        }
                    }
                    if (tiposDeDespesa == null) {
                        System.out.println("Codigo nao encontrado!!");
                    } else {
                        tiposDeDespesaController.delete(tiposDeDespesa);
                    }
                    break;
                case 4:
                    x = false;
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        }
    }

    public static void mostrarTudo() {
        for (TiposDeDespesaEntity tipos : usuario.getTiposDeDespesaEntities()) {
            System.out.println("codigo: " + tipos.getId() + " tipoDoGasto: " + tipos.getNomeDaDespesa());
        }
    }
}

