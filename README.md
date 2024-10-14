# 📡 Network Interfaces Tool

Welcome to the **Network Interfaces Tool** 🌐 — a Java application that retrieves and displays information about the network interfaces available on your local machine. This tool lists each interface's display name, hardware (MAC) address, associated IP addresses, and broadcast addresses. 🚀

## 📝 Features

- 🖥️ **Interface Details**: Retrieve and display the display name and MAC address of a specified network interface.
- 🌍 **IP Address Information**: Lists all associated IP addresses for the specified interface.
- 📡 **Broadcast Address Information**: Displays the broadcast addresses associated with each network interface.
- 🔄 **MTU Information**: Provides the Maximum Transmission Unit (MTU) for each network interface.
- 🛠️ **Support for Loopback Interfaces**: Special handling for loopback interfaces, including the loopback IP address.

---

## 🚀 Getting Started

### 1️⃣ **Prerequisites**

Ensure you have the following installed:

- ☕ **Java JDK** (Java Development Kit) — Version 8 or above.

### 2️⃣ **Installation**

Clone the repository and navigate to the folder:

```bash
git clone https://github.com/sean-njela/network_interfaces_tool.git
cd network_interfaces_tool
```

### 3️⃣ **Usage**

To use the tool, run the compiled Java program with the name of the network interface as an argument:

```bash
java Interfaces <interface-name>
```

🛑 **Note**: You must provide exactly one argument — the name of the network interface. The application will automatically handle the rest.

---

## 📂 Tool Details

- The tool outputs information about the specified network interface, including:
  - Display Name
  - MAC Address
  - Associated IP Addresses
  - Subnet Masks
  - Broadcast Addresses
  - MTU Values

### Example Output:

```bash
$ java Interfaces eth0
Interface: eth0
MAC Address: [0, 26, 94, 122, 146, 89]
IP Addresses:
- 192.168.1.10
MTU: 1500
  - IP Address: 192.168.1.10
    Subnet Mask: 24 bits
    Broadcast: 192.168.1.255
```

---

## ⚠️ Error Handling

- 🚫 **Interface Not Found**: If the specified network interface does not exist, an error message will be displayed:

  ```bash
  Interface not found: <interface-name>
  ```

- 🛑 **Invalid Argument**: If the program is run without the required argument, you’ll see:

  ```bash
  Please enter only 1 argument (interface name)
  ```

- ⚠️ **Network Errors**: Any network-related issues will yield an appropriate error message.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## ❤️ Contributions

Feel free to submit pull requests or raise issues. Contributions are always welcome!

---

## 👤 Author

**TNjela**

- GitHub: [@seannjela](https://github.com/sean-njela/network_interfaces_tool.git)
- Project Link: [@Project_link](https://roadmap.sh/projects/network-interfaces-tool)

---

## 🎉 Acknowledgements

Feel free to contribute with enhancements and additional features!

Happy Networking! 🎉
