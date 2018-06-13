package client;

import compute.Compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ComputeClient {

    public static String primary = "Selecione a opção desejada:\n1 - Listar códigos das disciplinas.\n2 - Listar informações das disciplinas.\n3 - Informações sobre disciplina.\n4 - Ementa da disciplina.\n5 - Comentário sobre próxima aula.\nE - Encerrar conexão.\ninput: ";

    public static void main(String args[]) {
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);

            System.out.println(ComputeClient.primary);

            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine();

            if (option.equals("1")){
                //TODO: create a Task and call executeTask on comp
            }
            else if (option.equals("2")){
                //TODO: create a Task and call executeTask on comp
            }
            else if (option.equals("3")){
                //TODO: create a Task and call executeTask on comp
            }
            else if (option.equals("4")){
                //TODO: create a Task and call executeTask on comp
            }
            else if (option.equals("5")){
                //TODO: create a Task and call executeTask on comp
            }
            else if (option.equals("E")){
                //TODO: create a Task and call executeTask on comp
            }
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
