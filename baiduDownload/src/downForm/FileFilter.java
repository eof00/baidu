package downForm;

public class FileFilter extends javax.swing.filechooser.FileFilter{
	public boolean accept(java.io.File f) {
    if (f.isDirectory())return true;
    return f.getName().endsWith(getDescription());  //设置为选择以.txt为后缀的文件
  } 
  public String getDescription(){
    return ".txt";
  }
}

