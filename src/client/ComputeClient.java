package client;

import compute.Compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ComputeClient {

    public static String m_Login = "Bem vindo ao sistema de consultas de disciplinas.\nFaça login para acessar a aplicação.\n1 - Aluno.\n2 - Professor.\ninput: ";
    public static String m_Primary = "Selecione a opção desejada:\n1 - Listar códigos das disciplinas.\n2 - Listar informações das disciplinas.\n3 - Informações sobre disciplina.\n4 - Ementa da disciplina.\n5 - Comentário sobre próxima aula.\nE - Encerrar conexão.\ninput: ";
    public static String m_Secondary = "Selecione a opção desejada:\n1 - Listar códigos das disciplinas.\n2 - Listar informações das disciplinas.\n3 - Informações sobre disciplina.\n4 - Ementa da disciplina.\n5 - Comentário sobre próxima aula.\n6 - Escrever comentário da próxima aula.\nE - Encerrar conexão.\ninput: ";
    public static String m_Code = "Código da disciplina: ";
    public static String m_Class = "Informe a descrição da próxima aula: ";
    public static String m_NotFound = "\nDisciplina não encontrada.\n";
    public static String m_Separator = "\n=======================================\n";
    

    public static void main(String args[]) {
        try {
            String login = "";
            Boolean logged = false;
            while ( true ) { 
                String name = "Compute";
                Registry registry = LocateRegistry.getRegistry(args[0]);
                Compute comp = (Compute) registry.lookup(name);

                Scanner scan = new Scanner(System.in);

                while( true ) {
                    if (!logged) {
                        System.out.println(ComputeClient.m_Login);
                        login = scan.nextLine();

                        if (login.equals("1")) {
                            System.out.println(ComputeClient.m_Primary);
                            logged = true;
                            break;
                        }
                        else if (login.equals("2")) {
                            System.out.println(ComputeClient.m_Secondary);
                            logged = true;
                            break;
                        }
                    }
                    else {
                        if (login.equals("1")) {
                            System.out.println(ComputeClient.m_Primary);
                        }
                        else if (login.equals("2")) {
                            System.out.println(ComputeClient.m_Secondary);
                        }
                        break;
                    }
                }

                String option = scan.nextLine();

                if (option.equals("1")){
                    Read task = new Read(1, "");

                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    
                    System.out.println(m_Separator);
                    System.out.println("Query time: " + ans.time + "µs");
                    System.out.println("Total time: " + output/1000 + "µs");
                    System.out.println(ans.message);
                    System.out.println(m_Separator);
                }
                else if (option.equals("2")){
                    Read task = new Read(2, "");
                    
                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    
                    System.out.println(m_Separator);
                    System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                    System.out.println(ans.message);
                    System.out.println(m_Separator);
                }
                else if (option.equals("3")){
                    System.out.println(m_Code);
                    String code = scan.nextLine();
                    Read task = new Read(3, code);
                    
                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    

                    if (!ans.message.isEmpty()) {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(ans.message);
                        System.out.println(m_Separator);
                    }
                    else {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(m_NotFound);
                        System.out.println(m_Separator);
                    }
                }
                else if (option.equals("4")){
                    System.out.println(m_Code);
                    String code = scan.nextLine();
                    Read task = new Read(4, code);
                    
                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    

                    if (!ans.message.isEmpty()) {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(ans.message);
                        System.out.println(m_Separator);
                    }
                    else {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(m_NotFound);
                        System.out.println(m_Separator);
                    }
                }
                else if (option.equals("5")){
                    System.out.println(m_Code);
                    String code = scan.nextLine();
                    Read task = new Read(5, code);
                    
                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    

                    if (!ans.message.isEmpty()) {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(ans.message);
                        System.out.println(m_Separator);
                    }
                    else {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(m_NotFound);
                        System.out.println(m_Separator);
                    }
                }
                else if (option.equals("6") && login.equals("2")){
                    
                    System.out.println(m_Code);
                    String code = scan.nextLine();

                    System.out.println(m_Class);
                    String classe = scan.nextLine();

                    Write task = new Write(5, code, classe);
                    
                    long lStartTime = System.nanoTime();

                    Answer ans = comp.executeTask(task);

                    long lEndTime = System.nanoTime();
                    long output = lEndTime - lStartTime;
                    

                    if (!ans.message.isEmpty()) {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(ans.message);
                        System.out.println(m_Separator);
                    }
                    else {
                        System.out.println(m_Separator);
                        System.out.println("Query time: " + ans.time + "µs");
                        System.out.println("Total time: " + output/1000 + "µs");
                        System.out.println(m_NotFound);
                        System.out.println(m_Separator);
                    }
                }

                else if (option.equals("E") || option.equals("e") ){
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
