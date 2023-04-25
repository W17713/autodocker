package creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creator {
	public String dirpath;
	public String filename;
	public String createtype;
	public File newfile;
	
	public Creator(String dirpath,String filename, String createtype) throws IOException {
		this.dirpath = dirpath;
		this.filename = filename;
		this.createtype = createtype;
		this.newfile = new File(this.dirpath+'/'+this.filename+this.createtype);
		
	}
	
	public boolean create() {
		try {
			if(!this.newfile.isFile()) {
				return false;
			}
			this.newfile.createNewFile();
			this.newfile.setWritable(true);
			return true;
		} catch (IOException e) {
			System.out.print(e.getMessage());
			return false;
		}
	}	
	
	public String append(String content) {
			try {
				if(this.newfile.exists()) { 
				FileWriter filewriter = new FileWriter(this.newfile,true);
				filewriter.write(content);
				filewriter.close();
				}else {
					return "File does not exist";
				}
				return this.newfile.getAbsolutePath();
			} catch (IOException e) {
				return e.getMessage();
			}	
	}
	

}
