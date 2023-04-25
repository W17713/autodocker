package parser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.HashMap;
import com.github.javaparser.*;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;


public class Parser {
	public String filepath;
	public String filecontent;
	public HashMap<String,String> componentsHMap;
	
	Parser(String filepath){
		this.filepath = filepath;
		componentsHMap= new HashMap<String, String>();
	}
	
	public void read() throws IOException {
		Path fp = Path.of(this.filepath);
		this.filecontent = Files.readString(fp);	
	}
	
	//
	 public void listClasses() {
	        new VoidVisitorAdapter<Object>() {
	            @Override
	            public void visit(ClassOrInterfaceDeclaration n, Object arg) {
	                super.visit(n, arg);
	                System.out.println(" * " + n.getBody());
	                System.out.println(" * " + n.getDeclarationAsString());
	            }
	        }.visit(StaticJavaParser.parse(this.filepath), null);
	        System.out.println();
	    }
	
	public void parse() throws IOException {
		InputStream in = null;
		CompilationUnit compunit=null;
		
		try {
			//InputStream in = SEDInputStream(this.filepath);
			in = new FileInputStream(this.filepath);
			compunit=JavaParser.parse(in);
			//find all class declarations
			compunit.findAll(ClassOrInterfaceDeclaration.class).stream().filter(f -> !isStatic()).forEach(
					f -> componentsHMap.put(f.getName(),f.getDeclarationAsString()));	//add to hashmap
			System.out.print(componentsHMap);	//print HashMap
		}
		catch(ParseException e) {
			//Parser exception handling
			System.out.print(e.getMessage());
		}
		finally {
			in.close();
		}
	}
	
	public String find(String keystring) {
		//get content from hashmap
		String content = componentsHMap.get(keystring);
		return content;
	}
	

}
