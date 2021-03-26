public class Main {
    public static void main(String[] args) {
        String host_url = "http://www.utexas.edu/hr/current/services/ohp.html";
        String unidentified_url = "https://www.utexas.edu.4909323.877343.xyzabc.ru/2342344/email";
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
