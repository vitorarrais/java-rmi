package client;

import compute.Task;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Write implements Task<Answer>, Serializable {

    private final int type;
    private final String code;
    private final String input;

    public Write(int type, String code, String input) {
        this.type = type;
        this.code = code;
        this.input = input;
    }

    public Answer execute() {
        return loadAnswer(type, code, input);
    }

    public Answer loadAnswer(int type, String code, String input) {

        int status;

        long lStartTime = System.nanoTime();

        String message = setInformation(type, code, input);

        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;

        if ( message == "" ) status = 0;
        else status = 1;

        Answer result = new Answer(status, message, output/1000);
        return result;
    }

    public String setInformation(int type, String code, String input) {
        ArrayList<Discipline> dsps = readfile();

        String msg = "";
        for (Discipline d : dsps) {
            if (d.code.equals(code)) {
                d.next_class = input;
                writefile(dsps);
                msg = "\nAlteração feita com sucesso.\n";
            }
        }

        return msg;
    }

    public String all_to_string(Discipline dsp) {
        return ("Código: " + dsp.code + 
                "\nDisciplina: " + dsp.title +
                "\nEmenta: " + dsp.syllabus +
                "\nSala: " + dsp.classroom +
                "\nHorário: " + dsp.time +
                "\nPróxima aula: " + dsp.next_class + "\n");
    }

    public void writefile(ArrayList<Discipline> dsps) {
        int n = dsps.size();
        try { 
            PrintWriter writer = new PrintWriter("database/database.dat", "UTF-8");
            writer.println(n);
            for (Discipline d : dsps) {
                writer.println( d.title+";"+d.syllabus+";"+d.classroom+";"+d.next_class+";"+d.code+";"+d.time );
            }
            writer.close();
        } catch (IOException ioe){
            System.err.println("File not found.");
            ioe.printStackTrace();
        }
    }

    public ArrayList<Discipline> readfile() {
        int n;

        ArrayList<Discipline> dsps = new ArrayList<Discipline>(10);

        try {

            Scanner scanner = new Scanner(new File("database/database.dat"));
            scanner.useDelimiter(";|\\n");

            n = Integer.parseInt(scanner.next().replace(" " , ""));

            for ( int i = 0; i < n; i++ ){
                Discipline dsp = new Discipline();

                dsp.title = scanner.next();
                dsp.syllabus = scanner.next();
                dsp.classroom = scanner.next();
                dsp.next_class = scanner.next();
                dsp.code = scanner.next();
                dsp.time = Integer.parseInt(scanner.next().replace(" " , ""));

                dsps.add(dsp);
            }
            scanner.close();

        } catch (FileNotFoundException e){
            System.err.println("File not found.");
            e.printStackTrace();
        }

        return dsps;
    }



}