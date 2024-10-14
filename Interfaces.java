import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * The Interfaces class retrieves and displays information about the network interfaces
 * available on the local machine. It lists each interface's display name, hardware (MAC) address,
 * associated IP addresses, and broadcast addresses.
 * @author TNjela
 */
public class Interfaces {

    /**
     * The main method is the entry point of the program. It performs the following actions:
     * 1. Retrieves the local host's IPv4 address.
     * 2. Enumerates all network interfaces and prints their display names and MAC addresses.
     * 3. Retrieves the network interface associated with the local host's IP address and prints
     *    its name, IP addresses, and broadcast addresses.
     * 4. Demonstrates formatting a byte value into a hexadecimal string.
     * 
     * @param args command line arguments passed to the program (not used here).
     */
    public static void main(String[] args) {
        if (args.length != 1) { // ensure only a single argument is provided
            System.out.println("Please enter only 1 argument (interface name)");
            return; // exit the program
        }

        String interfaceName = args[0]; // Save the specified interface

        // Try block to handle potential exceptions that may arise during network operations
        try {
            // Get the network interface with the specified name
            NetworkInterface networkInterface = NetworkInterface.getByName(interfaceName);

            // Check if the interface exists
            if (networkInterface == null) {
                System.out.println("Interface not found: " + interfaceName);
                return;
            }
            
            // Print the interface details
            System.out.println("Interface: " + networkInterface.getDisplayName());
            System.out.println("MAC Address: " + Arrays.toString(networkInterface.getHardwareAddress()));
            
            // Get and print IP addresses associated with the interface
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            System.out.println("IP Addresses:");
            while (inetAddresses.hasMoreElements()) {
                System.out.println("- " + inetAddresses.nextElement().getHostAddress());
            }

            // Get the local host IP address (IPv4)
            InetAddress localHost = Inet4Address.getLocalHost();

            // Retrieve an enumeration of all network interfaces available on the machine
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            // Variable to hold the current network interface during iteration
            NetworkInterface thisInterface;

            // Loop through each network interface in the enumeration
            while (networkInterfaces.hasMoreElements()) {
                // Get the next network interface in the enumeration
                thisInterface = networkInterfaces.nextElement();

                // Check if the interface is virtual
                if (!thisInterface.isVirtual()) {
                    // Print the display name of the network interface and its hardware (MAC) address
                    System.out.println(thisInterface.getDisplayName() + ": " + Arrays.toString(thisInterface.getHardwareAddress()));

                    // Print the MTU
                    System.out.println("MTU: " + thisInterface.getMTU());

                    // Print IP addresses, subnet masks, and broadcast addresses
                    for (InterfaceAddress address : thisInterface.getInterfaceAddresses()) {
                        System.out.println("  - IP Address: " + address.getAddress().getHostAddress());
                        System.out.println("    Subnet Mask: " + address.getNetworkPrefixLength() + " bits");
                        // Check if getBroadcast() returns a valid address
                        if (address.getBroadcast() != null) {
                            System.out.println("    Broadcast: " + address.getBroadcast().getHostAddress());
                        } else {
                            System.out.println("    Broadcast: N/A"); // Or any other appropriate message
                        }
                    }
                } else if (thisInterface.getName().equals("lo")) {
                    // Handle loopback interface
                    System.out.println("Loopback: " + thisInterface.getDisplayName() + ": " + Arrays.toString(thisInterface.getHardwareAddress()));
                    System.out.println("MTU: " + thisInterface.getMTU());
                    for (InterfaceAddress address : thisInterface.getInterfaceAddresses()) {
                        System.out.println("  - IP Address: " + address.getAddress().getHostAddress());
                        System.out.println("    Subnet Mask: " + address.getNetworkPrefixLength() + " bits");
                        // Check if getBroadcast() returns a valid address
                        if (address.getBroadcast() != null) {
                            System.out.println("    Broadcast: " + address.getBroadcast().getHostAddress());
                        } else {
                            System.out.println("    Broadcast: N/A"); // Or any other appropriate message
                        }
                    }
                }
            }
        
        }
        // Catch block to handle SocketException and UnknownHostException
        catch(SocketException | UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
