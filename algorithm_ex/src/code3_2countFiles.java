import java.io.File;
import java.util.Stack;

public class code3_2countFiles {

    public static int countFiles(String path){
        File root=new File(path);
        if(!root.isDirectory()&&!root.isFile()){
            return 0;
        }else if(root.isFile()){
            return 1;
        }
        Stack<File> stack=new Stack<>();
        stack.add(root);
        int files=0;
        File List;
        while(!stack.isEmpty()){
            //弹出的是文件、文件夹
            List=stack.pop();
            for(File next:List.listFiles()){
                if(next.isFile()){
                    files++;
                }else if(next.isDirectory()){
                    stack.push(next);
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        String path="C:\\Users\\18621\\Documents\\Tencent Files";
        System.out.println(countFiles(path));
    }
}
