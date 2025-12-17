import java.util.Scanner;

/**
 * Handles interactive navigation of the file system
 * This class reads commands from standard input, interprets them,
 * and invokes operations on the current directory node.
 */
public class Navigator {

    private final FileSystemTree fileSystem;
    private FolderNode currentDirectory;
    private boolean shouldExit;

    /**
     * Constructs a navigator for a given file system tree.
     * The starting location is the root directory.
     */
    public Navigator(FileSystemTree fst) {
        this.fileSystem = fst;
        this.currentDirectory = fst.getRoot();
    }

    /**
     * Starts a command loop that repeatedly reads a line of input,
     * interprets it as a command with arguments, and executes it until
     * a request to terminate is received.
     */
    public void run() {
        shouldExit = false;
        Scanner kb = new Scanner(System.in);

        while (!shouldExit) {
            // Prompt can be customized to show current path if desired.
            String line = kb.nextLine();
            processUserInputString(line);
        }

        kb.close();
    }

    /**
     * Changes the current directory based on a single path argument.
     * Behavior should mirror typical Unix shells:
     *   - "."  refers to the current directory (no change).
     *   - ".." moves to the parent directory (if one exists).
     *   - Paths starting with "/" are interpreted from the root directory.
     *   - Other paths are interpreted relative to the current directory.
     */
    private void cd(String[] args) {
        try {
            String[] moves;
            if (args[0].substring(0,1).equals("/")) {
                currentDirectory = fileSystem.getRoot();
                moves = args[0].substring(1).split("/");
            } if (args[0].length() == 1) {
                return;
            } else {
                moves = args[0].split("/");
            }
            for (String move : moves) {
                if (move.equals(".")) continue;
                if (move.equals("..")) {
                    currentDirectory = currentDirectory.getParent();
                    continue;
                } if (currentDirectory.getChildByName(move) == null || !currentDirectory.getChildByName(move).isFolder()) {
                    throw new Exception("cd: not a directory: " + move);
                }
                else {
                    currentDirectory = (FolderNode) currentDirectory.getChildByName(move);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lists all items contained directly in the current directory.
     * Output formatting can mirror typical file system listings.
     */
    private void ls(String[] args) {
        for (FileSystemNode Node : currentDirectory.getChildren()) {
            System.out.print(Node.getName());
            if (Node.isFolder()) System.out.println("/");
            else System.out.println("");
        }
    }

    /**
     * Creates a new directory inside the current directory using the provided name.
     */
    private void mkdir(String[] args) {
        try {
            currentDirectory.addFolder(args[0]);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Creates a new file inside the current directory with a given name and size.
     */
    private void touch(String[] args) {
        try {
            currentDirectory.addFile(args[0], Integer.parseInt(args[1]));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Searches the current directory and its descendants for nodes with a given name
     * and prints their paths.
     */
    private void find(String[] args) {
        System.out.println(currentDirectory.containsName(args[0]) + "/" + args[0]);
    }

    /**
     * Prints the absolute path of the current directory, from the root to this node.
     */
    private void pwd(String[] args) {
        System.out.println(currentDirectory.toString());
    }

    /**
     * Displays the contents of the current directory as a tree, optionally
     * respecting flags or depth limits if provided by the arguments.
     */
    private void tree(String[] args) {
        // System.out.println(currentDirectory.getName());
        printTree(currentDirectory, "");
    }

    private void printTree(FolderNode folder, String lines) {
        int length = folder.getChildren().size();
        for (int i = 0; i < length; i++) {
            FileSystemNode node = folder.getChildren().get(i);
            System.out.print(lines);
            System.out.print("|---");
            System.out.println(node.getName());
            if (node.isFolder() && i == length-1) {
                printTree((FolderNode) node, (lines + "    "));
            } if (node.isFolder() && i != length-1) {
                printTree((FolderNode) node, (lines + "|   "));
            }
        }
       
    }

    /**
     * Prints how many nodes (files and folders) exist in the current directory
     * and all of its subdirectories.
     */
    private void count(String[] args) {
        System.out.println(currentDirectory.getTotalNodeCount()-1);
    }

    /**
     * Prints the total size of all files reachable from the current directory.
     */
    private void size(String[] args) {
        System.out.println(currentDirectory.getSize());
    }

    /**
     * Prints the depth of the current directory, defined as the number of edges
     * from the root directory down to this directory.
     */
    private void depth(String[] args) {
        System.out.println(currentDirectory.getDepth());
    }

    /**
     * Prints the height of the current directory, defined as the longest downward
     * distance from this directory to any file or subdirectory beneath it.
     * An empty directory has value 0.
     */
    private void height(String[] args) {
        System.out.println(currentDirectory.getHeight());
    }

    /**
     * Signals that the interactive loop should terminate after the current command.
     */
    private void quit(String[] args) {
        shouldExit = true;
    }

    /**
     * Interprets a line of user input by splitting it into a command and arguments,
     * then forwarding control to the appropriate helper method.
     *
     * Example inputs and how they are interpreted:
     *   "ls"
     *       -> command: "ls"
     *          args: []
     *
     *   "mkdir docs"
     *       -> command: "mkdir"
     *          args: ["docs"]
     *
     *   "touch notes.txt 100"
     *       -> command: "touch"
     *          args: ["notes.txt", "100"]
     *
     *   "cd .."
     *       -> command: "cd"
     *          args: [".."]
     */
    public void processUserInputString(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        String[] parts = line.trim().split("\\s+");
        String command = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        switch (command) {
            case "cd":
                cd(args);
                break;
            case "ls":
                ls(args);
                break;
            case "mkdir":
                mkdir(args);
                break;
            case "touch":
                touch(args);
                break;
            case "find":
                find(args);
                break;
            case "pwd":
                pwd(args);
                break;
            case "tree":
                tree(args);
                break;
            case "count":
                count(args);
                break;
            case "size":
                size(args);
                break;
            case "depth":
                depth(args);
                break;
            case "height":
                height(args);
                break;
            case "quit":
                quit(args);
                break;
            default:
                // Unknown commands can be reported back to the user.
                System.out.println("Unrecognized command: " + command);
        }
    }
}
