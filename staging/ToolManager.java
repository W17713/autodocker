package toolmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToolManager {
	public String currentdirectory;
	public String currentfilename;
	public String outputdirectory;
	
	public ToolManager(String dir,String filename,String outdir) {
		this.currentdirectory = dir;
		this.currentfilename=filename;
		this.outputdirectory=outdir;
	}
	
	public String createdir(String dirtocreate) {
		File directory = new File(this.outputdirectory+dirtocreate);
		if (!directory.exists()) {
		directory.mkdirs();
		return directory.getAbsolutePath();
		}else {
			return "Directory already exists";
		}
		}
	
	/*public String createfile(String filename, String filetype) {
		File newfile = new File(this.outputdirectory+'/'+filename+'.'+filetype);
		if (!newfile.exists()) {
		try {
			newfile.createNewFile();
			return newfile.getAbsolutePath();
		} catch (IOException e) {
			return e.getMessage();
		}
		
		}else {
			return "File already exists";
		}
	}*/
	
	//Returns true if all dependencies are already installed
	public boolean checkdependencies() {
		return true;
	}
	
	public boolean checkcommand(String[] command) {
		return true;
	}
	
	public boolean checkoutdir() {
		File outdir = new File(this.outputdirectory);
		if (outdir.exists()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean checkinput() {
		int len = this.currentfilename.length();
		if(len >5) {
			if(this.currentfilename.substring(len-5)==".java"){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public String rundockercommand(String[] command) throws IOException {
		boolean dependenciesresult = this.checkdependencies();
		boolean commandresult = this.checkcommand(command);
		if(dependenciesresult) {
			if(commandresult) {
				ProcessBuilder builder = new ProcessBuilder(command);
				builder.redirectErrorStream(true);
				Process p = builder.start();	//start process
				//initialize bufferedreader
				InputStreamReader isr = new InputStreamReader(p.getInputStream());
				BufferedReader r = new BufferedReader(isr);
				String line;
				while(true) {
					line = r.readLine();
					if(line != null) {
						return line;
					}
				}	
			}else {
				return "Invalid command";
			}	
		}else {
			return "All dependencies not installed";
		}
	}
		
		
		
	}


