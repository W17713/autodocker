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
import toolmanager.ToolManager;
//private org.apache.commons.cli.ParseException CLIParseException;

class ClassNameCollector extends VoidVisitorAdapter<List<String>>{
              @Override
              public void visit(ClassOrInterfaceDeclaration n, List<String> collector) {
              super.visit(n, collector);
              collector.add(n.getNameAsString());
                                         }
      }

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
                        for(int i=0;i<inputpath.length();i++){
                        System.out.print("=");
                        }
                        System.out.println("\nAUTODOCKER is starting with below initializations:");
                        System.out.println("Input file path: "+inputpath);
                        System.out.println("Output path: "+outputpath);
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
  //ArrayList<String> secClasses = new ArrayList<String>();
  List<String> className = new ArrayList<>();
  CompilationUnit cu = StaticJavaParser.parse(content);
  String[] secClasses = {"SecureSenderConnector","SecuritySenderCoordinator","SecureReceiverConnector","SecurityReceiverCoordinator"};

  VoidVisitorAdapter<List<String>> classNameVisitor = new ClassNameCollector();
  String prompt2="Classes found in input file";
  System.out.println("\n"+prompt2);
  for(int i=0;i<prompt2.length();i++){
            System.out.print("=");
                 }
  System.out.println("\n");
  
  //cu.findAll(ClassOrInterfaceDeclaration.class).stream().filter(f -> !f.isInterface() && !f.isAbstract()).forEach(
    //                f->System.out.println(f.getName()));
  classNameVisitor.visit(cu,className);
  className.forEach(n->System.out.println("Class name: "+n));
  
  ArrayList<String> components2create = new ArrayList<String>();
  for(int m=0;m<className.size();m++){
     //System.out.println("class name:"+m);
     //System.out.println("sec class: "+secClasses[0]);
      if("SecureSenderConnector".equals(className.get(m))){
         components2create.add("securesenderConnector");
          }

      if("SecureReceiverConnector".equals(className.get(m))){
          components2create.add("securereceiverConnector");
          }
          }
 if(components2create.size()>1){
      components2create.add("key");
      }
String prompt3="Creating components";
System.out.println("\n"+prompt3);
for(int i=0;i<prompt3.length();i++){
        System.out.print("=");
                                    }
System.out.println("\n");
for(String n:components2create){
    System.out.println("Component: "+n);
    }
 String curdir = System.getProperty("user.dir");
 ToolManager tm = new ToolManager(curdir,inputpath,outputpath);
 String assetPath=curdir+"/assets/";
System.out.println("\nCreating docker compose config file");
tm.createEntities(assetPath+"/docker-compose.yml",outputpath+"/docker-compose.yml");
String[] mvnfiles ={"mvnw","mvnw.cmd"};
String[] javamainfiles={"key","securesenderConnector","securereceiverConnector"};
System.out.println("Creating maven files");
 for(String n:components2create){
     tm.createdir(n);
     tm.createdir(n+"/"+n+"_server");
     tm.createdir(n+"/"+n+"_server/"+"src/main/java/com/"+n+"_server");
     //tm.createdir(n+"/"+n+"_server/.mvn");
          System.out.println("Creating directory for "+n+" component");
          System.out.println("Creating Dockerfile for "+n+" component");
          tm.createEntities(assetPath+n+"/Dockerfile",outputpath+n+"/Dockerfile");
          System.out.println("Creating maven files for "+n+" component");
          for(String mvn: mvnfiles){
                   tm.createEntities(assetPath+"/"+mvn,outputpath+n+"/"+n+"_server/"+mvn);
                  }

System.out.println("Creating java files");
tm.createEntities(assetPath+"/"+n+".java",outputpath+n+"/"+n+"_server/"+"src/main/java/com/"+n+"_server/"+n+".java");          
          }
 /*System.out.println("Creating java files");
 for(String jvfile: components2create){
        tm.createEntities(assetPath+"/"+jvfile,outputpath+n+"/"+n+"_server/"+"src/main/java/com/"+n+"_server/"+jvfile+".java");
                   }*/


               }catch(IOException | org.apache.commons.cli.ParseException e){
                           System.out.println(e.getMessage());
                            }
                             }
                                        

}

