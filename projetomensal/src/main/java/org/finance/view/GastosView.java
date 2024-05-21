package org.finance.view;

import org.finance.controller.GastoController;
import org.finance.controller.TiposDeDespesaController;
import org.finance.controller.UsuarioController;
import org.finance.model.entities.GastoEntity;
import org.finance.model.entities.TiposDeDespesaEntity;
import org.finance.model.entities.UsuarioEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static org.finance.view.Screen.usuario;
import static org.finance.view.TiposDeDespesaView.mostrarTudo;

public class GastosView {



    public static void gastosMenu() {

        GastoController gastoController = new GastoController();
        TiposDeDespesaController controller = new TiposDeDespesaController();
        UsuarioController usuarioController = new UsuarioController();

        Scanner sc = new Scanner(System.in);
        Boolean x = true;

        while (x) {
            System.out.println("Bem vindo ao gerenciador de Gastos! ");
            System.out.println("Digite 1 para ver os Gastos ");
            System.out.println("Digite 2 para adicionar um Gastos");
            System.out.println("Digite 3 para atualizar um Gastos");
            System.out.println("Digite 4 para excluir um Gastos");
            System.out.println("Digite 5 para ver o quanto gastou em categorias");
            System.out.println("Digite 6 para voltar");

            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    mostrarGastos();
                    break;
                case 2:
                    if(!usuario.getTiposDeDespesaEntities().isEmpty()) {
                        mostrarTudo();
                        System.out.println("Digite o codigo da categoria que voce quer adicionar");
                        Long id = sc.nextLong();
                        TiposDeDespesaEntity tipo = controller.findById(id);
                        if(tipo != null) {
                            System.out.println("Digite o valor que voce deseja! ");
                            BigDecimal valor = sc.nextBigDecimal();
                            sc.nextLine();
                            System.out.println("Digite a data: no formato (YYYY-MM-DD)");
                            LocalDate data = LocalDate.parse(sc.next());
                            UsuarioEntity user = usuarioController.findById(usuario.getId());
                            GastoEntity gasto = new GastoEntity(valor, data, user, tipo);
                            gastoController.creat(gasto);
                            usuario.setGastos(gastoController.getGastos(usuario.getId()));
                        } else {
                            System.out.println("Tipo não existente");
                        }
                    }else {
                        System.out.println("Você não pode adicionar itens pois não possui Categorias de gastos");
                    }
                    break;
                case 3:
                    mostrarGastos();
                    System.out.println("Digite o codigo que voce deseja alterar: ");
                    Long id = sc.nextLong();
                    GastoEntity gasto = gastoController.findById(id);
                    if(gasto != null) {
                        System.out.println("Digite o novo valor: ");
                        BigDecimal valor = sc.nextBigDecimal();
                        sc.nextLine();
                        System.out.println("Digite a nova data: (YYYY-MM-DD)");
                        LocalDate data = LocalDate.parse(sc.next());
                        sc.nextLine();
                        gasto.setValor(valor);
                        gasto.setDiaDoGasto(data);
                        gastoController.update(gasto);
                        System.out.println("Atualizado! ");
                        usuario.setGastos(gastoController.getGastos(usuario.getId()));
                    } else {
                        System.out.println("Gasto não encontrado");
                    }
                    break;
                case 4:
                    mostrarGastos();
                    System.out.println("Digite o codigo da despesa que voce deseja deletar");
                    Long cdg = sc.nextLong();
                    GastoEntity gasto1 = gastoController.findById(cdg);
                    if(gasto1 != null) {
                        gastoController.delete(gasto1);
                        System.out.println("Deletado com sucesso");
                        usuario.setGastos(gastoController.getGastos(usuario.getId()));
                    } else {
                        System.out.println("Gasto não encontrado");
                    }
                    break;
                case 5:
                    mostrarTudo();
                    System.out.println("Digite o codigo do tipo de despesa para você saber o quanto já gastou: ");
                    Long cdg1 = sc.nextLong();
                    TiposDeDespesaEntity tiposDeDespesa = controller.findById(cdg1);
                    if (tiposDeDespesa != null) {
                        System.out.println("Voce gastou um total de: " + gastoController.valorTotalCategoria(tiposDeDespesa.getId()) + " Na categoria: " + tiposDeDespesa.getNomeDaDespesa());
                    } else {
                        System.out.println("codigo invalido");
                    }
                    break;
                case 6:
                    x = false;
                    break;
                default:
                    System.out.println("Opção Invalida!!! ");
            }
        }

    }

    public static void mostrarGastos() {
        GastoController gastoController = new GastoController();
        usuario.setGastos(gastoController.getGastos(usuario.getId()));
        if(usuario.getGastos() == null) {
            System.out.println("Você ainda não possui despesas cadastradas");
        } else {
            for (GastoEntity gastos: usuario.getGastos()) {
                System.out.println("Codigo: "+ gastos.getId() + " Data: " + gastos.getDiaDoGasto() + " Valor: " + gastos.getValor() + " Categoria: " + gastos.getTiposDeDespesa().getNomeDaDespesa());
            }
        }
    }
}
