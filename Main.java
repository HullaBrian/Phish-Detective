import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String[] filePath = new File("Main.java").getAbsolutePath().split("\\\\");
        ArrayList<String> path2 = new ArrayList<>(Arrays.asList(filePath).subList(0, filePath.length-1));
        StringBuilder path = new StringBuilder();
        for(String value : path2.subList(0,path2.size())){
            path.append(value).append("\\");
        }
        path.append("urls.txt");
        System.out.println("File path detected as: " + path.toString() + "\n");

        ArrayList<String> urls = new ArrayList<>(FileHandler.readFile(path.toString()));
        String host_url = urls.get(0);
        String unidentified_url = urls.get(1);
        System.out.println("Host url ~ " + host_url);
        System.out.println("Url in question ~ " + unidentified_url);

        String host_domain = host_url.split("//")[1];
        host_domain = host_domain.substring(0, host_domain.indexOf("/"));
        String host_protocol = host_url.split("//")[0].substring(0, host_url.indexOf(":"));
        System.out.println("\nHost domain ~ " + host_domain);
        System.out.println("Host protocol ~ " + host_protocol);

        String unidentified_domain = unidentified_url.split("//")[1];
        unidentified_domain = unidentified_domain.substring(0, unidentified_domain.indexOf("/"));
        String unidentified_protocol = unidentified_url.split("//")[0].substring(0, unidentified_url.indexOf(":"));
        System.out.println("Unidentified domain ~ " + unidentified_domain);
        System.out.println("Unidentified protocol ~ " + unidentified_protocol);

        if (host_domain.equals(unidentified_domain) && host_protocol.equals(unidentified_protocol)) {
            System.out.println("\nIdentified " + unidentified_url + " as a legitimate site");
        } else{
            System.out.println("\nIdentified " + unidentified_url + " as a phishing site");
        }
    }
}
class FileHandler {
    static ArrayList<String> readFile(String filePath) throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();
        Scanner myScanner = new Scanner(new File(filePath));
        while(myScanner.hasNext()){
            data.add(myScanner.nextLine());
        }
        return data;
    }
}
