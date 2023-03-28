package com.autodocker;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option.Builder;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.ParseException as CLIParseException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;

//private org.apache.commons.cli.ParseException CLIParseException;

public class parser {
        //public org.apache.commons.cli.ParseException CLIParseException;
        public String filepath;
        public String filecontent;
        public HashMap<String,String> componentsHMap;
        public   parser(String filepath){
             this.filepath = filepath;
             componentsHMap= new HashMap<String, String>();
                                         }
                                                    
                                                        /*public void read() throws IOException {
                                                                    Path fp = Path.of(this.filepath);
                                                                            this.filecontent = Files.readString(fp);    
                                                                                }*/
     /*public static  void listClasses(File file) {
         try{
            new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(ClassOrInterfaceDeclaration n, Object arg) {
            super.visit(n, arg);
            System.out.println(" * " + n.getName());
//          System.out.println(" * " + n.getDeclarationAsString());
//          System.out.println(" * " + n.getDeclarationAsString());
                        }
                        }.visit(JavaParser.parse(file), null);
             System.out.println();
             } catch (ParseException | IOException e) {
                    new RuntimeException(e);
                            }                                                                                                            
                                                }*/
/*public void parse(File filepath) throws IOException {
       InputStream in = null;
       CompilationUnit compunit=null;
       try {
                                                //InputStream in = SEDInputStream(this.filepath);
            in = new FileInputStream(filepath);
            compunit=JavaParser.parse(in);
                                                                                    //find all class declarations
    //        compunit.findAll(ClassOrInterfaceDeclaration.class).stream().filter(f -> !isStatic()).forEach(
  //                                                                                                                  f -> componentsHMap.put(f.getName(),f.getDeclarationAsString()));   //add to hashmap
//                                                                                                                                System.out.print(componentsHMap);   //print HashMap
                                                                                                                                        }
        catch(ParseException e) {
                        //Parser exception handling
              System.out.print(e.getMessage());
                                }
        finally {
              in.close();
                }
         System.out.print(compunit);
         return compunit;
}*/
                                                                                //}
    public String find(String keystring) {
                //get content from hashmap
                        String content = componentsHMap.get(keystring);
                                return content;
                                    }

   public static void main(String[] args) {
//       System.out.println(args[0]);
 //      System.out.println(args[1]);
                CommandLine commandLine;
                Option option_in = Option.builder("i")
                                    .required(true)
                                    .desc("This is a required option used to provide the path of the input java file.")
                                    .longOpt("input")
                                    .build();
                Option option_out = Option.builder("o")
                                    .required(false)
                                    .desc("The is an option used to specify the output path where the generated component directories and files will be. Default is current working directory.")
                                    .longOpt("output")
                                    .build();

                Options options = new Options();
                CommandLineParser parser = new DefaultParser();
                options.addOption(option_in);
                options.addOption(option_out);
                String inputpath="";
                String outputpath="";
                String content="";
//                private org.apache.commons.cli.ParseException CLIParseException;
                try{
                    commandLine = parser.parse(options, args);
                    List<String> arguments = commandLine.getArgList();
                    /*System.out.println("Printing members");
                    for (String member : arguments){
                        System.out.println(member);
                        }
                    if(commandLine.hasOption("o")){
                        outputpath=commandLine.getOptionValue("o");
                        }
                    else{
                        outputpath=System.getProperty("user.dir");
                        }*/
                    if(commandLine.hasOption("i")){
                        //System.out.println("Has option i. The value is:");
                        if(arguments.size() > 1){
                            for(String argmember: arguments){
                                if(argmember.contains(".java")){
                                    inputpath=argmember;
                                    }else{
                                        outputpath=argmember;
                                        }
                                }
                            }else{
                                outputpath=System.getProperty("user.dir");
                                }
                    }

                        //inputpath=commandLine.getOptionValue("i");
                        System.out.println("input path "+inputpath);
                        System.out.println("output path "+outputpath);
                        File file = new File(inputpath);
                        content = FileUtils.readFileToString(file);
                        //}
                       // }
              //  catch(org.apache.commons.cli.ParseException e){
                //    System.out.print("Argument parse error:");
                 //   System.out.println(e.getMessage());
                   // }
               //File file = new File(inputpath);
               //try{
                 //  String content = FileUtils.readFileToString(file);
                   //String content = "class A {public static void main(String[] args){System.out.println(\"main function\");}}";
                  
      //         }catch(IOException e){
    //               System.out.println(e.getMessage());
  //                 }
                      // listClasses(pathtojavafile);
  //                    parse(pathtojavafile);
  CompilationUnit cu = StaticJavaParser.parse(content);
  cu.findAll(ClassOrInterfaceDeclaration.class).stream().filter(f -> !f.isInterface() && !f.isAbstract()).forEach(
                    f -> System.out.println(f.getName()));
//  System.out.println(cu);
               }catch(IOException | org.apache.commons.cli.ParseException e){
                           System.out.println(e.getMessage());
                            }
                             }
                                        

}

