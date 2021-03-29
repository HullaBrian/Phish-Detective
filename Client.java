package picocli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileNotFoundException;
import java.util.concurrent.Callable;

@Command(name = "pd", description = "Performs a simple algorithm on two given urls", mixinStandardHelpOptions = true, version = "File Client 1.0")
class Client implements Callable<String> {

    @Option(names = "--host", description = "Defines the host url for checking")
    private String host_url;

    @Option(names = "--check", description = "Defines the url to check against the host url")
    private String unidentified_url;

    public static void main(String... args) throws Exception {
        int exitCode = new CommandLine(new Client()).execute(args);
        System.exit(exitCode);
    }

    public String call() throws Exception {

            if (host_url != null && unidentified_url != null) {
                Main.start(host_url, unidentified_url);
            }

        return "success";
    }
}

class Main {
    static void start(String host_url, String unidentified_url) throws FileNotFoundException {

        boolean stop = false;  //jpackage --name pd --input E:\Java\PhishDetective\out\artifacts\PhishDetective_jar --main-jar PhishDetective.jar --main-class picocli.Client --win-console

        System.out.println("Host url ~ " + host_url);
        System.out.println("Url in question ~ " + unidentified_url);

        String host_domain = null;
        String host_protocol = null;
        String unidentified_domain = null;
        String unidentified_protocol = null;

        try {
            host_domain = host_url.split("//")[1];
            host_domain = host_domain.substring(0, host_domain.indexOf("/"));
            host_protocol = host_url.split("//")[0].substring(0, host_url.indexOf(":"));
            System.out.println("\nHost domain ~ " + host_domain);
            System.out.println("Host protocol ~ " + host_protocol);
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Malformed host url");
            stop = true;
        }
        try {
            if(!stop) {
                unidentified_domain = unidentified_url.split("//")[1];
                unidentified_domain = unidentified_domain.substring(0, unidentified_domain.indexOf("/"));
                unidentified_protocol = unidentified_url.split("//")[0].substring(0, unidentified_url.indexOf(":"));
                System.out.println("Unidentified domain ~ " + unidentified_domain);
                System.out.println("Unidentified protocol ~ " + unidentified_protocol);
            }
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Malformed checked url");
            stop = true;
        }
        try {
            if(!stop) {
                if (host_domain.equals(unidentified_domain) && host_protocol.equals(unidentified_protocol)) {
                    System.out.println("\nIdentified " + unidentified_url + " as a legitimate site");
                } else {
                    System.out.println("\nWARNING: Identified " + unidentified_url + " as a possible phishing site");
                }
            }
        } catch (NullPointerException e){
            System.out.println("Error processes urls");
        }
    }
}